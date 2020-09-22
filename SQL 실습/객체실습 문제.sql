--
--���� ���� : khtest
--���� �ο� : connect,resource
create user khtest identified by kh;
grant resource, connect to khtest;
--���̺� 2�� ����
--ȸ�����̺�(MEMBER), �Խ������̺�(BOARD)
--
--## ȸ�����̺� ##
--MEMBER_NO(NUMBER)		-- ȸ�� ���� ���� (�ڵ� ����), PRIMARY KEY
--MEMBER_USERID (VARCHAR2(20))	-- ȸ�� ���̵�			UNIQUE, NOT NULL
--MEMBER_USERPWD (CHAR(20))	-- ȸ�� ��й�ȣ		NOT NULL
--MEMBER_NICKNAME (VARCHAR2(20))	-- ȸ�� �г���			UNIQUE, NOT NULL
--MEMBER_GENDER (NVARCHAR2(1))	-- ȸ�� ����('��' Ȥ�� '��')	NOT NULL
--MEMBER_EMAIL (VARCHAR2(30))	-- ȸ�� �̸���			NOT NULL
create table member(
MEMBER_NO NUMBER primary key,		-- ȸ�� ���� ���� (�ڵ� ����), PRIMARY KEY
MEMBER_USERID VARCHAR2(20) unique not null,	-- ȸ�� ���̵�			UNIQUE, NOT NULL
MEMBER_USERPWD CHAR(20)not null,	-- ȸ�� ��й�ȣ		NOT NULL
MEMBER_NICKNAME VARCHAR2(20)unique not null,	-- ȸ�� �г���			UNIQUE, NOT NULL
MEMBER_GENDER NVARCHAR2(3) check(MEMBER_GENDER in('��','��')) not null,	-- ȸ�� ����('��' Ȥ�� '��')	NOT NULL
MEMBER_EMAIL VARCHAR2(30) not null	-- ȸ�� �̸���			NOT NULL
);
drop from member;
---> ȸ�� ���� ��ȣ�� 1000�� ���� �����Ͽ� 1�� ���� �ؾ���
---> MAX ��ȣ�� 1000000 �� ����
---> ������ '��' �Ǵ� '��' �� ������ ������ ���� �ؾ��� 

create sequence member_seq
start with 1000
increment by 1
maxvalue 10000000
nocycle
nocache;
select * from member;

insert into member values (member_seq.nextval,'id' || member_seq.currval,'pwd' || member_seq.currval,'nick' || member_seq.currval,'��','email');

--## �Խ��� ���̺� ##
--BOARD_NO (NUMBER)		-- �� ��ȣ(�ڵ� ����)	, PRIMARY KEY
--BOARD_TITLE (VARCHAR2(20))	-- �� ����		NOT NULL
--BOARD_CONTENT (VARCHAR2(200))	-- �� ����		NOT NULL
--BOARD_WRITEDATE (DATE)		-- �� �ۼ��ð�		NOT NULL
--BOARD_NICKNAME (VARCHAR2(20))	-- �� �ۼ���(�г���)	NOT NULL �� FOREIGN KEY
--
---> �� ��ȣ�� 1������ �����Ͽ� 1�� ���� �ؾ���
---> MAX ��ȣ�� 500000�� ����
---> BOARD_NICKNAME�� MEMBER ���̺��� ȸ�� �г����� ����Ͽ� �ܷ�Ű�� ����
--	(MEMBER ���̺� �������� �ʴ� ����ڰ� ���� �ۼ��� �� ����)
create table BOARD(
BOARD_NO NUMBER primary key,		-- �� ��ȣ(�ڵ� ����)	, PRIMARY KEY
BOARD_TITLE VARCHAR2(20) not null,	-- �� ����		NOT NULL
BOARD_CONTENT VARCHAR2(200) not null,	-- �� ����		NOT NULL
BOARD_WRITEDATE DATE not null,		-- �� �ۼ��ð�		NOT NULL
BOARD_NICKNAME VARCHAR2(20) not null references  member (member_nickname)on 	-- �� �ۼ���(�г���)	NOT NULL �� FOREIGN KEY
);

--## �߰����� OBJECT �����ϱ� ##
--
--1. ���� ������ Ȯ���ϰ� �ʿ��� SEQUENCE ��ü ����� 
create sequence member_seq
start with 1000
increment by 1
maxvalue 10000000
nocycle
nocache;

---> �� ��ȣ�� 1������ �����Ͽ� 1�� ���� �ؾ���
---> MAX ��ȣ�� 500000�� ����
---> BOARD_NICKNAME�� MEMBER ���̺��� ȸ�� �г����� ����Ͽ� �ܷ�Ű�� ����
--	(MEMBER ���̺� �������� �ʴ� ����ڰ� ���� �ۼ��� �� ����)
create sequence board_seq
start with 1
increment by 1
maxvalue 500000
nocycle
nocache;





insert into board values (board_seq.nextval,
'title' || board_seq.currval,
'contents' || board_seq.currval,
sysdate,
'nick' || (board_seq.currval+1006 ));
--2. ȸ����ȣ , ȸ���г���, ȸ�� �̸���, ȸ�� �ۼ��� ���� ��
--�� �� �ִ� VIEW �����
create view member_view
as
    (select 
        member_no,
        member_nickname,
        member_email,
        board_title 
     from 
            member 
    join 
            board 
        on 
            member_nickname = board_nickname);
--3. MEMBER�� BOARD ���̺��� 'M' �� 'B' �ε� �˻� �� �� �ְ� �����
--ex)	SELECT * FROM M; -- MEMBER ���̺� ������ ������ ��
create synonym M for member;
create synonym B for board;
select * from M;
select * from B;