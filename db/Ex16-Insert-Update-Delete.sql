use kamebook;
describe member;

-- insert
insert into member (memid, memname, passwd, passwdmdt)
values ('J.V', 'Jeanette Voerman', 'weak*password', now()); -- now() == current_timestamp() 
select * from member; -- primary key 는 index 가 걸려 있다. insert 한 순대로 나오지 않음.

-- 다중 행 insert
insert into member (memid, memname, passwd, passwdmdt)
values	('J.V', 'Jeanette Voerman', 'weak*password', now()),
		('T.V', 'Therese Voerman', 'weak*password', now()),
		('D.G', 'Doctor Grout', 'weak*password', now()),
		('S.L', 'Sebastian Lacroix', 'weak*password', now());

-- update : 
-- 형식 : update 테이블이름 set column1 = value1, ... where ... 
-- primary key 는 변경하지 않는다.
update member set passwd = 'new*weak*password', passwdmdt = now() where memid = 'J.V';

-- delete :
-- 형식 : delete from 테이블이름  where ...
delete from member where memid = 'J.V';
select * from member;

delete from member where enterdtm > '2025-12-25'; -- safe update mode 에 걸림. (edit -> preference)