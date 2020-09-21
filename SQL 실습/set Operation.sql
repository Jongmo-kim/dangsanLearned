--부서코드가 d5인 직원의 emp_id, emp_name, dept_code, salary
select emp_id, emp_name, dept_code, salary 
from employee
where dept_code = 'D5';
-- salary가 300만원보다 큰사람의 emp_id, emp_name, dept_code, salary
select emp_id, emp_name, dept_code , salary 
from employee
where salary>3000000;
--union을 전체 게시판  통합검색 할떄 쓰긴함
--set operator
--합집합 UNION
select emp_id, emp_name, dept_code, salary 
from employee
where dept_code = 'D5'
UNION
select emp_id, emp_name, dept_code , salary 
from employee
where salary>3000000;


--union all 정렬안하고 중복된 컬럼도 나옴
select emp_id, emp_name, dept_code, salary 
from employee
where dept_code = 'D5'
UNION All
select emp_id, emp_name, dept_code , salary 
from employee
where salary>3000000;

--intersect 교집합
select emp_id, emp_name, dept_code, salary 
from employee
where dept_code = 'D5'
intersect
select emp_id, emp_name, dept_code , salary 
from employee
where salary>3000000;

--minus 차집합
select emp_id, emp_name, dept_code, salary 
from employee
where dept_code = 'D5'
minus
select emp_id, emp_name, dept_code , salary 
from employee
where salary>3000000;
