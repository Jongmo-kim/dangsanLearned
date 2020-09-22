-- create sequence 시퀀스이름
-- start with 시작시킬 숫자
-- increment by 얼마나 증가할건지
-- maxvalue 숫자 | nomaxvalue
-- 최대값 지정 (10^27-1 까지 가능)
-- minvalue 숫자 | nominvalue
-- 최소값 지정(-10^26까지가능
-- cycle nocycle
-- 시퀀스 최대값 도달시 cycle은 start with 값으로 돌아가고 nocycle은 에러
--cache | nocache 메모리상에서 시퀀스값 관리 기본20 사용시 시스템에 부하가 걸린다.

create sequence seq_test
start with 1
increment by 1
maxvalue 10
nocycle
nocache;

select seq_test.nextval from dual; --다음값 조회
select seq_test.currval from dual; --현재값 조회

create sequence seq_test2
start with 1
increment by 1
maxvalue 10
cycle
nocache;

select seq_test2.nextval from dual; --다음값 조회
select seq_test2.currval from dual; --현재값 조회

create sequence seq_test3
start with 1
increment by 2
maxvalue 10
cycle
nocache;

select seq_test3.nextval from dual; --다음값 조회
select seq_test3.currval from dual; --현재값 조회

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

insert into seq_tbl values(seq_tbl_no.nextval,'이원굉'|| (seq_tbl_no.currval - 180),'18');
delete from seq_tbl;

select * from seq_tbl;

-- sequence 수정
--alter sequence 시퀀스이름
--increment by 10
--maxvalue 500
--nocycle
--nocache;
--
--시퀀스스 삭제 
--delete from sequence