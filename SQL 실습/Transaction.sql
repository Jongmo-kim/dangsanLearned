create table usettbl(
userno number primary key,
userid varchar2(20) unique,
password varchar2(20) not null
);
insert into usettbl values(1,'���̵�1','���1');
insert into usettbl values(2,'���̵�2','���2');
insert into usettbl values(3,'���̵�3','���3');
insert into usertbl values(4,'���̵�$','���4');
savepoint sp1;
insert into usertbl values (5,'���̵�%','���5');
select * from usettbl;
rollback to sp1;
rollback;
 commit;
delete from usettbl where userno =4;
commit;
create table deluser(
delno number primary key,
depid varchar2(20) not null,
deldate date
);


insert into deluser values(4,'user44',sysdate);
delete from deluser where depid='user44';
select * from deluser;
select * from usertbl;



create table product(
    pcode number primary key,
    pname varchar2(30),
    brand varchar2(30),
    price number,
    stock number default 0
);
select * from product;
insert into product values(1,'�����ó�Ʈ 20','samsung',1500000,0);
insert into product values(2,'������11 pro','apple',1800000,0);
commit;

create table product_io(
    IO_CODE number primary key,
    pcode number,
    io_date date,
    amount number,
    status char(6) check (status IN ('�԰�','���')),
    foreign key (pcode) references product (pcode)
);

insert into product_io values(1,2,sysdate,10,'�԰�');
select * from product_io;

update product set stock = 10 where pcode = 2;
commit;
-- ����ϴ� Ʈ������
insert into product_io values(2,2,sysdate,5,'���');
update product set stock =stock - 5 where pcode = 2;
commit;

--�԰��ϴ� Ʈ������
insert into product_io values(1,2,sysdate,10,'�԰�');
update product set stock =stock + 10 where pcode = 2;
delete from product_io where pcode = 2;
commit;


select * from product;