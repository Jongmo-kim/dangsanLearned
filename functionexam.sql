--1.직원명과 이메일, 이메일 길이를 출력하시오
select email, length(email) "이메일 길이" from employee;

--2. 직원의 이름과 이메일 주소중 아이디 부분만 출력하시오.
select emp_name 이름,substr(email,0,instr(email,'@')-1) 이메일 from employee;

--3. 60년대생의 직원명과 년생, 보너스값을 출력하시오
select emp_name 직원명,substr(emp_no,0,2) 년생,
nvl(bonus,0) 보너스  from employee 
where substr(emp_no,0,2) < 70;

--4. 010 핸드폰 번호를 쓰지 않는 사람의 수를 입력하시오 뒤에 명을 붙이시오
select count(emp_no)||'명' 인원 from employee where substr(phone,0,3) != '010';

--5. 직원명과 입사년월을 출력하시오.
select emp_name 직원명,to_char(hire_date,'yyyy"년"mm"월"') 입사년월 from employee;

--6. 직원명, 직급코드, 연봉(원) 조회
-- 단, 연봉은 57,000,000 으로 표시되게함
-- 연봉은 보너스 포인트가 적용된 1년차 급여임.
select emp_name,job_code,to_char(salary*12 + ((nvl(bonus,0) * (salary*12))) ,'L999,999,999') 연봉 from employee;

--7. 부서코드가 d5,d9인 직원들 중에서 2004년도에 입사한 직원의 사번 사원명 부서코드 입사일 조회
select emp_id 사번,emp_name 사원명,dept_code 부서코드,hire_date 입사일 from employee
where dept_code in('D5','D9') 
and extract(year from hire_date) = extract(year from to_date('2004/01/01','yyyy/mm/dd'));

--8. 직원명, 입사일, 오늘까지의 근무일수 조회
-- 단, 주말도 포함, 소수점 아래는 버림
select emp_name 직원명,hire_date 입사일,floor((sysdate-hire_date)) 근무일수 from employee;

--9. 모든 직원의 나이중 가장 많은 나이와 가장 적은 나이를 출력하여라. (나이만 출력)
select
    extract(year from sysdate) - (min(to_number(substr(emp_no,0,2)))+1900) "최대나이" ,
    extract(year from sysdate) - (max(to_number(substr(emp_no,0,2)))+1900) "최소나이" 
from employee;

--10. 회사에서 야근을 해야되는 부서를 발표하여야 한다.
-- 부서코드가 d5,d6,d9 야근, 그외는 야근없음으로 출력되도록 하여라.
-- 출력값은 이름,부서코드,야근유무 (부서코드 기준 오름차순 정렬함.)
--  (부서코드가 null인 사람도 야근없음임)
select emp_name,dept_code,
    case 
        when dept_code in ('D5','D6','D9') then '야근'
        else '야근없음'
    end as "야근유무"
from employee;

select emp_name,dept_code, 
decode(dept_code,'D5','야근','D6','야근','D9','야근','야근없음') 
야근유무
from employee order by dept_code;

-- 11.직원명, 부서코드, 생년원일, 나이조회
-- 단, 생년월일은 주민번호에서 추출해서
-- ㅇㅇ년 ㅇㅇ월 ㅇㅇ일로 출력되게함
-- 나이는 주민번호에서 추출해서 날자데이터로 변환한 다음, 계산함
-- * 주민번호가 이상한 사람들은 제외시키고 진행 200,201,214 제외

select * from employee;
select emp_name,dept_code,
    to_char(to_date(substr(emp_no,0,6),'yymmdd'),'yy"년"mm"월"dd"일"') 생년월일,
    extract(year from sysdate) - (extract(year from to_date(substr(emp_no,0,6),'YYMMDD'))-101)  나이  
from employee 
where EMP_ID not In(200,201,214);

--12. 직원들의 입사일로부터 년도만 가지고, 각 년도별 입사인원수를 구하시오
-- 1998년~2004 년에 입사한 인원수를 조회하시오. 마지막으로 전체 직원수도 구하시오.
--1998년 구하기
select count(*) from employee 
where 
extract(year from hire_date) = extract(year from to_date('1998','yyyy'));


select 
(select count(*) 
    from employee 
    where extract(year from hire_date) = extract(year from to_date('1998','yyyy'))
) as "1998년",
(select count(*) 
    from employee 
    where extract(year from hire_date) = extract(year from to_date('1999','yyyy'))
) as "1999년",
(select count(*) 
    from employee 
    where extract(year from hire_date) = extract(year from to_date('2000','yyyy'))
) as "2000년",
(select count(*) 
    from employee 
    where extract(year from hire_date) = extract(year from to_date('2001','yyyy'))
) as "2001년",
(select count(*) 
    from employee 
    where extract(year from hire_date) = extract(year from to_date('2002','yyyy'))
) as "2002년",
(select count(*) 
    from employee 
    where extract(year from hire_date) = extract(year from to_date('2003','yyyy'))
) as "2003년",
(select count(*) 
    from employee 
    where extract(year from hire_date) = extract(year from to_date('2004','yyyy'))
) as "2004년",
(select count(*)
    from employee 
) as "전체직원수"
from dual;
