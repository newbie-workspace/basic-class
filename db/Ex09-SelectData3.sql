use kamebook;
select * from order_h;

-- 전체 주문 총액, 평균, 최고 주문액, 최저 주문액, 주문 건수 (집계함수)
select sum(ordamt), avg(ordamt), max(ordamt), min(ordamt), count(ordamt) from order_h;

-- 고객별 주문 총액, 평균, 최고 주문액, 최저 주문액, 주문 건수 (집계함수)
select memid, sum(ordamt), avg(ordamt), max(ordamt), min(ordamt), count(ordamt) from order_h group by memid;

-- 고객별 주문 총액, 평균, 최고 주문액, 최저 주문액, 주문 건수 (집계함수)
select memid, sum(ordamt), avg(ordamt), max(ordamt), min(ordamt), count(ordamt) from order_h group by memid order by max(ordamt) desc;

-- 주문 건수가 2건 이상인 고객의 주문 총액, 평균, 최고 주문액, 최저 주문액, 주문 건수 (집계함수)
-- select memid, sum(ordamt), avg(ordamt), max(ordamt), min(ordamt), count(ordamt) from order_h where count(ordamt) >= 2 group by memid;
-- 오류 : group by 이후에 집계함수 사용이 가능. 
select memid, sum(ordamt), avg(ordamt), max(ordamt), min(ordamt), count(ordamt) 
from order_h group by memid having count(ordamt) >= 2;
-- having : group by 이후에 실행하는 조건절. 