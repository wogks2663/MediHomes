'''
Created on 2021. 4. 30.

@author: USER
'''

import pandas as pd

#
df = pd.read_json("pandas.json")

df2 = pd.read_csv("data.csv")

# 중복 데이터 제거
symptom = df.drop_duplicates(['case1'])

# 증상 한개한개를 리스트로 만들기
symptom_list = symptom['case1'].values.tolist()

print('무증상' in df2['case1'][0])

for i in range(len(symptom_list)):
    def fine(x):
        if  symptom_list[i] in x:
            return 1
        else:
            return 0
    
    df2[symptom_list[i]] = df2['case1'].apply(fine)

print(df2.head())  

# 간단히 출력
#print(df2)

# csv로 저장
df2.to_csv('./test.csv')