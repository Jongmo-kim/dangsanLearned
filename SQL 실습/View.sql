create view emp_view
as 
select emp_id,emp_name,phone,email from employee;

create table emp_test
as 
select emp_id,emp_name,phone,email from employee;

--view ��������
--table �������� with read only �信���� ��ȸ������
-- with check option �ɼ��� ������ �÷��� ���� ���� �Ұ�
select * from employee;
select * from emp_view;
select * from emp_test;

update emp_test set phone = '0103654485' where emp_name = '�ɺ���';
update emp_view set phone = '0103654485' where emp_name = '�ɺ���';