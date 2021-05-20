'''
Created on 2021. 5. 9.

@author: clomia2
'''
from flask import Flask, request
from tensorflow import keras
import numpy as np 
import pandas as pd

# Access-Control-Allow-Origin에 대한 처리
from flask_cors import CORS

# Flask 객체 생성
app = Flask(__name__)

# Access-Control-Allow-Origin에 대한 처리
CORS(app)

# 스프링에서 오는 회원 리스트 요청을 json으로 응답하는 함수
@app.route("/selfTest", methods=["POST"])
def selfTest():
    # 증상 받기    
    symptom = request.form.get("symptom")
    print("symptom : ",symptom)
    
    # 증상 머신러닝 데이터로 치환
    test_data = changeFormat(symptom)
    
    # 머신러닝으로 예측
    result = selfTestMechineLearning(test_data)
        
    # 병명 글지로 바꾸기
    disease = diseaseNameSearch(result-1)
    
    return disease   


# 증상을 머신러닝 데이터로 바꾸기
def changeFormat(data):
    # 증상 데이터 불러오기
    df = pd.read_json("../testData/symptom.json")
    
    # 증상 중복 데이터 제거
    symptom = df.drop_duplicates(['case1'])

    # 증상 한개한개를 리스트로 만들기
    symptom_list = symptom['case1'].values.tolist()
    #print("symptom_list:",symptom_list)
    
    # return data 선언
    test_data = []
    
    # 증상 분할 및 전처리
    data_spilt = data.split(',')
    for j in range(len(data_spilt)):
        data_spilt[j] = data_spilt[j].strip()
    #print("data_spilt:",data_spilt)
    #증상 갯수 for
    for i in range(len(symptom_list)):             
        if  symptom_list[i] in data_spilt:
                test_data.append(1)
        else:
            test_data.append(0)
    
    test_data = [test_data]
    print("test_data : ",test_data)
    # 예측 데이터 반환
    # [[1, 0, 0, ...,1, 0]]
    return test_data

def diseaseNameSearch(result):
    df = pd.read_csv("../testData/diseaseData.csv", encoding="cp949")
    print('df["data1"][result] : ',df["data1"][result])
    return df["data1"][result]

def selfTestMechineLearning(result):
    model = keras.models.load_model("../model_save/machinelearning.h5")
    #test_loss, test_acc = model.evaluate(X, Y)
    #print("evaluate accuracy ", test_acc)
    predictions = model.predict(result)
    print(predictions[0])
    print("유력후보 : ", np.argmax(predictions[0]))
    return np.argmax(predictions[0])

if __name__ == "__main__":    
    app.run(host="0.0.0.0", port=9000, debug=True)
    