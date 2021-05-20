DROP DATABASE medihomesdb;
CREATE DATABASE IF NOT EXISTS medihomesdb;
use medihomesdb;

# 병원db // 번호, 지역, 병원이름, 등급, 위도, 경도, 이미지 이름
DROP TABLE IF EXISTS medihosptal;
CREATE TABLE IF NOT EXISTS medihosptal(
	no INT(10) primary key,
    area VARCHAR(20) NOT NULL,
    name VARCHAR(100) NOT NULL,
    disease VARCHAR(20) NOT NULL,
    grade VARCHAR(20) NOT NULL,
    lat VARCHAR(100) NOT NULL,
    log VARCHAR(100) NOT NULL,
    img VARCHAR(100) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;
select * from medihosptal limit 0, 10000;

# 의료장비보유병원db // 병원 db와 동일
DROP TABLE IF EXISTS mediinstruments;
CREATE TABLE IF NOT EXISTS mediinstruments(
    no INT(10) primary key,
    area VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    instruments VARCHAR(50) NOT NULL,
    lat VARCHAR(100) NOT NULL,
    log VARCHAR(100) NOT NULL,
    img VARCHAR(100) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;
select * from mediinstruments limit 0, 10000;

# 건강정보 번호, 이름, 설명, 이미지파일이름
DROP TABLE IF EXISTS medihealthinfo;
CREATE TABLE IF NOT EXISTS medihealthinfo(
    no INT(10) primary key,
    titles VARCHAR(20) NOT NULL,
    contents VARCHAR(100) NOT NULL,
    img VARCHAR(100) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;
select * from medihealthinfo limit 0, 10000;

# 증상백과
DROP TABLE IF EXISTS mediencyclopedia;
CREATE TABLE IF NOT EXISTS mediencyclopedia(
	no INT(10) primary key,
    type  varchar(10) NOT NULL,
    data1 VARCHAR(100) NOT NULL,
    case1 VARCHAR(100) NOT NULL,
    case2 VARCHAR(50) NOT NULL,
    case3 VARCHAR(100) NOT NULL,
    case4 VARCHAR(100) NOT NULL,
    img VARCHAR(100)  NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
COMMIT;
select * from mediencyclopedia limit 0, 10000;
