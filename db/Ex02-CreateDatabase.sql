
-- 1. 데이터베이스 만들기. (DDL : data definition language)
CREATE DATABASE `kamebook`; -- 무조건 생성.
CREATE DATABASE IF NOT EXISTS`kamebook`; -- 없으면 생성.
create database if not exists labdb;

-- 2. 데이터베이스 제거. (DDL)
DROP DATABASE `kamebook`; -- 무조건 제거.
DROP DATABASE IF EXISTS `kamebook`; -- 있으면 제거.

-- 3. 새로 만든 데이터베이스에 대한 사용 권한 부여.
create database `kamebook`;
grant all privileges on kamebook.* to human@localhost;
grant all privileges on kamebook.* to human@"%";
grant all privileges on labdb.* to human@localhost;
grant all privileges on labdb.* to human@"%";