drop table member;
drop sequence ;
drop table board;
drop sequence board_seq;
commit;
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
CREATE SEQUENCE BOARD_SEQ;
commit;
select * from member where member_id='admin' and member_pw='1234';
select * from notice;
insert into member values(mem_seq.nextval, 'admin','1234','������','01011112222','����� �������� ����',1,TO_CHAR(SYSDATE,'YYYY-MM-DD'));
insert into member values(mem_seq.nextval, 'user01','1234','user1','01011112222','����� �������� ����',2,TO_CHAR(SYSDATE,'YYYY-MM-DD'));
insert into member values(mem_seq.nextval, '123','1234','������','01011112222','����� �������� ����',3,TO_CHAR(SYSDATE,'YYYY-MM-DD'));

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
create TABLE NOTICE(
    NOTICE_NO NUMBER primary key,             -- �� ��ȣ
    NOTICE_TITLE    varchar2(100) not null,   -- �������� ����
    notice_writer   varchar2(20) not null ,      --�������� �ۼ���
    NOICE_CONTENT   VARCHAR2(4000) NOT NULL,    --�������� ����
    NOTICE_DATE     VARCHAR2(10),               --�ۼ���¥
    FILENAME            VARCHAR2(30),           --���ε� ���ϸ�
    FILEPATH        VARCHAR2(30),               --�������ε� ���������̸�
    STATUS      CHAR(1) DEFAULT 'Y',       --�������� ���⿩��
    CONSTRAINT FK_NOTICE_WRITER FOREIGN KEY (NOTICE_WRITER) REFERENCES MEMBER (MEMBER_ID)
);
create sequence notice_seq;
drop table notice;
drop sequence notice_seq; 
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
commit;
rollback;
select * from notice;
select * from (select rownum as rnum, n.* from (select * from notice order by 1 desc)N) where rnum between 1 and 10;
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
       FOR i IN 1..100000
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
    
    select rownum as rnum, (select * from board) from board,;