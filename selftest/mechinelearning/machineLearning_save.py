# multinomial Classification

import pandas as pd
import numpy as np
import tensorflow as tf



# 질병 예측 함수
def searchDisease(data):
    
    # csv 파일 읽기
    sy_data = pd.read_csv('test.csv', encoding='utf-8')
        
    # 앞에 unnamed열 제거
    sy_data.drop(['Unnamed: 0'], axis = 1, inplace = True)
    
    ## 데이터 전처리
     
    X_data = pd.DataFrame(sy_data).loc[:, '기침' : '불규칙한 반흔']
    Y_data = pd.DataFrame(sy_data)['no']
    for j in range(0, 200):
        if j == 0:
            result1 = pd.concat([X_data, X_data])
            result2 = pd.concat([Y_data, Y_data])
        else:
            result1 = pd.concat([result1, X_data])
            result2 = pd.concat([result2, Y_data])
    
    print(X_data)
    print(Y_data)
   
    X = np.array(pd.DataFrame(result1))
    Y = np.array(pd.DataFrame(result2))
    
    test_data = []
    test_data.append(data)
    
    model = tf.keras.Sequential([
        tf.keras.layers.Dense(320, activation="relu", input_shape=(850, )),
        tf.keras.layers.Dense(320, activation="relu"),
        tf.keras.layers.Dense(320, activation="relu"),
        tf.keras.layers.Dense(160, activation="relu"),
        
        tf.keras.layers.Dense(units=1628, activation="softmax") 
    ])

    opti = tf.keras.optimizers.SGD(lr=0.05)
    
    model.compile(loss="sparse_categorical_crossentropy", 
    optimizer=opti, metrics=["accuracy"])
    # 모델의 요약 정보를 출력
    model.summary()
   
    model.fit(X, Y, epochs=20, validation_data=(X, Y))
    
    model.save("./model_save/machinelearning.h5")
    print("모델 저장 완료")



    
    
    test_loss, test_acc = model.evaluate(X, Y)
    print("evaluate accuracy ", test_acc)
 
    #load_model = joblib.load(name)
    predictions = model.predict(test_data)
    print(predictions[0])
    print(np.argmax(predictions[0]))
    
    
    print("모델 저장 완료")
                
if __name__ == "__main__":
    
    data = []
    for i in range(0, 850):
        if 7 < i <= 10:
            data.append(1)
        else:
            data.append(0)
        """if i >= 10:
            if i % 10 == 0:
                data.append(1)
            else:
                data.append(0)
        else:
            data.append(0)"""
    
    print(data)
    
    searchDisease(data)

    


