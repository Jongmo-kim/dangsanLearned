-- create sequence �������̸�
-- start with ���۽�ų ����
-- increment by �󸶳� �����Ұ���
-- maxvalue ���� | nomaxvalue
-- �ִ밪 ���� (10^27-1 ���� ����)
-- minvalue ���� | nominvalue
-- �ּҰ� ����(-10^26��������
-- cycle nocycle
-- ������ �ִ밪 ���޽� cycle�� start with ������ ���ư��� nocycle�� ����
--cache | nocache �޸𸮻󿡼� �������� ���� �⺻20 ���� �ý��ۿ� ���ϰ� �ɸ���.

create sequence seq_test
start with 1
increment by 1
maxvalue 10
nocycle
nocache;

select seq_test.nextval from dual; --������ ��ȸ
select seq_test.currval from dual; --���簪 ��ȸ

create sequence seq_test2
start with 1
increment by 1
maxvalue 10
cycle
nocache;

select seq_test2.nextval from dual; --������ ��ȸ
select seq_test2.currval from dual; --���簪 ��ȸ

create sequence seq_test3
start with 1
increment by 2
maxvalue 10
cycle
nocache;

select seq_test3.nextval from dual; --������ ��ȸ
select seq_test3.currval from dual; --���簪 ��ȸ

create table seq_tbl(
    no number primary key,
    name varchar2(20) not null,
    age number not null
);
create sequence seq_tbl_no
start with 200
increment by 1
maxvalue 2000
nocycle
nocache;

insert into seq_tbl values(seq_tbl_no.nextval,'�̿���'|| (seq_tbl_no.currval - 180),'18');
delete from seq_tbl;

select * from seq_tbl;

-- sequence ����
--alter sequence �������̸�
--increment by 10
--maxvalue 500
--nocycle
--nocache;
--
--�������� ���� 
--delete from sequence