use kamebook;

-- 주문 총액이 10000 초과인 고객 조회.
select distinct m.* from order_h oh 
inner join member m on oh.memid = m.memid 
where oh.ordamt > 10000; 
-- 10000 초과하여 주문한 고객들
select distinct memid from order_h where ordamt > 10000; 
-- 위 조회 결과 사용
select *
from member m
where m.memid in ('hong1', 'hong2');
--
select *
from member m
where m.memid in (select distinct memid from order_h where ordamt > 10000);

-- 주문을 취소한 고객 -- 서브커리의 결과가 단일 값이 경우 = 로 비교
select *
from member m
where m.memid = (select distinct memid from order_h where cancelyn = 'y');
-- 취소되지 않는 주문 중에서 ' 'park'
select * from order_h where cancelyn != 'Y' and memid = 'park';
-- 인라인 뷰 : from 절에서 사용된 서브쿼리
select *
from (
	select *
	from order_h
	where cancelyn != 'y'
) s -- 인라인 뷰는 반드시 별칭을 지정해야 한다.
where memid = 'park';

-- 주문번호, 상품코드, 상품주문총액, 주문총액 조회.
-- scalar subquery : select 절에 포함되는 서브쿼리.
-- 상관부속질의 correlative subquery : 서브쿼리에서 메인쿼리의 데이터를 사용.
select orderno, goodscd, amt, 
(select sum(amt) from order_d so where so.orderno = mo.orderno) `주문 총액`
from order_d mo;

-- exists : 대상 서브쿼리의 조회 결과가 있으면 true, 없으면 false.
select * from member m
-- where exists (select * from order_h where memid = 'abc');
-- where exists (select * from order_h where memid = 'hong1');
where exists (select * from order_h oh where oh.memid = m.memid); -- Taeh 는 order_h 테이블에 존재하지 않으므로 안 나옴.
																  -- * 는 모든 열(column).

-- 서브쿼리의 결과가 여러 개일 때 ...                                                               
-- any : ... or ... or ...
-- all : ... and ... and ...
-- select (ordamt) from order_h where memid = 'park' -- 20000, 30000, 1000
select * from order_h oh where oh.ordamt > any (select (ordamt) from order_h where memid = 'park'); 
select * from order_h oh where oh.ordamt > all (select (ordamt) from order_h where memid = 'park');
