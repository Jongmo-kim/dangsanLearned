--�μ��ڵ尡 d5�� ������ emp_id, emp_name, dept_code, salary
select emp_id, emp_name, dept_code, salary 
from employee
where dept_code = 'D5';
-- salary�� 300�������� ū����� emp_id, emp_name, dept_code, salary
select emp_id, emp_name, dept_code , salary 
from employee
where salary>3000000;
--union�� ��ü �Խ���  ���հ˻� �ҋ� ������
--set operator
--������ UNION
select emp_id, emp_name, dept_code, salary 
from employee
where dept_code = 'D5'
UNION
select emp_id, emp_name, dept_code , salary 
from employee
where salary>3000000;


--union all ���ľ��ϰ� �ߺ��� �÷��� ����
select emp_id, emp_name, dept_code, salary 
from employee
where dept_code = 'D5'
UNION All
select emp_id, emp_name, dept_code , salary 
from employee
where salary>3000000;

--intersect ������
select emp_id, emp_name, dept_code, salary 
from employee
where dept_code = 'D5'
intersect
select emp_id, emp_name, dept_code , salary 
from employee
where salary>3000000;

--minus ������
select emp_id, emp_name, dept_code, salary 
from employee
where dept_code = 'D5'
minus
select emp_id, emp_name, dept_code , salary 
from employee
where salary>3000000;
