
create table emp_01 (
emp_id number,
emp_name varchar2(30),
dept_code varchar2(8)
);
--insert
insert into emp_01 (emp_id,emp_name,dept_code) values (100,'������','D1');
insert into emp_01 (emp_name,dept_code,emp_id) values( 100,'������','D1');
insert into emp_01 (emp_ID,emp_name) values(101,'������');
--������  null�� �ڵ����� ����

--�Ʒ����� null�� �����Ϸ��� ���� �������᤿����
insert into emp_01 values(102,'������','D1');
insert into emp_01 values(102,'������',null);
select * from emp_01;

create table emp_02
as
select emp_id, emp_name, dept_code from employee where 1=0; --where 1=0 �� ������ �����´�

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
select * from dept_copy; --�����ϱ�

--�ѹ��� -> ������ȹ����
update dept_copy set dept_title = '������ȹ����' where dept_title ='�ѹ���';

select salary from employee where emp_name='������';
update employee 
set 
salary = (select salary from employee where emp_name='������') 
where emp_name='������';

--delete where �ʼ�
select * from dept_copy;
delete from dept_copy where dept_id='D9';
