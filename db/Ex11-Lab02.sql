use labdb;

-- 1. 모든 도서의 이름과 가격.
describe book;
select bookname, price from book;

-- 2. 모든 도서의 도서번호, 도서이름, 출판사, 가격.
select bookid, bookname, publisher, price from book;

-- 3. 도서 테이블에 있는 모든 출판사 중복을 제거하고 검색.
select distinct publisher from book;

-- 4. 가격이 20000원 미만인 도서를 검색.
select bookname, price from book where price < 20000;

-- 5. 가격이 10000원 이상 20000 이하인 도서를 검색.
select bookname, price from book where price between 10000 and 20000;

-- 6. 출판사가 '굿스포츠' 혹은 '대한미디어'인 도서를 검색.
select * from book where publisher in ('굿스포츠', '대한미디어') order by publisher;

-- 7. '축구의 역사'를 출간한 출판사를 검색.
select bookname, publisher from book where bookname = '축구의 역사'; 

-- 8. 도서이름에 '축구'가 포함된 출판사를 검색.
select bookname, publisher from book where bookname like '%축구%';

-- 9. 축구에 관한 도서 중 가격이 20000원 이상인 도서를 검색.
select bookname, price from book where bookname like '%축구%' and price >= 20000;

-- 10. 도서를 이름순으로 검색.
select bookname from book order by bookname;

-- 11. 도서를 가격순으로 검색하고, 가격이 같으면 이름순으로 검색.
select bookname, price from book order by price desc, bookname;

-- 12. 도서를 가격의 내림차순으로 검색. 만약 가격이 같다면 출판사의 오름차순으로 검색.
select bookname, price, publisher from book order by price desc, publisher asc;

-- 13. 고객이 주문한 도서의 총 판매액.
describe orders;
select sum(saleprice) from orders;

-- 14. 김연아 고객이 주문한 도서의 총 구매액. 먼저 custid 조회, 그 다음 판매액 조회.
select custid, name, address from customer where name = '김연아';
select custid, sum(saleprice) from orders where custid = 2;

-- 15. 고객이 주문한 도서의 총 판매액, 평균값, 최저가, 최고가 구하기.
select sum(saleprice) 총판매액, avg(saleprice) 평균값, min(saleprice) 최저가, max(saleprice) 최고가 from orders;

-- 16. 도서 판매 건수.
select count(*) 판매건수 from orders;
select count(orderid) from orders;

-- 17. 도서별 판매 건수.
select bookid, count(orderid) from orders group by bookid; 

-- 18. 고객별로 주문한 도서의 총 수량과 총 판매액.
select custid, count(orderid), sum(saleprice) from orders group by custid;

-- 19. 가격이 8000원 이상인 도서를 구매한 고객에 대하여 고객별 주문 도서(8000원 이상 도서)의 총 수량. (단, 두 권 이상 구매한 고객만.)
select custid, count(orderid) from orders
where saleprice >= 8000 group by custid having count(saleprice) >= 2;
