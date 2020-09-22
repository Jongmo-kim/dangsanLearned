--동의어 synonym

-- 사용자가 다른 사용자의 객체를 참조할 때 사용자ID.테이블 명으로 표기 길게 표현되는것을 동의어로 설정하고 간단하게 사용가능
--
--동의어 종류
--1. 비공개 동의어
--객체에 대한 접근권한을 부여받은 사용자가 정의한 동으이
--2. 공개동의어

select * from employee;
select * from emp;
create synonym emp for employee ; --비공개 동의어

-- 공개 동의어 system, admin으로 실행해야함
create public synonym dept for kh.department; --kh에 있는 department를 dept로 설정

--test01 계정에 kh.department 테이블 조회권한 부여
grant select on kh.department to test01;
select * from kh.department; -- test01로 실행
select * from dept;

drop public synonym dept;--admin, system 실행 그러면 이후 dept로 실행안댐
revoke select on kh.department from test01; -- 권한 회수