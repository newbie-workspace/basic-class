use labdb;

-- lottery table
create table lotto (

	rnd int not null primary key,
	gameDate date not null, 
	number1 smallint not null,
	number2 smallint not null,
	number3 smallint not null,
	number4  smallint not null,
	number5 smallint not null,
	number6 smallint not null,
	bonus smallint not null
    
);

select * from lotto;
delete from lotto where rnd = 1204;