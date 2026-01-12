use kamebook;

select * from order_h;
select * from member;

-- Cross Join : 양쪽 테이블의 모든 행의 가능한 모든 조합 반환.
select * from member, order_h order by member.memid; -- member 와 order_h 모두 memid 를 가지고 있음.
select * from member cross join order_h order by member.memid;
select * from member m, order_h oh order by m.memid; -- 테이블에 대한 별칭 지정.

-- inner join : 두 테이블에 모두 존재하는 경우에만 조회하는 방법.
-- 주문번호, 회원아이디, 회원이름, 주소, 주문일자, 주문수량 조회.
select oh.orderno, oh.memid, m.memname, m.addr, oh.orddt, oh.ordamt 
	from member m, order_h oh where m.memid = oh.memid;
select oh.orderno, oh.memid, m.memname, m.addr, oh.orddt, oh.ordamt 
	from member m inner join order_h oh on m.memid = oh.memid;

-- 주문번호, 상품코드, 상품명, 가격, 수량 조회.
select od.orderno, od.goodscd, gi.goodsname, od.unitprice, od.qty 
	from order_d od, goodsinfo gi where od.goodscd = gi.goodscd;
select od.orderno, od.goodscd, gi.goodsname, od.unitprice, od.qty 
	from order_d od inner join goodsinfo gi on od.goodscd = gi.goodscd;

-- 주문번호, 주문일자, 상품코드, 가격, 수량, 취소여부
select oh.orderno, oh.orddt, od.goodscd, od.unitprice, od.qty, oh.cancelyn
	from order_d od, order_h oh
	where oh.orderno = od.orderno order by oh.orderno;
select oh.orderno, oh.orddt, od.goodscd, od.unitprice, od.qty, oh.cancelyn
	from order_d od inner join order_h oh
	on oh.orderno = od.orderno order by oh.orderno;

-- 주문별 주문 상품 종류의 갯수 조회
select oh.orderno, count(*) 상품종류갯수
	from order_d od, order_h oh
	where oh.orderno = od.orderno group by oh.orderno order by oh.orderno;
select oh.orderno, count(*) 상품종류갯수
	from order_d od inner join order_h oh
	on oh.orderno = od.orderno group by oh.orderno order by oh.orderno;

-- 사용자 아이디, 사용자 이름, 사용자별 주문 총액, 평균 주문
-- 직접 관계가 없는 테이블을 관계 있는 다른 테이블을 경유하여 조회 -> 3개 이상의 테이블 join
select m.memid, m.memname, sum(od.unitprice * od.qty) `주문 총액`, avg(od.unitprice * od.qty) `평균 주문액`
	from member m, order_h oh, order_d od
	where m.memid = oh.memid and oh.orderno = od.orderno
	group by m.memid, m.memname order by m.memid;
select m.memid, m.memname, sum(od.unitprice * od.qty) `주문 총액`, avg(od.unitprice * od.qty) `평균 주문액`
	from member m 
    inner join order_h oh on m.memid = oh.memid 
    inner join order_d od on oh.orderno = od.orderno
	group by m.memid, m.memname order by m.memid;
    
-- outer join : inner join 을 하는데 지정한 한 쪽 또는 양 쪽의 데이터가 모두 조회되게 하는 방식.
-- 사용자 아이디, 사용자 이름, 사용자별 주문 총액, 평균 주문액 조회 (member, order_h 사용)
select 
	m.memid, m.memname, 
    ifnull(sum(oh.ordamt), 0) `주문 총액`, -- ifnull : null 을 다른 값으로 변경하는 함수
    ifnull(avg(oh.ordamt), 0) `평균 주문액`,
    coalesce(sum(oh.ordamt), 0) `주문 주문액2`,
    coalesce(avg(oh.ordamt), 0) `평균 주문액2`
		from member m left outer join order_h oh
		on m.memid = oh.memid
		group by m.memid, m.memname order by sum(oh.ordamt) desc;
    
    
    
    
    