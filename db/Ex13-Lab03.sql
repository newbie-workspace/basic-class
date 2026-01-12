use labdb;

--  고객별 (고객이름 같이 조회) 구매액 합계
select c.name, sum(o.saleprice)
from customer c, orders o where c.custid = o.custid
group by c.name; -- select 절에 나타나는 열은 group by 에 있어야 한다.
-- 
select c.name, c.custid, coalesce(sum(o.saleprice)) `구매액 합계`
from customer c
left outer join orders o
on c.custid = o.custid
group by c.custid, c.name; -- select 절에 나타나는 열은 group by 에 있어야 한다.

-- 고객아이디, 고객이름, 도서명, 주문 정보 ( customer, book, orders )
select c.custid, c.name, b.bookname, o.orderid, o.orderdate
from customer c, book b, orders o
where c.custid = o.custid and b.bookid = o.bookid
order by c.name;
--
select c.custid, c.name, b.bookname, o.orderid, o.orderdate
from customer c
left outer join orders o on c.custid = o.custid
left outer join book b on b.bookid = o.bookid
order by o.orderdate desc;

-- 박지성이 구매한 도서의 출판사 수 ( customer, orders, book )
select count(distinct b.publisher) `출판사 수`
from customer c, book b, orders o
where c.custid = o.custid and b.bookid = o.bookid and c.name = '박지성'
group by c.name;
--
select count(distinct b.publisher) `출판사 수`
from customer c inner join orders o on c.custid = o.custid
inner join book b on b.bookid = o.bookid
where c.name = '박지성' group by c.name;

-- 박지성이 구매한 도서의 이름, 가격, 정가와 판매가격의 차이 ( customer, orders, book )
select b.bookname, b.price 정가, b.price - o.saleprice `정가 - 판매가`
from customer c, book b, orders o
where c.custid = o.custid and b.bookid = o.bookid and c.name = '박지성';
--
select b.bookname, b.price 정가, b.price - o.saleprice `정가 - 판매가`
from customer c inner join orders o on c.custid = o.custid
inner join book b on b.bookid = o.bookid
where c.custid = o.custid and b.bookid = o.bookid and c.name = '박지성';

-- 박지성이 구매하지 않은 도서의 이름 ( customer, orders, book )
select distinct b.*
from book b left outer join orders o on o.bookid = b.bookid
left outer join customer c on o.custid = c.custid
where c.name <> '박지성' or c.custid is null;

-- 도서의 가격(Book 테이블)과 판매가격(Orders 테이블)의 차이가 가장 많은 주문 ( book, orders )
select max(b.price - o.saleprice)
from book b, orders o
where b.bookid = o.bookid
group by (b.price - o.saleprice);
--
select o.orderid, max(b.price - o.saleprice)
from book b inner join orders o on b.bookid = o.bookid
group by o.orderid;

-- 도서의 판매액 평균보다 자신의 구매액 평균이 더 높은 고객의 이름 ( orders, customer )
select c.name, avg(o.saleprice) `판매액 평균`, avg(b.price) `구매액 평균`
from customer c, orders o, book b
where c.custid = o.custid and b.bookid = o.bookid
group by c.name having avg(o.saleprice) < avg(b.price);


