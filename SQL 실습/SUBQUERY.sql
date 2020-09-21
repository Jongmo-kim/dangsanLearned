select avg(salary) from employee;
select emp_id,emp_name, salary from employee 
where salary >= (select avg(salary) from employee);

-- 전 지연 직원의 관리자 이름 출력
select emp_name 
from employee 
where emp_id = 
(select manager_id from employee where emp_name = '전지연');

-- 윤은혜와 급여가 같은 사원들을 검색해서 사원번호 이름 급여 출력
-- 단, 윤은혜는 출력되면 안됨

select emp_id,emp_name,salary from employee
where salary = (
                    select salary 
                    from employee
                    where 
                        emp_name = '윤은해'
                )
            and
    emp_name != '윤은해';

--employee테이블에서 급여가 가장 많은사람과 가장 적은사람의
-- 사번 사원명 급여 출력
select emp_id, emp_name, salary from employee
where salary = (select max(salary) from employee) 
or salary = (select min(salary) from employee);

-- D1,D2 부서에 근무하는 사원들중
-- 급여가 D5 부서의 직원들의 평균급여보다 많은 사람들의
-- 사원번호 사원명 급여 출력
select emp_id, emp_name, salary from employee
where dept_code in ('D1','D2') and
salary > (select avg(salary) from employee where dept_code = 'D5');

--다중행 서브쿼리 ( IN / NOT IN)
-- 송중기, 박나라가 속한 부서의 사원들 정보 출력
--1. 송중기, 박나라가 속한 부서조회
select dept_code from employee where emp_name in ('송종기','박나라');

select * from employee
where
    dept_code in (
                    select dept_code 
                    from 
                        employee 
                    where 
                        emp_name 
                    in
                        ('송종기','박나라')
                );
-- JOIN 포함
-- 직급이 대표, 부사장인 사원의 이름, 직급명, 부서코드 출력
select 
    emp_name,
    job_name,
    dept_code 
from
    employee
join
    job
on job_code in ( 'J1','J2');

where job_code in (
                select 
                    job_code
                from
                    job
                where
                    job_name in ('대표','부사장')
            );
            
-- 다중 열 서브쿼리
-- 퇴사한 여직원이 존재
-- 그 직원과 같은 부서, 같은 직급에 해당하는 사원의 이름 직급 입사일
-- 1. 퇴사한 여직원의 부서 직급조회
select dept_code, job_code from employee
where substr(emp_no,8,1) = 2 and ent_yn ='Y';

select emp_name, job_code, hire_date
from employee
where (dept_code, job_code) in (
                        select dept_code, job_code from employee
                        where substr(emp_no,8,1) = 2 and ent_yn ='Y'
);

--다중행 다중열
-- 직급별 최소급여를 받는 직원의 이름, 사번 , 부서 코드, 급여
--1. 직급별 최소급여
select job_code,min(salary)
from employee
group by job_code;

select emp_name, emp_id,dept_code,salary
from employee
where (job_code,salary) in (
            select job_code,min(salary)
            from employee
            group by job_code
);


--상관쿼리 -> 성호연관쿼리
-- 메인쿼리의 값을 서브쿼리에 주고 서브쿼리를 수행한후
-- 메인쿼리 동작
-- 서브쿼리의 where절을 수행하기 위해 메인쿼리의 값이 필요한 경우
-- 메인쿼리의 각행 값에 따라 서브쿼리 값이 달라져야 하는 경우 사용

select * from employee;
--관리자가 있는 사원들 중 관리자의 사번이 employee테이블에 존재하는
-- 직원의 사번 이름 부서코드 관리자 사번 조회

select emp_id,emp_name,dept_code,manager_id
from employee e1
where exists (
            select 
                1 
            from 
                employee e2
            where
                e1.manager_id = e2.emp_id
            )
;

-- 인사관리부, 회계관리부, 마케팅부에 있는 직원 이름, 부서코드 , 급여를
-- 이름에 맞춰 정렬한후 조회하라
select emp_name, dept_code, salary 
from employee e1
where 
exists
    (select
        1
        from department d
    where
        d.dept_title IN('인사관리부','회계관리부','마케팅부')
        and
        e1.dept_code = d.dept_id
        )
        order by 1;

-- 스칼라 서브쿼리
-- 상관쿼리 이면서 결과값이 1개인 서브쿼리
-- 1.스칼라 서브쿼리 select 절
-- 모든사원의 사번, 이름 , 관리자사번 , 관리장명을 조회
select e1.emp_id, e1.emp_name,e1.manager_ID,
NVL((select e2.emp_name from employee e2 where e1.manager_id =e2.emp_id),'없음') 관리장명
from employee e1;

select dept_code,floor(avg(salary)) from employee e2 
where e2.dept_code = e2.dept_code 
group by dept_code order by dept_code;
select * from employee;
select * from employee;
-- 사원명 부서코드 해당부서의 평균임금 출력
select e1.emp_name, e1.dept_code
,(select floor(avg(e2.salary)) from employee e2 
    where e1.dept_code = e2.dept_code
    group by dept_code
)부서별평균임금
from employee e1
where dept_code is not null;

-- 스칼라 서브쿼리 - where 절
-- 자신이 속한 직급의 평균 급여보다 많이 받는 직원의 이름, 직급코드 급여
select e1.emp_name, e1.job_code, e1.salary
from employee e1
where
    salary >= 
    (
        select
            avg(salary)
        from employee e2
        where
            e2.job_code = e1.job_code
    )
;

-- 스칼라서브쿼리 order by 절
-- 모든 직원의 사번, 이름 , 부서코드를 부서명 순으로 조회
select emp_no, emp_name, dept_code from employee e1
order by (select dept_title from department d where e1.dept_code = dept_id)
;
-- 스칼러 서브쿼리 - from 절 - > 인라인 뷰
-- 스칼라서브쿼리의 결과를 하나의 테이블로 사용하는 구조
select emp_name, salary,dept_code,job_code from employee order by 2 desc;

select rownum, e.* from (select emp_name, salary,dept_code,job_code from employee order by 2 desc) e;
