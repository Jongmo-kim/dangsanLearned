CREATE USER examuser IDENTIFIED BY 1234;

GRANT CONNECT,RESOURCE TO examuser;

CREATE TABLE USER_TBL(

USER_NO NUMBER PRIMARY KEY,

USER_ID VARCHAR2(20) UNIQUE NOT NULL,

USER_NAME VARCHAR2(20) NOT NULL,

USER_AGE NUMBER NOT NULL

);
CREATE SEQUENCE USER_SEQ;
insert into user_tbl values(user_seq.nextval,'je lee','아이유',27);
insert into user_tbl values(user_seq.nextval,'bg park','박보검',27);
insert into user_tbl values(user_seq.nextval,'th kim','뷔',25);
select * from user_tbl;

commit;

select * from member_tbl;
----------------2번문제
CREATE TABLE MEMBER_TBL(

MEMBER_ID VARCHAR2(30) PRIMARY KEY,

MEMBER_PW VARCHAR2(30) NOT NULL,

MEMBER_NAME VARCHAR2(20) NOT NULL
);
