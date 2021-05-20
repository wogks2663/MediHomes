'''
Created on 2021. 4. 30.

@author: USER
'''

from bs4 import BeautifulSoup


import requests
import time
import pymysql
import urllib.parse as parse
#localhost", "root", "12345678", "pythondb

conn = pymysql.connect(host='localhost', user = 'root', password='12345678', db = 'spring',charset = 'utf8')
curs = conn.cursor(pymysql.cursors.DictCursor)

headers = {"User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36 Edg/90.0.818.51"}

def Epidemiology(type, num, Id,  keyword): 
    for x in range(1, num+1):
        url = "http://www.amc.seoul.kr/asan/healthinfo/disease/diseaseList.do?pageIndex={}&partId={}&diseaseKindId=&searchKeyword={}".format(x, Id, parse.quote(keyword))
        
        res = requests.get(url, headers=headers)
        res.raise_for_status()
        soup = BeautifulSoup(res.text, "lxml")
    
        #page = urlopen(url)
        #soup = BeautifulSoup(page, "html.parser")
        items = soup.select("#listForm > div > div > ul > li")
         
        
        for idx, item in enumerate(items): 
            
            titles1 = item.select("strong")
            titles = [title.get_text().strip() for title in titles1]
            rows1 = item.select("dt")
            rows = [row.get_text().strip() for row in rows1]   
            columns1 = item.select("dd")
            columns = [column.get_text().strip() for column in columns1]
            case1 = ""
            case2 = ""
            case3 = ""
            case4 = ""
            
            # 이미지 저장하기
            images = item.find("img")
            image_url = images.get("src")
            if image_url.startswith("/"):
                image_url = "http://www.amc.seoul.kr" + image_url
            img_num = (x - 1) * 20
            image_res = requests.get(image_url)
            image_res.raise_for_status()
            
            with open("./images/{}_{}.jpg".format(type, img_num+idx+1), "wb") as f:
                f.write(image_res.content)
                f.close()
                
            img = "{}_{}.jpg".format(type, img_num+idx+1)
            for l in range(len(rows)):
            
                
               
                data2 = rows[l]
                data2_ = data2.replace(" ", "")
                data3 = columns[l]
                data3_ = data3.replace("\n", "")
                data3__ = data3_.replace("\t", "")
                data3___ = data3__.replace("\r", "")
                data4 = data2_ + " : " + data3___   
                
                if (data4[0] == "증"):
                    case1 = data3___
                
                if (data4[0] == "관"):
                    case2 = data3___
                
                if (data4[0] == "진"):
                    case3 = data3___
                    
                if (data4[0] == "동"):
                    case4 = data3___
                    
           
            sql = "insert into disease01 values (%s, %s, %s, %s, %s, %s, %s)"
            val = (type, titles, case1, case2, case3, case4, img)                    
            curs.execute(sql, val)
            
        print(url)
        time.sleep(2)   
    conn.commit() #commit을 치는 부분입니다. 
    conn.close()
    print("commit완료")

# 키워드, 페이지수, 

if __name__ == "__main__":
    # 가슴 type = 1
    
    Epidemiology(1, 8, "B000020","가슴")
    
    
    '''
    Epidemiology(2, 7, "B000001","골반")
    Epidemiology(3, 2, "B000002","귀")
    Epidemiology(4, 1, "B000003","기타")
    Epidemiology(5, 4, "B000004","눈")
    Epidemiology(6, 3, "B000005","다리")
    Epidemiology(7, 2, "B000006","등%2F허리")
    Epidemiology(8, 7, "B000007","머리")
    Epidemiology(9, 3, "B000008","목")
    Epidemiology(10, 2, "B000009","발")
    Epidemiology(11, 11, "B000010","배")
    Epidemiology(12, 5, "B000011","생식기")
    Epidemiology(13, 2, "B000012","손")
    Epidemiology(14, 1, "B000021","얼굴")
    Epidemiology(15, 2, "B000013","엉덩이")
    Epidemiology(16, 1, "B000014","유방")
    Epidemiology(17, 3, "B000015","입")
    Epidemiology(18, 19, "B000016","전신")
    Epidemiology(19, 2, "B000017","코")
    Epidemiology(20, 2, "B000018","팔")
    Epidemiology(21, 5, "B000019","피부")
    '''
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    