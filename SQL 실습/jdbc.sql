commit;
--테이블 생성
update member set member_id = '123' member_pw = '123'member_name = '123'age = '123' gender = '남' phone = '123-1231-1232' where member_no = '1';
delete from member where member_id = '1';
rollback;
insert into member values(200001,1,1,1,1,'남','010-0000-0000',sysdate);
create table member (
    member_no number primary key,
    member_id varchar2(20) unique not null,
    member_pw varchar2(20) not null,
    member_name varchar2(20)  null,
    AGe          number,
    gender char(3) check(gender in('남','여')),
    phone   char(13),
    enroll_date date default sysdate
);
create  sequence member_seq;
drop table member;
drop sequence member_seq;
commit;

select * from member where member_id like '%아%';
select * from member;
begin
while(member_seq.nextval != 200001)
loop
    insert into member values(member_seq.currval,'아이디' || member_seq.currval,'비번'||member_seq.currval,'이름'||member_seq.currval,member_seq.currval+19,'남','010'||'-'||ROUND(DBMS_RANDOM.VALUE(1000, 9999),0)||'-'||ROUND(DBMS_RANDOM.VALUE(1000, 9999),0) ,sysdate-member_seq.currval*1);
    END LOOP;
end;
/
