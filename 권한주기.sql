--user 생성
--create user 계정이름 identified 비밀번호
create user test01 identified by 1234;
--권한 부여방법
--GRANT ROLE 이름 to 계정이름
grant connect, resource to test01;
--권한 회수 방법
--REVOKE 회수할 ROLE FROM 계정이름
revoke connect from test01;