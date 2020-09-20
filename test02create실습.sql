create table test_user(
user_no number primary key,
user_id varchar2(20) not null unique,
user_pw varchar2(30) not null,
user_name varchar2(30) not null,
gender char(3) check(gender in('남','여')),
phone   char(13) default '010-0000-0000'
);

create table test_board(
board_no number primary key,
board_title varchar2(100) not null,
board_content varchar2(2000) not null,
board_writer varchar2(20) references test_user (user_id) on delete cascade not null ,
write_date  date default sysdate
);

comment on column test_user.user_no is '회원번호';
comment on column test_user.user_id is '회원아이디';
comment on column test_user.user_pw is '회원비밀번호';
comment on column test_user.user_name is '회원이름';
comment on column test_user.gender is '성별';
comment on column test_user.phone is '전화번호';

comment on column test_board.board_no is '게시물번호';
comment on column test_board.board_title is '게시물제목';
comment on column test_board.board_content is '게시물내용';
comment on column test_board.board_writer is '게시물작성자';
comment on column test_board.write_date is '게시물작성일';

insert into test_user values (1,'아이디1','1','이름1','남',default);
insert into test_user values (1,'아이디2','2','이름2','남',default);--user_no primary key 확인
insert into test_user values (2,'아이디1','2','이름2','남',default);--user_id unique 확인
insert into test_user values (2,'아이디2',null,'이름1','남',default); --user_id Not null 확인
insert into test_user values (2,'아이디2','2','이름2','응',default);--gender check 확인

insert into test_board values (1,'제목1','내용1' ,'아이디1',default); -- board_writer foriegin key 확인
insert into test_board values (1,'제목2','내용2' ,'아이디1',default); --board_no primary key 확인
insert into test_board values (2,null,'내용2' ,'아이디1',default); --board_title not null 확인
insert into test_board values (1,'제목1',null ,'아이디1',default); --board_conttent not null 확인
insert into test_board values (1,'제목1','내용1' ,null,default);  --board_writer not null확인

delete from test_user where user_no=1;

create table member_tbl(
user_no number primary key,
user_id varchar2(20),
user_pwd varchar2(20)
);
select * from member_tbl;
desc member_tbl;
--컬럼 추가
alter table member_tbl add(user_name varchar2(20) not null);
alter table member_tbl add(user_age number default 0);

--제약조건 추가 ---sys0100101 자동제약조건 이름, 추가할떄는 수동으로 입력해주어야한다
alter table member_tbl add constraint mtbl_id_unq unique (user_id);
insert Into member_tbl values(1,'id1','pw1','이름1',default);
insert Into member_tbl values(2,'id2','pw1','이름1',default);
insert Into member_tbl values(3,'id2','pw1','이름1',default);

select constraint_name,constraint_type,table_name from user_constraints where table_name = 'MEMBER_TBL';