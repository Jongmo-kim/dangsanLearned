select emp_name 이름, email 이메일 from employee where email LIKE '%s%';

select EMAIL from employee;
--email 중 _앞의 글자가 3글자인 직원의 이메일 주소 출력
select EMAIL from employee where EMAIL LIKE '___#_%'ESCAPE'#';-- #_ 문자열 언더바

select EMP_NAME FROM EMPLOYEE where emp_name not LIKE '이%'; --이씨성을 제외한 모두

select emp_name 이름,Bonus from employee where BONUS is null;--보너스를 받지 않는 직원
select emp_name 이름,Bonus from employee where BONUS is not null;--보너스를 받는 직원

-- 부서 코드가 D6 이거나 D8 인직원의 이름 부서코드, 급여 조회
select emp_name 이름,dept_code 부서코드, salary 급여 from employee where dept_code IN('D6', 'D8');
select emp_name 이름,dept_code 부서코드, salary 급여 from employee where dept_code = 'D6' or dept_code = 'D8'; --위와 동일

select emp_name 이름,dept_code 부서코드, salary 급여 from employee where dept_code NOT IN('D6', 'D8');

-- 부서원중 직급코드가 j7 또는 j2이고 급여가 20000000원 초과인 사람의 이름 급여 직급코드 출력
select emp_name 이름,salary 급여,job_code 직급코드 from employee 
where  salary > 2000000 AND job_code IN('J2','J7');

select emp_name 이름,salary 급여,job_code 직급코드 from employee 
where  (job_code ='J7' or job_code = 'J2') AND salary >2000000;


--정렬 
--ORDER BY : select한 컬럼에 대해 정렬할떄 사용하는 구문
-- select 문 가장 마지막에 작성ㄷ 실행도 가장 마지막에 실행
-- asc number 작-> 큰 character 사전순 date 빠른->늦    null제일아래
-- desc number 큰->작 character 사전역순 date 늦 -> 빠른 null 위
select emp_name,salary from employee order by salary asc; --asc default 
select emp_name,salary from employee order by salary desc; -- desc 내림차순

--job cod가 j7이거나 j2인 직원들의 이름 급여,job_code 출력
--이름으로 내림차순 출력
select emp_name,salary,job_code from employee
where job_code In ('J7','J2') order by emp_name desc;

--출력된것을 기준으로 컬럼을 지정해서 출력가능
select emp_name,salary,job_code from employee
where job_code In ('J7','J2') order by 2 desc; --2 == salary

-- 문제1. 
-- 입사일이 5년 이상, 10년 이하인 직원의 이름,주민번호,급여,입사일을 검색하여라
select emp_name 이름,emp_no 주민등록번호,salary 급여,hire_date 입사일 from employee
where( sysdate-hire_date) / 365 between 5 and 10;
-- 문제2.
-- 재직중이 아닌 직원의 이름,부서코드를 검색하여라 (퇴사 여부 : ENT_YN)
select emp_name,dept_code from employee where ent_yn ='Y';
-- 문제3.
-- 근속년수가 10년 이상인 직원들을 검색하여
-- 출력 결과는 이름,급여,근속년수를 근속년수가 오름차순으로 정렬하여 출력하여라
-- 단, 급여는 50% 인상된 급여로 출력되도록 하여라.
select 
    emp_name 이름,
    salary*1.5 급여, 
    floor((sysdate-hire_date)/365) 근속년수 
from employee
where 
    floor((sysdate-hire_date)/365) >= 10 
order by 3 asc;

-- 문제4.
-- 입사일이 99/01/01 ~ 10/01/01 인 사람 중에서 급여가 2000000 원 이하인 사람의
-- 이름,주민번호,이메일,폰번호,급여를 검색 하시오
select 
    emp_name 이름,
    emp_no 주민번호,
    email 이메일,
    phone 폰번호,
    salary 급여 
from employee
where 
    hire_date between TO_DATE('1999/01/01','yyyy/MM/dd') AND TO_DATE('2010/01/01','yyyy/MM/dd') 
    and salary < 2000000;

-- 문제5.
-- 급여가 2000000원 ~ 3000000원 인 여직원 중에서 4월 생일자를 검색하여 
-- 이름,주민번호,급여,부서코드를 주민번호 순으로(내림차순) 출력하여라
select 
    emp_name 이름,
    emp_no 주민번호, 
    salary 급여,
    dept_code 부서코드 
from employee
where emp_no like '%-2%' 
    and (salary between 2000000 and 3000000) 
    and emp_no like '__04__-%'
order by emp_no desc;
-- 문제6.
-- 남자 사원 중 보너스가 없는 사원의 오늘까지 근무일을 측정하여 
-- 1000일 마다(소수점 제외) 
-- 급여의 10% 보너스를 계산하여 이름,특별 보너스 (계산 금액) 결과를 출력하여라.
-- 단, 이름 순으로 오름 차순 정렬하여 출력하여라.
select 
    emp_name 이름, 
    salary * 0.1 * floor((sysdate - hire_date)/1000) 특별보너스
from employee
where 
    bonus is null and
    floor((sysdate -hire_date)/1000) != 0 and
    emp_no like '%-1%' 
order by emp_name;