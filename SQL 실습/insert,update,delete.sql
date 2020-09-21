
create table emp_01 (
emp_id number,
emp_name varchar2(30),
dept_code varchar2(8)
);
--insert
insert into emp_01 (emp_id,emp_name,dept_code) values (100,'이윤수','D1');
insert into emp_01 (emp_name,dept_code,emp_id) values( 100,'이윤수','D1');
insert into emp_01 (emp_ID,emp_name) values(101,'이윤수');
--위쪽은  null이 자동으로 들어간다

--아래쪽은 null을 지정하려면 따로 설정행햐ㅏㄴ다
insert into emp_01 values(102,'이윤수','D1');
insert into emp_01 values(102,'이윤수',null);
select * from emp_01;

create table emp_02
as
select emp_id, emp_name, dept_code from employee where 1=0; --where 1=0 은 구조만 가져온다

create table emp_03
as
select emp_id,emp_name,job_code from employee where 1=0;

insert all
into emp_02 values(emp_id,emp_name,dept_code)
into emp_03 values(emp_id,emp_name,job_code)
select emp_id,emp_name,dept_code,job_code from employee;

--update
create table dept_copy
as
select * from department;
select * from dept_copy; --복사하기

--총무부 -> 전략기획본부
update dept_copy set dept_title = '전략기획본부' where dept_title ='총무부';

select salary from employee where emp_name='선동일';
update employee 
set 
salary = (select salary from employee where emp_name='선동일') 
where emp_name='송종기';

--delete where 필수
select * from dept_copy;
delete from dept_copy where dept_id='D9';
