-- 작업 데이터베이스 변경 : labdb
use labdb;

-- 테이블 목록 조회
show tables;

-- 테이블 정보 조회 : tbl_board
describe tbl_board;

-- 데이터 삽입 : 
-- auto_increment 열은 생략 가능하다. (자동으로 값 생성)
insert into tbl_board	(boardno, writer, title, content)
values	(1, 'iamuserone', '첫 번째 게시글', '글쓰기 연습');
insert into tbl_board	(boardno, writer, title, content)
values	(10, 'iamuserone', '두 번째 게시글', '글쓰기 연습2');
-- ----------------------------
insert into tbl_board	(writer, title, content) 
values	('iamuserone', '세 번째 게시글', '글쓰기 연습3');
insert into tbl_board	(writer, title, content)
values	('iamuserone', '네 번째 게시글', '글쓰기 연습4');

