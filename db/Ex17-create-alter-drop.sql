use kamebook;

create table person ( 
	pno int not null,
    pname varchar(30) not null,
    phone varchar(15) null,
    email varchar(50) null,
    address varchar(100) null,
    age int not null check(age > 14),
    gender varchar(10) not null check(gender in ('male', 'female')),
    regidate datetime default(now())
);

-- alter : 테이블 수정.
alter table person add column company varchar(50) null;
describe person;
alter table person change column company `company changed` varchar(100) null;
alter table person drop column `company changed`;
alter table person add column company varchar(50) null;
alter table person modify column company varchar(150) null;

-- drop : 테이블 제거
drop table person;

/*///////////////////////////////////////////////////////////////////////////////////////////////////*/

-- create with primary key and foreign key (관계를 맺는 열)

CREATE TABLE `order_h2` (
	`orderno` CHAR(9) primary key, 
	`orddt` DATE NOT NULL,
	`memid` VARCHAR(9) NOT NULL references member(memid), -- foreign key : 자료형이 일치해야함. Oracle 에서는 되는데 mysql에서는 실제 효과 없음.
	`ordamt` DECIMAL(7,0) UNSIGNED NOT NULL DEFAULT '0',
	`cancelyn` ENUM('Y','N') NOT NULL DEFAULT 'N',
	`canceldtm` DATETIME NULL,
	`insdtm` DATETIME NOT NULL DEFAULT current_timestamp(),
	`moddtm` DATETIME NULL
);
describe order_h2;

CREATE TABLE `order_h3` (
	`orderno` CHAR(9), 
	`orddt` DATE NOT NULL,
	`memid` VARCHAR(9) NOT NULL,
	`ordamt` DECIMAL(7,0) UNSIGNED NOT NULL DEFAULT '0',
	`cancelyn` ENUM('Y','N') NOT NULL DEFAULT 'N',
	`canceldtm` DATETIME NULL,
	`insdtm` DATETIME NOT NULL DEFAULT current_timestamp(),
	`moddtm` DATETIME NULL,
    constraint pk_order_h3 primary key(orderno),
    constraint fk_member_order_h3 foreign key(memid) references member(memid)
);
describe order_h3;

CREATE TABLE `order_h4` (
	`orderno` CHAR(9), 
	`orddt` DATE NOT NULL,
	`memid` VARCHAR(9) NOT NULL,
	`ordamt` DECIMAL(7,0) UNSIGNED NOT NULL DEFAULT '0',
	`cancelyn` ENUM('Y','N') NOT NULL DEFAULT 'N',
	`canceldtm` DATETIME NULL,
	`insdtm` DATETIME NOT NULL DEFAULT current_timestamp(),
	`moddtm` DATETIME NULL
);
alter table order_h4 add constraint pk_order_h4 primary key (orderno);
alter table order_h4 add constraint fk_member_order_h4 foreign key (memid) references member(memid);
describe order_h4;

CREATE TABLE `order_h5` (
	`orderno` CHAR(9), 
	`orddt` DATE NOT NULL,
	`memid` VARCHAR(9) NOT NULL,
	`ordamt` DECIMAL(7,0) UNSIGNED NOT NULL DEFAULT '0',
	`cancelyn` ENUM('Y','N') NOT NULL DEFAULT 'N',
	`canceldtm` DATETIME NULL,
	`insdtm` DATETIME NOT NULL DEFAULT current_timestamp(),
	`moddtm` DATETIME NULL,
    primary key(orderno),
    foreign key(memid) references member(memid)
);
describe order_h5;

CREATE TABLE `order_d2` (
	`orderno` CHAR(9) NOT NULL,
	`goodscd` CHAR(5) NOT NULL,
	`unitcd` CHAR(2) NULL,
	`unitprice` DECIMAL(5,0) NOT NULL DEFAULT '0',
	`qty` DECIMAL(3,0) NOT NULL DEFAULT '0',
	`amt` DECIMAL(7,0) NOT NULL DEFAULT '0',
	`insdtm` DATETIME NOT NULL DEFAULT current_timestamp(),
	`moddtm` DATETIME NULL,
	constraint pk_order_d2 PRIMARY KEY (`orderno`, `goodscd`),
    constraint fk_order_h5_order_d2 foreign key (orderno) references order_h5 (orderno),
    constraint fk_goodsinfo_order_d2 foreign key (goodscd) references goodsinfo (goodscd)
);
describe order_d2;