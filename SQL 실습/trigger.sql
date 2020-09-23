select * from usertbl;
select * from deluser; 
create sequence del_seq; -- 옵션없을댼 1씩 시작함
select del_seq.nextval from dual;
delete from usertbl where userid = '아이디$';
insert into deluser values(del_seq.nextval, 'user4',sysdate);

create or replace trigger user_del_trg_
after delete on usertbl for each row
begin

    insert into deluser values(del_seq.nextval,:OLD.userID,sysdate);
end;--삭제된행마다 foe eachl ow 여러개삭제시 여러번 발생
/

desc usertbl;
-- user tbl에서 이름을 변경항면 변경내역을 기록하는 테이블
create table log_tbl(
userno number,
contents varchar2(50),
modify_date date
);
insert into usertbl values(4, '아이디4','비번4');
select * from usertbl;

insert into log_tbl values (4, 'user4 -> user44', sysdate);

create or replace trigger usertbl_modify_trg 
after update 
on usertbl
for each row
begin
    insert into log_tbl values (:OLD.userno,:old.userid ||' - > ' || :new.userid,sysdate);
end;
/
desc usertbl;
select * from log_tbl;
update usertbl set userId = 'user44' where userno = 1;

select * from product_io;
select * from product;

create sequence seq_product;

create or replace trigger product_trigger
after insert
on product_io
for each row
begin
    if :new.status = '입고'
    then
    --입고
    update product set stock = stock + :new.amount where pcode = :new.pcode;
    end if;
    if :new.status = '출고'
    then
    --출고
    update product set stock = stock - :new.amount where pcode = :new.pcode;
    end if;
end;
/
desc product_io;
insert into product_io values(5,2,sysdate,100,'입고');
insert into product_io values(4,2,sysdate,100,'출고');
select * from product;



