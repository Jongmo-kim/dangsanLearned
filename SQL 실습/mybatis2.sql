create table member(
    member_no number primary key,
    member_id varchar2(20) not null unique,
    member_pw varchar2(20) not null,
    member_name varchar2(20),
    addr varchar2(200)
);
create sequence mem_seq;
insert into member values(mem_seq.nextval,'12'||mem_seq.currval,'123','아무개','서울시');