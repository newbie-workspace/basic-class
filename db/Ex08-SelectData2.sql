use kamebook;

select * from member;

-- 마일리지가 0이 아닌 회원 조회
select * from member where mileage <> 0; 
-- where mileage != 0;

-- 마일리지가 0인 회원 조회
select * from member where mileage = 0; 
-- SQL 에서 동일성 비교 연산자로 = 만 사용 (자바는 ==)

-- 2000년 이후에 출생한 회원 조회
select * from member where birthday >= "2000-01-01"; 
-- 문자열과 날짜를 표현할 때 작은 따옴표

-- 2002년에 출생한 회원 조회
select * from member where birthday between '2002-01-01' and '2002-12-31';
-- where birthday >= '2002-01-01' and birthday <= '2002-12-31';
-- where birthday >= '2002-01-01' && birthday <= '2002-12-31'; 공식 표현은 아님.

-- 직업코드가 1, 4, 9인 회원
select * from member where jobcd in (1, 4, 9); 
-- where jobcd = 1 or jobcd = 4 or jobcd = 9;

-- 직업코드가 1, 4, 9가 아닌 회원
select * from member where jobcd not in (1, 4, 9); 
-- where not (jobcd = 1 or jobcd = 4 or jobcd = 9);
-- where jobcd <> 1 and jobcd <> 4 and jobcd <> 9;

-- 인천에 거주하는 회원 조회. (부분 일치 검색)
select * from member where addr like '인천%'; -- addr 열에 그 값으로'인천'을 포함하는 인스턴스 고르기
-- 이 경우 인천 앞에 다른 단어가 나올 일이 없으므로 앞 부분에 %를 생략. -> 성능 고려
-- where addr like '%인천%'; '인천'을 포함하는...

-- 이름에 '갑'이 포함된 회원 조회.
select * from member where memname like '%갑%';

-- 이름의 두번째 글자가 '갑'인 회원 조회.
select * from member where memname like '_갑%';z 
-- % 는 0개 이상의 문자. _ 는 한 개의 문자.

-- 주민번호가 없는 회원 조회.
select * from member where jumin is null; -- SQL 에서 null 은 정해진 데이터가 아니므로 = 으로 비교할 수 없음.
select * from member where mileage is not null;