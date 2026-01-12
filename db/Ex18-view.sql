use kamebook;

-- view
create view simple_members as select memid, memname, addr, mileage, stat from member;
select * from simple_members;

create view order_stats_by_member as
select m.memid, m.memname, sum(od.unitprice * od.qty) `주문 총액`, avg(od.unitprice * od.qty) `평균 주문액`
from member m inner join order_h oh on m.memid = oh.memid 
inner join order_d od on oh.orderno = od.orderno 
group by m.memid, m.memname order by m.memid;
select * from order_stats_by_member;