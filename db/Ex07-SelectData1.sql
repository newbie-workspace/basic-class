-- 데이터베이스 바꾸기.
use kamebook;

-- select 형식 : [선택사항]
/*
	select column1, column2, column3, ...
    [from tableName]
    [where 조건식]
    [group by column1, column2, ...]
    [having 조건식]
    [order by column1, column2, ...]
*/

-- member table 의 모든 열의 데이터 조회.
describe member;
select memid,memname,passwd,passwdmdt,jumin,addr,birthday,jobcd,mileage,stat,enterdtm,leavedtm
from member;
select * from member; -- 모든 열은 *로 대체 가능.

-- member table 의 회원아이디, 회원이름, 주소, 생년월일 열 조회.
select memid, memname, addr, birthday from member;

-- member table 의 회원아이디, 회원이름, 주소, 생년월일 열을 이름을 변경해서 조회 -- as 는 생략 가능
select memid as '회원아이디', memname as '회원이름', addr '주소', birthday '생년월일' from member;

-- member table 의 회원아이디, 회원이름, 주소, 생년월일 열을 생년월일 순으로 정렬해서 조회.
select memid '회원아이디', memname '회원이름', addr '주소', birthday '생일' from member order by birthday desc; -- 내림차순 정렬, asc : 오름차순

-- member table 의 회원아이디, 회원이름, 주소, 생년월일 열을 이름 순으로 정렬해서 조회.
-- 같은 이름은 생년월일로 정렬.
select memid '회원아이디', memname '회원이름', addr '주소', birthday '생일' from member order by memname asc, birthday desc;

-- 회원들의 직업코드 조회
-- distinct : 중복 제거
select distinct jobcd'직업코드' from member order by jobcd;

-- (mySQL 기능) 생년월일이 빠른 회원 3명을 조회.
select * from member order by birthday asc limit 3;

-- 생년월일이 2번째로 빠른 직원부터 3명 조회.
select * from member order by birthday asc limit 1,3;

-- "[memid] memname" 형식의 결과 및 mileage 를 1000 증가한 결과 조회
select concat("[", memid, "]", memname) `아이디와 이름`, mileage + 1000 `보너스 합산 마일리지` from member;




