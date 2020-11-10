CREATE TABLE MEMBERSHIP(
    MEMBER_NO NUMBER PRIMARY KEY,
    MEMBER_ID VARCHAR2(20) UNIQUE,
    MEMBER_PW VARCHAR2(20) NOT NULL,
    MEMBER_NAME VARCHAR2(20) NOT NULL,
    PHONE CHAR(13),
    EMAIL VARCHAR(30),
    GENDER CHAR(3) CHECK (GENDER IN('³²','¿©')),
    ENROLL_DATE VARCHAR(10)
);
update membership set member_id = ?, member_pw = ? , member_name = ? ,phone = ? , email = ? , gender = ?, enroll_date = ? where member_no = ?
CREATE SEQUENCE MEM_SEQ;
commit;
select * from member123ship;
select * from membership where member_id='123' and member_pw='123';

insert into membership values(3,'1','1','1','1','1','³²','1');