'''
Created on 2021. 4. 30.

@author: USER
'''

from bs4 import BeautifulSoup


import requests
import time
import pymysql

#localhost", "root", "12345678", "pythondb

conn = pymysql.connect(host='localhost', user = 'root', password='12345678', db = 'spring',charset = 'utf8')
curs = conn.cursor(pymysql.cursors.DictCursor)

headers = {"User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36 Edg/90.0.818.51"}

def HealthInfo(num): 
    for x in range(1, num+1):
        url = "http://www.amc.seoul.kr/asan/healthinfo/mealtherapy/mealTherapyList.do?pageIndex={}&searchCondition=&searchKeyword=&mtId=".format(x)
        
        res = requests.get(url, headers=headers)
        res.raise_for_status()
        soup = BeautifulSoup(res.text, "lxml")
    
        #page = urlopen(url)
        #soup = BeautifulSoup(page, "html.parser")
        items = soup.select("#listForm > div > div > ul > li")
         
        
        for idx, item in enumerate(items): 
            
            titles1 = item.select("dt")
            titles = [title.get_text().strip() for title in titles1]
            rows1 = item.select_one("dd")
            contents = [row.strip() for row in rows1]   
            
            
            
            # 이미지 저장하기
            images = item.find("img")
            image_url = images.get("src")
            if image_url.startswith("/"):
                image_url = "http://www.amc.seoul.kr" + image_url
            img_num = (x - 1) * 10
            image_res = requests.get(image_url)
            image_res.raise_for_status()
            
            with open("./health_images/health_{}.jpg".format(img_num+idx+1), "wb") as f:
                f.write(image_res.content)
                f.close()
            no = img_num+idx+1
            img = "health_{}.jpg".format(img_num+idx+1)
           
            
            sql = "insert into health_info values (%s, %s, %s, %s)"
            val = (no, titles, contents, img)                    
            curs.execute(sql, val)
            
        print(url)
        time.sleep(0.2)   
    conn.commit() #commit을 치는 부분입니다. 
    conn.close()
    print("commit완료")

# 키워드, 페이지수, 

if __name__ == "__main__":
    # 가슴 type = 1
    
    HealthInfo(11)
   
    
    
    
    
    
    
    
    
    
    
    