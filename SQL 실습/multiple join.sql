-- employee�� ���� location ��ȸ
select emp_name,dept_title,national_code, local_name
from employee
left join department on dept_id=dept_code  --�ݵ�� ���̺� �ߺ��� �÷��� �־���Ѵ�.
left join location on location_id = local_code;