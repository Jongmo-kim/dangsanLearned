-- 1. ������ 1970����̸鼭 ������ ���� ���� ������ �������� ����� �ֹι�ȣ  �μ��� ��ȸ
select emp_name,emp_no,dept_title 
from employee 
join department 
on dept_code = dept_ID
where 
    emp_no like '7%-2%' 
    and substr(emp_name,0,1)='��';

--2. ���� �μ��� �ٹ��ϴ� �������� �����, �μ��ڵ�, �����̸� ��ȸ
select e1.emp_name �����,e1.dept_code �μ��ڵ�,e2.emp_name �����̸�
from employee e1
join employee e2 on e1.dept_code = e2.dept_code 
where e1.emp_name != e2.emp_name
order by e1.emp_name;