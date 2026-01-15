
-- 1. 작업 데이터베이스 변경
use kamebook;

-- 테이블 만들기 SQL 문 형식
/*
create table `테이블 이름`
(
	컬럼이름1 자료형 [option_1, option_2, ... option_n]
    컬럼이름1 자료형 [option_1, option_2, ... option_n]
    ...
);
*/

-- 주요 자료형
/*
	문자형 : char(갯수), varchar(갯수), text\
    날짜형 : date, datetime;
	숫자형 : float, double, int, bigint
    진위형 : boolean
*/

-- primary key : 각 행의 데이터를 고유하게 식별할 수 있는 1개 이상의 열 집합.
-- 열의 속성으로 지정하거나 (단, 1개의 열)
-- [constraint pk_name] primary key (열 이름) 형식으로 지정. 

-- option 종류 :
/*
1. null or not null : 데이터가 비어 있을 수 있는지 여부 지정.
2. default (값) : 값이 없으면 자동으로 사용할 값 지정.
*/

-- current_timestamp(), now() 는 현재 시간을 반환하는 함수.
select current_timestamp(), now();

-- 2. member 테이블 만들기 (DDL)
create TABLE `member` 
(
	memid VARCHAR(9) NOT NULL,
	`memname` VARCHAR(20) NOT NULL,
	passwd VARCHAR(128) NULL, 
	`passwdmdt` DATETIME NULL,
	`jumin` VARCHAR(64) NULL COMMENT '주민등록번호',
	addr VARCHAR(100) NULL,
	`birthday` DATE NULL,
	jobcd CHAR(1) NULL,
	`mileage` DECIMAL(7,0) NULL DEFAULT '0',
	`stat` ENUM('Y','N') NOT NULL DEFAULT 'Y',
	`enterdtm` DATETIME NOT NULL DEFAULT current_timestamp(),
	`leavedtm` DATETIME NULL,
	PRIMARY KEY (`memid`)
);

-- 3. member 테이블 제거 (DDL)
drop table member;

-- 4. goodsinfo 테이블 만들기 (DDL)
CREATE TABLE `goodsinfo`
(
	`goodscd` CHAR(5) NOT NULL, 
	`goodsname` VARCHAR(20) NOT NULL,
	`unitcd` CHAR(2) NULL,
	`unitprice` DECIMAL(5,0) NOT NULL DEFAULT '0',
	`stat` ENUM('Y','N') NOT NULL DEFAULT 'Y',
	`insdtm` DATETIME NOT NULL DEFAULT current_timestamp(),
	`moddtm` DATETIME NULL,
	PRIMARY KEY (`goodscd`) USING BTREE
);

-- 5. order_h 테이블 만들기 (DDL)
CREATE TABLE `order_h` (
	`orderno` CHAR(9) primary key, -- primary key 는 자동으로 not null
	`orddt` DATE NOT NULL,
	`memid` VARCHAR(9) NOT NULL,
	`ordamt` DECIMAL(7,0) UNSIGNED NOT NULL DEFAULT '0',
	`cancelyn` ENUM('Y','N') NOT NULL DEFAULT 'N',
	`canceldtm` DATETIME NULL,
	`insdtm` DATETIME NOT NULL DEFAULT current_timestamp(),
	`moddtm` DATETIME NULL
);

-- 6. order_d 테이블 생성 (DDL)
CREATE TABLE `order_d` (
	`orderno` CHAR(9) NOT NULL,
	`goodscd` CHAR(5) NOT NULL,
	`unitcd` CHAR(2) NULL,
	`unitprice` DECIMAL(5,0) NOT NULL DEFAULT '0',
	`qty` DECIMAL(3,0) NOT NULL DEFAULT '0',
	`amt` DECIMAL(7,0) NOT NULL DEFAULT '0',
	`insdtm` DATETIME NOT NULL DEFAULT current_timestamp(),
	`moddtm` DATETIME NULL,
	PRIMARY KEY (`orderno`, `goodscd`)
);