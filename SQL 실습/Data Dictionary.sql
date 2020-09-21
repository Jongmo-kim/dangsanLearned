-- 데이터 딕셔너리(data dictionary)
-- 자원을 효율적으로 관리하기위한 다양한 정보를 저장하는 시슽메의 테이블
-- 사용자가 테이블을 생성하거나 사용자를 변경하는 작업등이 발생하면
-- 데이터베이스 서버에 의해서 자동으로 갱신

-- 1. dba_xxxx : 데이터 베이스 관리자만 접근이 가능한 객체 등의 정보를 조회
-- 2. all_xxxx : 자신의 계정이 소유하거나 권한을 부여받은 객체등에 대한 정보를 조회
-- 3. user_xxxx : 자신의 계정이 소유한 객체등에 관한 정보 조회

select * from user_tables; -- 테이블의 정보들
select * from user_cons_columns; -- 내가가지고있는 테이블에 컬럼에 걸린 제약정보에 대한 딕셔너리
select * from user_cons_columns
where table_name='EMPLOYEE'; -- 소문자로 적으면 조회가 안됨

select * from user_col_comments where comments is not null; --데이터 딕셔너리에서 접속 메뉴에있는걸 뽑아낸다고 보면됨