create table student(
    student_no number primary key,
    student_name varchar2(20) not null,
    student_phone char(15) not null,
    email varchar2(100),
    addr varchar2(500)
);
select * from student;
commit;
create sequence stu_seq;
insert into student values(stu_seq.nextval,'학생'||stu_seq.currval,'01099900000','wa1412@naver.com','');
drop table student;
drop sequence stu_seq;

create user mybatisexam identified by 1234;
grant resource, connect to mybatisexam;

create table member(
    MEMBER_NO NUMBER PRIMARY KEY,
    MEMBER_ID VARCHAR2(20) NOT NULL UNIQUE,
    MEMBER_PW VARCHAR2(20) NOT NULL,
    MEMBER_NAME VARCHAR2(20) NOT NULL,
    AGE NUMBER,
    ADDR VARCHAR2(400),
    REG_DATE DATE
);
select
			member_No as memberNo,
			member_Id as memberId,
			member_pw as memberPw,
			member_name as memberName,
			age,
			addr,
			reg_date as regDate
		from member
			where member_id = 123 and member_pw = 123; 
select * from member;
SELECT MEMBER_SEQ.CURRVAL FROM DUAL;
commit;
update
			member
		set
			member_pw = 123,
			addr = '서울시강남구강남'
		where
			member_no = 1;
            select * from member;
            commit;
            select * from member;
CREATE SEQUENCE MEMBER_SEQ;
INSERT INTO MEMBER VALUES(MEMBER_SEQ.NEXTVAL,'123'||member_seq.currval,'123','xptmxm','122','서울시 중랑구 중화동',sysdate);
commit;