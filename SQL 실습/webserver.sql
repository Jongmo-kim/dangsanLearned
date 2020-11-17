create user webserver identified by 1234;
grant resource, connect to webserver;
DROP SEQUENCE NOTICE_COMMENT_SEQ;
DROP TABLE NOTICE_COMMENT;
drop table member;
drop sequence ;
drop table board;
drop table notice;
drop sequence notice_seq; 
drop sequence board_seq;
drop table notice;
drop sequence notice_seq;
CREATE TABLE MEMBERSHIP(
    MEMBER_NO NUMBER PRIMARY KEY,
    MEMBER_ID VARCHAR2(20) UNIQUE,
    MEMBER_PW VARCHAR2(20) NOT NULL,
    MEMBER_NAME VARCHAR2(20) NOT NULL,
    PHONE CHAR(13),
    EMAIL VARCHAR(30),
    GENDER CHAR(3) CHECK (GENDER IN('��','��')),
    ENROLL_DATE VARCHAR(10)
);
create table member(
    MEMBER_NO NUMBER PRIMARY KEY,
    MEMBER_ID VARCHAR2(20) UNIQUE NOT NULL,
    MEMBER_PW VARCHAR2(20) NOT NULL,
    MEMBER_NAME VARCHAR2(20) NOT NULL,
    PHONE CHAR(11),
    ADDRESS VARCHAR2(100),
    MEMBER_LEVEL NUMBER, --������1, ��ȸ�� 2, ��ȸ�� 3
    ENROLL CHAR(10)
);
insert into member values(mem_seq.nextval, 'admin','1234','������','01011112222','����� �������� ����',1,TO_CHAR(SYSDATE,'YYYY-MM-DD'));
insert into member values(mem_seq.nextval, 'user01','1234','user1','01011112222','����� �������� ����',2,TO_CHAR(SYSDATE,'YYYY-MM-DD'));
insert into member values(mem_seq.nextval, '123','1234','������','01011112222','����� �������� ����',3,TO_CHAR(SYSDATE,'YYYY-MM-DD'));

create TABLE NOTICE(
    NOTICE_NO NUMBER primary key,             -- �� ��ȣ
    NOTICE_TITLE    varchar2(100) not null,   -- �������� ����
    notice_writer   varchar2(20) not null ,      --�������� �ۼ���
    NOtICE_CONTENT   VARCHAR2(4000) NOT NULL,    --�������� ����
    NOTICE_DATE     VARCHAR2(10),               --�ۼ���¥
    FILENAME            VARCHAR2(30),           --���ε� ���ϸ�
    FILEPATH        VARCHAR2(30),               --�������ε� ���������̸�
    STATUS      CHAR(1) DEFAULT 'Y',       --�������� ���⿩��
    CONSTRAINT FK_NOTICE_WRITER FOREIGN KEY (NOTICE_WRITER) REFERENCES MEMBER (MEMBER_ID)
);
alter table notice drop constraint FK_NOTICE_WRITER;
alter table notice add constraint FK_NOTICE_WRITER foreign key(notice_writer)
references member(member_id) on delete cascade;
alter table board drop constraint FK_Board_WRITER;
alter table board add constraint FK_Board_WRITER foreign key(board_writer)
references member(member_id) on delete cascade;

