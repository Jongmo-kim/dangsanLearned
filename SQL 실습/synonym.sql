--���Ǿ� synonym

-- ����ڰ� �ٸ� ������� ��ü�� ������ �� �����ID.���̺� ������ ǥ�� ��� ǥ���Ǵ°��� ���Ǿ�� �����ϰ� �����ϰ� ��밡��
--
--���Ǿ� ����
--1. ����� ���Ǿ�
--��ü�� ���� ���ٱ����� �ο����� ����ڰ� ������ ������
--2. �������Ǿ�

select * from employee;
select * from emp;
create synonym emp for employee ; --����� ���Ǿ�

-- ���� ���Ǿ� system, admin���� �����ؾ���
create public synonym dept for kh.department; --kh�� �ִ� department�� dept�� ����

--test01 ������ kh.department ���̺� ��ȸ���� �ο�
grant select on kh.department to test01;
select * from kh.department; -- test01�� ����
select * from dept;

drop public synonym dept;--admin, system ���� �׷��� ���� dept�� ����ȴ�
revoke select on kh.department from test01; -- ���� ȸ��