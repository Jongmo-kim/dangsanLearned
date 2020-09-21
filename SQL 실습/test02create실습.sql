create table test_user(
user_no number primary key,
user_id varchar2(20) not null unique,
user_pw varchar2(30) not null,
user_name varchar2(30) not null,
gender char(3) check(gender in('��','��')),
phone   char(13) default '010-0000-0000'
);

create table test_board(
board_no number primary key,
board_title varchar2(100) not null,
board_content varchar2(2000) not null,
board_writer varchar2(20) references test_user (user_id) on delete cascade not null ,
write_date  date default sysdate
);

comment on column test_user.user_no is 'ȸ����ȣ';
comment on column test_user.user_id is 'ȸ�����̵�';
comment on column test_user.user_pw is 'ȸ����й�ȣ';
comment on column test_user.user_name is 'ȸ���̸�';
comment on column test_user.gender is '����';
comment on column test_user.phone is '��ȭ��ȣ';

comment on column test_board.board_no is '�Խù���ȣ';
comment on column test_board.board_title is '�Խù�����';
comment on column test_board.board_content is '�Խù�����';
comment on column test_board.board_writer is '�Խù��ۼ���';
comment on column test_board.write_date is '�Խù��ۼ���';

insert into test_user values (1,'���̵�1','1','�̸�1','��',default);
insert into test_user values (1,'���̵�2','2','�̸�2','��',default);--user_no primary key Ȯ��
insert into test_user values (2,'���̵�1','2','�̸�2','��',default);--user_id unique Ȯ��
insert into test_user values (2,'���̵�2',null,'�̸�1','��',default); --user_id Not null Ȯ��
insert into test_user values (2,'���̵�2','2','�̸�2','��',default);--gender check Ȯ��

insert into test_board values (1,'����1','����1' ,'���̵�1',default); -- board_writer foriegin key Ȯ��
insert into test_board values (1,'����2','����2' ,'���̵�1',default); --board_no primary key Ȯ��
insert into test_board values (2,null,'����2' ,'���̵�1',default); --board_title not null Ȯ��
insert into test_board values (1,'����1',null ,'���̵�1',default); --board_conttent not null Ȯ��
insert into test_board values (1,'����1','����1' ,null,default);  --board_writer not nullȮ��

delete from test_user where user_no=1;

create table member_tbl(
user_no number primary key,
user_id varchar2(20),
user_pwd varchar2(20)
);
select * from member_tbl;
desc member_tbl;
--�÷� �߰�
alter table member_tbl add(user_name varchar2(20) not null);
alter table member_tbl add(user_age number default 0);

--�������� �߰� ---sys0100101 �ڵ��������� �̸�, �߰��ҋ��� �������� �Է����־���Ѵ�
alter table member_tbl add constraint mtbl_id_unq unique (user_id);
insert Into member_tbl values(1,'id1','pw1','�̸�1',default);
insert Into member_tbl values(2,'id2','pw1','�̸�1',default);
insert Into member_tbl values(3,'id2','pw1','�̸�1',default);

select constraint_name,constraint_type,table_name from user_constraints where table_name = 'MEMBER_TBL';