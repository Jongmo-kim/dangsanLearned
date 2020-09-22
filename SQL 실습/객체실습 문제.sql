--
--계정 생성 : khtest
--권한 부여 : connect,resource
create user khtest identified by kh;
grant resource, connect to khtest;
--테이블 2개 생성
--회원테이블(MEMBER), 게시판테이블(BOARD)
--
--## 회원테이블 ##
--MEMBER_NO(NUMBER)		-- 회원 고유 순번 (자동 증가), PRIMARY KEY
--MEMBER_USERID (VARCHAR2(20))	-- 회원 아이디			UNIQUE, NOT NULL
--MEMBER_USERPWD (CHAR(20))	-- 회원 비밀번호		NOT NULL
--MEMBER_NICKNAME (VARCHAR2(20))	-- 회원 닉네임			UNIQUE, NOT NULL
--MEMBER_GENDER (NVARCHAR2(1))	-- 회원 성별('남' 혹은 '여')	NOT NULL
--MEMBER_EMAIL (VARCHAR2(30))	-- 회원 이메일			NOT NULL
create table member(
MEMBER_NO NUMBER primary key,		-- 회원 고유 순번 (자동 증가), PRIMARY KEY
MEMBER_USERID VARCHAR2(20) unique not null,	-- 회원 아이디			UNIQUE, NOT NULL
MEMBER_USERPWD CHAR(20)not null,	-- 회원 비밀번호		NOT NULL
MEMBER_NICKNAME VARCHAR2(20)unique not null,	-- 회원 닉네임			UNIQUE, NOT NULL
MEMBER_GENDER NVARCHAR2(3) check(MEMBER_GENDER in('남','여')) not null,	-- 회원 성별('남' 혹은 '여')	NOT NULL
MEMBER_EMAIL VARCHAR2(30) not null	-- 회원 이메일			NOT NULL
);
drop from member;
---> 회원 고유 번호는 1000번 부터 시작하여 1씩 증가 해야함
---> MAX 번호는 1000000 번 까지
---> 성별은 '남' 또는 '여' 만 데이터 삽입이 가능 해야함 

create sequence member_seq
start with 1000
increment by 1
maxvalue 10000000
nocycle
nocache;
select * from member;

insert into member values (member_seq.nextval,'id' || member_seq.currval,'pwd' || member_seq.currval,'nick' || member_seq.currval,'남','email');

--## 게시판 테이블 ##
--BOARD_NO (NUMBER)		-- 글 번호(자동 증가)	, PRIMARY KEY
--BOARD_TITLE (VARCHAR2(20))	-- 글 제목		NOT NULL
--BOARD_CONTENT (VARCHAR2(200))	-- 글 내용		NOT NULL
--BOARD_WRITEDATE (DATE)		-- 글 작성시간		NOT NULL
--BOARD_NICKNAME (VARCHAR2(20))	-- 글 작성자(닉네임)	NOT NULL 및 FOREIGN KEY
--
---> 글 번호는 1번부터 시작하여 1씩 증가 해야함
---> MAX 번호는 500000번 까지
---> BOARD_NICKNAME은 MEMBER 테이블의 회원 닉네임을 사용하여 외래키로 지정
--	(MEMBER 테이블에 존재하지 않는 사용자가 글을 작성할 순 없음)
create table BOARD(
BOARD_NO NUMBER primary key,		-- 글 번호(자동 증가)	, PRIMARY KEY
BOARD_TITLE VARCHAR2(20) not null,	-- 글 제목		NOT NULL
BOARD_CONTENT VARCHAR2(200) not null,	-- 글 내용		NOT NULL
BOARD_WRITEDATE DATE not null,		-- 글 작성시간		NOT NULL
BOARD_NICKNAME VARCHAR2(20) not null references  member (member_nickname)on 	-- 글 작성자(닉네임)	NOT NULL 및 FOREIGN KEY
);

--## 추가적인 OBJECT 생성하기 ##
--
--1. 위에 사항을 확인하고 필요한 SEQUENCE 객체 만들기 
create sequence member_seq
start with 1000
increment by 1
maxvalue 10000000
nocycle
nocache;

---> 글 번호는 1번부터 시작하여 1씩 증가 해야함
---> MAX 번호는 500000번 까지
---> BOARD_NICKNAME은 MEMBER 테이블의 회원 닉네임을 사용하여 외래키로 지정
--	(MEMBER 테이블에 존재하지 않는 사용자가 글을 작성할 순 없음)
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
--2. 회원번호 , 회원닉네임, 회원 이메일, 회원 작성글 제목 을
--볼 수 있는 VIEW 만들기
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
--3. MEMBER와 BOARD 테이블을 'M' 과 'B' 로도 검색 할 수 있게 만들기
--ex)	SELECT * FROM M; -- MEMBER 테이블 정보가 보여야 함
create synonym M for member;
create synonym B for board;
select * from M;
select * from B;