create TABLE BOARD(

    BOARD_NO NUMBER primary key,             -- �����Խ��� ��ȣ
    BOARD_TITLE    varchar2(100) not null,   -- �����Խ��� ����
    BOARD_writer   varchar2(20) not null ,      --�����Խ��� �ۼ���
    BOARD_CONTENT   VARCHAR2(4000) NOT NULL,    --�����Խ��� ����
    BOARD_DATE     VARCHAR2(10),               --�ۼ���¥
    FILENAME            VARCHAR2(30),           --���ε� ���ϸ�
    FILEPATH        VARCHAR2(30),               --�������ε� ���������̸�
    STATUS      CHAR(1) DEFAULT 'Y',       --�������� ���⿩��
    CONSTRAINT FK_BOARD_WRITER FOREIGN KEY (BOARD_WRITER) REFERENCES MEMBER (MEMBER_ID)
);  
CREATE TABLE NOTICE_COMMENT(
    NOTICE_COMMENT_No NUMBER PRIMARY KEY,
    NOTICE_COMMENT_LEVEL NUMBER, --���� ���п뵵
    NOTICE_COMMENT_WRITER VARCHAR2(20),
    NOTICE_COMMENT_CONTENT VARCHAR2(1000),
    NOTICE_REF NUMBER,
    NOTICE_COMMENT_REF NUMBER,    --� ����� ������� ���п뵵
    NOTICE_COMMENT_DATE VARCHAR2(10),
    CONSTRAINT FK_NOTICE_COMMENT_WRITER FOREIGN KEY (NOTICE_COMMENT_WRITER) REFERENCES MEMBER(MEMBER_ID) ON DELETE SET NULL,
    CONSTRAINT FK_NOTICE_REF FOREIGN KEY (NOTICE_REF) REFERENCES NOTICE(NOTICE_NO) ON DELETE CASCADE,
    CONSTRAINT FK_NOTICE_COMMENT_REF FOREIGN KEY(NOTICE_COMMENT_REF) REFERENCES NOTICE_COMMENT(NOTICE_COMMENT_NO) ON DELETE CASCADE
);
select NOTICE_COMMENT_NO, NOTICE_COMMENT_REF from notice_comment;
CREATE SEQUENCE NOTICE_COMMENT_SEQ;
select * from notice_comment;
create sequence notice_seq;
CREATE SEQUENCE BOARD_SEQ;
create sequence mem_seq;
insert into notice values(notice_seq.nextval,'ù��° ����','admin','ù��° �������� �Դϴ�!!!!!',to_char(sysdate,'yyyy-mm-dd')
,null,null,default);
insert into notice values(notice_seq.nextval,'2��° ����','admin','2��° �������� �Դϴ�!!!!!',to_char(sysdate,'yyyy-mm-dd')
,null,null,default);
insert into notice values(notice_seq.nextval,'3��° ����','admin','3��° �������� �Դϴ�!!!!!',to_char(sysdate,'yyyy-mm-dd')
,null,null,default);
insert into notice values(notice_seq.nextval,'4��° ����','admin','4��° �������� �Դϴ�!!!!!',to_char(sysdate,'yyyy-mm-dd')
,null,null,default);

insert into notice values(notice_seq.nextval,'5��° ����','admin','5��° �������� �Դϴ�!!!!!',to_char(sysdate,'yyyy-mm-dd')
,null,null,default);
select * from notice_comment;
insert into member values(
    mem_seq.nextval,
    mem_seq.currval,
    mem_seq.currval,
    mem_seq.currval,
    '010'||to_char(lpad(floor(DBMS_RANDOM.VALUE(0000, 9999)),4,0))||to_char(lpad(floor(DBMS_RANDOM.VALUE(0000, 9999)),4,0))
    ,'����� ������ ���������'
    ,2
    ,TO_CHAR(SYSDATE-mem_seq.currval,'YYYY-MM-DD')
);
    

     insert into notice values(
             notice_seq.nextval,
             to_char(notice_seq.currval)||'��° ����','admin',to_char(notice_seq.currval)||'��° �������� �Դϴ�!!!!!',
             to_char(sysdate,'yyyy-mm-dd')
            ,null
            ,null
            ,default);

CREATE SEQUENCE MEM_SEQ;
commit;

  DECLARE
      vn_base_num NUMBER := 3;
    BEGIN
       FOR i IN 1..100
       LOOP
          insert into member values(
    mem_seq.nextval,
    mem_seq.currval,
    mem_seq.currval,
    mem_seq.currval,
    '010'||to_char(lpad(floor(DBMS_RANDOM.VALUE(0000, 9999)),4,0))||to_char(lpad(floor(DBMS_RANDOM.VALUE(0000, 9999)),4,0))
    ,'����� ������ ���������'
    ,2
    ,TO_CHAR(SYSDATE-mem_seq.currval,'YYYY-MM-DD'));
    
       END LOOP;
    END;
    


/
  DECLARE
      vn_base_num NUMBER := 3;
    BEGIN
       FOR i IN 1..1000
       LOOP
              insert into notice values(
             notice_seq.nextval,
             to_char(notice_seq.currval)||'��° ����','admin',to_char(notice_seq.currval)||'��° �������� �Դϴ�!!!!!',
             to_char(sysdate,'yyyy-mm-dd')
            ,null
            ,null
            ,default);
       END LOOP;
    END;
    /
    
     DECLARE
      vn_base_num NUMBER := 3;
    BEGIN
       FOR i IN 1..1000
       LOOP
              insert into board values(
             board_seq.nextval,
             to_char(board_seq.currval)||'��° ��','admin',to_char(board_seq.currval)||'��° �� �Դϴ�!!!!!',
             to_char(sysdate,'yyyy-mm-dd')
            ,null
            ,null
            ,default);
       END LOOP;
    END;
    /
    commit;