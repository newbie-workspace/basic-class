use labdb;

-- 1. '박지성' 고객의 구매 총액
select '박지성', sum(saleprice) `구매 총액` from orders where custid in 
(select custid from customer where name = '박지성');

-- 2. 가장 비싼 도서의 이름을 조회 ( book 테이블 사용 )
select bookname from book where price in (select max(price) from book);

-- 3. 구매실적이 있는 고객 조회
select name from customer where custid in (select distinct custid from orders);

-- 4. 대한미디어 출판사에서 출간한 도서를 구매한 고객 조회 ( book, orders, customer )
select name from customer where custid in 
	(select custid from orders where bookid in 
		(select bookid from book where publisher = '대한미디어')
	);