drop table member;
CREATE TABLE MEMBERSHIP(
    MEMBER_NO NUMBER PRIMARY KEY,
    MEMBER_ID VARCHAR2(20) UNIQUE,
    MEMBER_PW VARCHAR2(20) NOT NULL,
    MEMBER_NAME VARCHAR2(20) NOT NULL,
    PHONE CHAR(13),
    EMAIL VARCHAR(30),
    GENDER CHAR(3) CHECK (GENDER IN('남','여')),
    ENROLL_DATE VARCHAR(10)
);
commit;
select * from member where member_id='admin' and member_pw='1234';
select * from member;
insert into member values(mem_seq.nextval, 'admin','1234','관리자','01011112222','서울시 영등포구 양평동',1,TO_CHAR(SYSDATE,'YYYY-MM-DD'));
insert into member values(mem_seq.nextval, 'user01','1234','user1','01011112222','서울시 영등포구 양평동',2,TO_CHAR(SYSDATE,'YYYY-MM-DD'));
insert into member values(mem_seq.nextval, '123','1234','관리자','01011112222','서울시 영등포구 양평동',3,TO_CHAR(SYSDATE,'YYYY-MM-DD'));
create table member(
MEMBER_NO NUMBER PRIMARY KEY,
MEMBER_ID VARCHAR2(20) UNIQUE NOT NULL,
MEMBER_PW VARCHAR2(20) NOT NULL,
MEMBER_NAME VARCHAR2(20) NOT NULL,
PHONE CHAR(11),
ADDRESS VARCHAR2(100),
MEMBER_LEVEL NUMBER, --관리자1, 정회원 2, 준회원 3
ENROLL CHAR(10)
);

update membership set member_id = ?, member_pw = ? , member_name = ? ,phone = ? , email = ? , gender = ?, enroll_date = ? where member_no = ?
CREATE SEQUENCE MEM_SEQ;
commit;
select * from membership;
select * from membership where member_id='123' and member_pw='123';

insert into membership values(3,'1','1','1','1','1','남','1');
insert into membership values(member,'1','1','1','1','1','남','1');
