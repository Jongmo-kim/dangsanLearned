-- 1. 생년이 1970년대이면서 성별은 여자 성이 전씨인 직원들의 사원명 주민번호  부서명 조회
select emp_name,emp_no,dept_title 
from employee 
join department 
on dept_code = dept_ID
where 
    emp_no like '7%-2%' 
    and substr(emp_name,0,1)='전';

--2. 같은 부서에 근무하는 직원들의 사원명, 부서코드, 동료이름 조회
select e1.emp_name 사원명,e1.dept_code 부서코드,e2.emp_name 동료이름
from employee e1
join employee e2 on e1.dept_code = e2.dept_code 
where e1.emp_name != e2.emp_name
order by e1.emp_name;