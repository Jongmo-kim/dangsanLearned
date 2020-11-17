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
    GENDER CHAR(3) CHECK (GENDER IN('남','여')),
    ENROLL_DATE VARCHAR(10)
);
create table member(
    MEMBER_NO NUMBER PRIMARY KEY,
    MEMBER_ID VARCHAR2(20) UNIQUE NOT NULL,
    MEMBER_PW VARCHAR2(20) NOT NULL,
    MEMBER_NAME VARCHAR2(20) NOT NULL,
    PHONE CHAR(11),
    ADDRESS VARCHAR2(100),
    MEMBER_LEVEL NUMBER, --관리자1, 정회원 2, 준회원 3
    ENROLL CHAR(10)
);
insert into member values(mem_seq.nextval, 'admin','1234','관리자','01011112222','서울시 영등포구 양평동',1,TO_CHAR(SYSDATE,'YYYY-MM-DD'));
insert into member values(mem_seq.nextval, 'user01','1234','user1','01011112222','서울시 영등포구 양평동',2,TO_CHAR(SYSDATE,'YYYY-MM-DD'));
insert into member values(mem_seq.nextval, '123','1234','관리자','01011112222','서울시 영등포구 양평동',3,TO_CHAR(SYSDATE,'YYYY-MM-DD'));

create TABLE NOTICE(
    NOTICE_NO NUMBER primary key,             -- 글 번호
    NOTICE_TITLE    varchar2(100) not null,   -- 공지사항 제목
    notice_writer   varchar2(20) not null ,      --공지사항 작성자
    NOtICE_CONTENT   VARCHAR2(4000) NOT NULL,    --공지사항 본문
    NOTICE_DATE     VARCHAR2(10),               --작성날짜
    FILENAME            VARCHAR2(30),           --업로드 파일명
    FILEPATH        VARCHAR2(30),               --실제업로드 파일저장이름
    STATUS      CHAR(1) DEFAULT 'Y',       --공지사항 노출여부
    CONSTRAINT FK_NOTICE_WRITER FOREIGN KEY (NOTICE_WRITER) REFERENCES MEMBER (MEMBER_ID)
);
alter table notice drop constraint FK_NOTICE_WRITER;
alter table notice add constraint FK_NOTICE_WRITER foreign key(notice_writer)
references member(member_id) on delete cascade;
alter table board drop constraint FK_Board_WRITER;
alter table board add constraint FK_Board_WRITER foreign key(board_writer)
references member(member_id) on delete cascade;

create TABLE BOARD(

    BOARD_NO NUMBER primary key,             -- 자유게시판 번호
    BOARD_TITLE    varchar2(100) not null,   -- 자유게시판 제목
    BOARD_writer   varchar2(20) not null ,      --자유게시판 작성자
    BOARD_CONTENT   VARCHAR2(4000) NOT NULL,    --자유게시판 본문
    BOARD_DATE     VARCHAR2(10),               --작성날짜
    FILENAME            VARCHAR2(30),           --업로드 파일명
    FILEPATH        VARCHAR2(30),               --실제업로드 파일저장이름
    STATUS      CHAR(1) DEFAULT 'Y',       --공지사항 노출여부
    CONSTRAINT FK_BOARD_WRITER FOREIGN KEY (BOARD_WRITER) REFERENCES MEMBER (MEMBER_ID)
);  
CREATE TABLE NOTICE_COMMENT(
    NOTICE_COMMENT_No NUMBER PRIMARY KEY,
    NOTICE_COMMENT_LEVEL NUMBER, --대댓글 구분용도
    NOTICE_COMMENT_WRITER VARCHAR2(20),
    NOTICE_COMMENT_CONTENT VARCHAR2(1000),
    NOTICE_REF NUMBER,
    NOTICE_COMMENT_REF NUMBER,    --어떤 댓글의 댓글인지 구분용도
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
insert into notice values(notice_seq.nextval,'첫번째 공지','admin','첫번째 공지사항 입니다!!!!!',to_char(sysdate,'yyyy-mm-dd')
,null,null,default);
insert into notice values(notice_seq.nextval,'2번째 공지','admin','2번째 공지사항 입니다!!!!!',to_char(sysdate,'yyyy-mm-dd')
,null,null,default);
insert into notice values(notice_seq.nextval,'3번째 공지','admin','3번째 공지사항 입니다!!!!!',to_char(sysdate,'yyyy-mm-dd')
,null,null,default);
insert into notice values(notice_seq.nextval,'4번째 공지','admin','4번째 공지사항 입니다!!!!!',to_char(sysdate,'yyyy-mm-dd')
,null,null,default);

insert into notice values(notice_seq.nextval,'5번째 공지','admin','5번째 공지사항 입니다!!!!!',to_char(sysdate,'yyyy-mm-dd')
,null,null,default);
select * from notice_comment;
insert into member values(
    mem_seq.nextval,
    mem_seq.currval,
    mem_seq.currval,
    mem_seq.currval,
    '010'||to_char(lpad(floor(DBMS_RANDOM.VALUE(0000, 9999)),4,0))||to_char(lpad(floor(DBMS_RANDOM.VALUE(0000, 9999)),4,0))
    ,'서울시 영등포 영등포대로'
    ,2
    ,TO_CHAR(SYSDATE-mem_seq.currval,'YYYY-MM-DD')
);
    

     insert into notice values(
             notice_seq.nextval,
             to_char(notice_seq.currval)||'번째 공지','admin',to_char(notice_seq.currval)||'번째 공지사항 입니다!!!!!',
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
    ,'서울시 영등포 영등포대로'
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
             to_char(notice_seq.currval)||'번째 공지','admin',to_char(notice_seq.currval)||'번째 공지사항 입니다!!!!!',
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
             to_char(board_seq.currval)||'번째 글','admin',to_char(board_seq.currval)||'번째 글 입니다!!!!!',
             to_char(sysdate,'yyyy-mm-dd')
            ,null
            ,null
            ,default);
       END LOOP;
    END;
    /
    commit;