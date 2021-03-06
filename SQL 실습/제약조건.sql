/*
회원 저장용 테이블
아이디/비밀번호/이름/나이/주소/성별/전화번호/
ID      아이디     문자(VARCHAR2)    12
PASS    비밀번호    문자(varchar2)    20
NAME       문자(char)       9
AGE       숫자(number)
ADR       문자(varchar2)   200
GENDER       문자(char)       3 남/녀
PHONE_NUMER    문자(char)       13 //스네이크표기법
*/
Create table member(
    ID      varchar2(12),
    PASS    varchar2(20),
    NAME    char(9),
    AGE     NUMber,
    ADDR    varchar2(200),
    GENDER  char(3),
    phone_number    char(13)
);

COMMENT on column MEMBER.ID is '회원아이디';
COMMENT ON COLUMN MEMBER.PASS is '비밀번호';
COMMENT ON COLUMN MEMBER.name is '이름';
COMMENT ON COLUMN MEMBER.age is '나이';
COMMENT ON COLUMN MEMBER.addr is '주소';
COMMENT ON COLUMN MEMBER.gender is '성별';
COMMENT ON COLUMN MEMBER.phone_number is '핸드폰번호';
INSERT INTO MEMBER VALUES('ID021','PW021','유21',20,'서울2','여','012-1234-1234');
/*
CREATE 제약조건
NOT NULL 데이터에 null 을 허용 하지 않는다.
unique 중복된 값을 허용하지않는다
primary key null을 허용하지않고 중복을 허용하지 않는. 컬럼의 고유식별자로 사용하기 위함 학번같은개념
foreign key 다른테이블의 컬럼값이 존재하면 허용한다.
check 저장 가능한 데이터값의 범위나 조건을 지정하여 설정한 값만 허용한다.

UNIQUE(USER_ID) 테이블레밸 따로 설정하는것
*/

-- NOT NULL 제약조건을 추가한 테이블 생성
CREATE TABLE MEMBER_NN(
    USER_ID     varchar2(20) NOT NULL,
    USER_PW     varchar2(20) NOT NULL,
    user_NAME   varchar2(20) 
);

insert into member_nn values ('user01','pass01','이름1');
insert into member_nn values ('user02','pass02',null );
insert into member_nn values (null,null,'이름3');

-- unique 제약조건이 설정된 테이블 생성
create table member_unq(
  --USER_ID     varchar2(20) unique,  컬럼레밸에서 unique설정
    USER_PW     varchar2(20),
    user_NAME   varchar2(20),
    UNIQUE(USER_ID)         --TABLE레밸에서 설정
);
insert Into member_unq values('user01','pass01','이름1');
insert Into member_unq values('user03','pass02','이름1');
insert Into member_unq values(null ,'pass02','이름1'); -- null은들어감
select * from member_unq;

create table member_nn_unq(
    user_id     varchar2(20) not null unique,
    user_pass   varchar2(20) not null,
    user_name   varchar2(30)
);

insert into member_nn_unq values('user01','pass01','이름1');
insert into member_nn_unq values('user02','pass02','이름2');
insert into member_nn_unq values(null    ,'pass01','이름1');--안됨

create table member_unq2(
    user_id     varchar2(20),
    user_pw     varchar2(20),
    user_name   varchar2(30),
    unique(user_id,user_name) --동시에 겹칠때만 unqiue
);

insert into member_unq2 values ('user01','pass01','이름1');
insert into member_unq2 values ('user02','pass02','이름1');
insert into member_unq2 values ('user02','pass02','이름2');
insert into member_unq2 values ('user01','pass02','이름1'); --안됨

create table member_pk1 (
    user_id     varchar2(20) primary key, -- 컬럼레밸
    user_pw     varchar2(20),
    user_name   varchar2(30)
);

insert into member_pk1 values('user01','pass01','이름01');
insert into member_pk1 values('user02','pass02','이름02');
insert into member_pk1 values('user03','pass03','이름03');

create table member_pk2(
    user_ID varchar2(20),
    user_pw varchar2(20),
    user_name varchar2(30),
    primary key(user_id) --테이블레밸
);
                                       
                                                                                                                                                                                                                                                                     
create table member_pk3(
    user_ID varchar2(20),
    user_pw varchar2(20),
    user_name varchar2(30),
    primary key(user_id,user_name) --두개 합쳐서 primary key 제약조건
);

create table shop_member(
user_id varchar2(20) unique not null, 
user_pw varchar2(20),
user_name varchar2(20)
);
select * from shop_member;
insert into shop_member values ('id3','pw3','이름3');
drop table shop_buy;

create table shop_buy(
buy_no number primary key,
user_ID varchar2(20) references shop_member  (user_id)ON delete set null,
product_name varchar2(30),
buy_date date
);
insert into shop_buy values(3,'id3','pc3',sysdate);--오류 userid가없음

delete from shop_member where user_ID='id1';
select * from shop_buy; --null로 바뀜

--check
create table member_nochk(
member_id varchar2(20) primary key,
member_p  varchar2(20) not null,
member_name varchar2(30),
gender char(3) check(gender in('남','여'))
);
insert into member_nochk values('id1','pw1','이름1','남');
insert into member_nochk values('id1','pw1','이름1','응');

--default
create table board(
board_title varchar2(100),
board_content varchar2(2000),
board_writer varchar2(20),
read_count number default 0
);
insert into board values('제목','dddddd','id1',default);
select * from board;

create table test_tbl(
user_name varchar2(30),
phone varchar2(13) default '010-0000-0000'
);
insert into test_tbl values('이름',default);
select * from test_tbl;

create table emp_copy1 as
select emp_name,phone,email,salary from employee;

create table emp_copy2
as
select emp_name,phone,email, salary from employee where 1 = 0;
select * from emp_copy2;