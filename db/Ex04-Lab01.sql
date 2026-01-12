use labdb;
create table tbl_board
(
boardno integer primary key auto_increment, -- 자동 증가 속성 지정 : auto_increment : 데이터를 새로 저장할 때 자동으로 마지막 번호 다음 번호로 채번.
writer varchar(20) not null,
title varchar(100) not null,
content varchar(2000) not null,
writedate datetime null default current_timestamp(),
modifydate datetime null default current_timestamp(),
readcount int null default 0,
deleted boolean null default false
);