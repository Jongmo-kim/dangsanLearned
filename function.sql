--length
select emp_name,length(emp_name) "이름길이" , email,length(email) "이메일길이" from employee;

--lengthb
select emp_name ,lengthb(emp_name),email,lengthb(email) from employee;

--instr
select sysdate from dual;
select 'hello world' from dual;
select instr('hello world hi high','h',1,1) from dual; --시작부터 1번쨰 H의 위치 반환
select instr('hello world hi high','h',1,2) from dual;--시작부터 2번쨰 H위치반환
select instr('hello world hi high','h',2,1) from dual; --2번부터1번쨰 H위치반환
select instr('hello world hi high','h',-1,1) from dual; -- -는 뒤부터검색
select instr('hello world hi high','h',-1,2) from dual;
select instr('hello world hi high','h',-1,3) from dual;

select instr(email,'@',1,1) from employee;

-- lpad / rpad
select email,length(email) from employee;
select email,length(email), lpad(email,20,'#') from employee;
select email, length(email), rpad(email,20,'#') from employee;
select email,length(email), lpad(email,10,'#') from employee; --문자열길이 미만이면 짤림

--ltrim/rtrim/trim
select '--kh' from dual;
select ltrim('--kh','-') from dual;
select ltrim('A--kh','-') from dual;
select trim('--kh','-') from dual;
select ltrim('000kh','0') from dual;
select ltrim('123123kh','123123') from dual;
select ltrim('abcabaccaccacabkh','abc') from dual; --a or b or c 다삭제
select rtrim('kh029424292302549023923','0123789456070889') from dual; --숫자삭제 

select trim('z' from 'zzzkhzzz') from dual; --양쪽제거 한글자밖에 못줌
select trim(leading 'z' from 'zzzkhzzz') from dual;--앞쪽에서만 제거
select trim(trailing 'z' from 'zzzkhzzz')from dual;-- 뒤쪽만 ㅔ거
select trim(both 'z' from 'zzzkhzzz')from dual; --default both 

select * from department;
select trim('부' from DEPT_TITLE) from department;

select rtrim(ltrim('63487643867438657348574358787682768hello1290382509812051834806','0123456789'),'0123456789') from dual;

--substr
select substr('showmethemoney',1,3) from dual;
select substr('showmethemoney',5,4) from dual;
select substr('showmethemoney',7) from dual; --지정한 번호부터 끝까지
select substr('showmethemoney',-8,3)from dual; --뒤에서부터 8번째 부터 3글짜
--employee 테이블에서 사원이름중 성만출력
select substr(emp_name,0,1) from employee;

--employee 테이블에서 남자만 사원번호,사원명 주민번호 출력
--단 주민번호는 뒤 6자리는 ******로 출력
select emp_id,emp_name,rpad(substr(emp_no,0,8),14,'*') from employee where substr(emp_no,8,1) = '1';

--lower/upper/inicap
select lower('Welcome To KH') from dual;
select upper('Welcome to KH') from dual;
select initcap('Welcome to KH') from dual; --단어별로 첫글자만 대문자

--concat
select concat('가나다라','abcd') from dual;
select '가나다라'||'abcd' from dual;

--replace 
select replace('안녕하세요HIHELLO','HI','BYE') from dual;

--employee테이블의 모든 직원의 이름, 주민번호, email을 출력
--email주소 출력시 kh.or.kr ->iei.or.kr 변경하여 출력
--sub_di@kh.or.kr -> sud_di@iei.or.kr

select emp_name,emp_no,replace(email,'kh','iei') from employee;

--숫자처리함수
--abs
select abs(10) from dual;
select abs(-10) from dual;
--mod
select mod(10,3) from dual;
select mod(10,2) from dual;
select mod(10,4) from dual;

--round 몇의 자리 반올림
select round(126.456,3) from dual;
select round(126.456,2) from dual;
select round(126.456,1) from dual;
select round(126.456,0) from dual;
select round(126.456,-1) from dual;
select round(126.456,-2) from dual;

--floor 소수점버림
select floor(126.456) from dual;

--trunc 
select trunc(1235) from dual;

-- ceil
select ceil(123.46) from dual;

-- 날자처리함수
--sysdate
select sysdate from dual;
--month_between
select emp_name,hire_date,months_between(sysdate,hire_date) from employee;
-- add_month
select emp_name, hire_date, add_months(hire_date,3) from employee;
--next _day
 -- 1=일요일,2=월요일 ...
 select sysdate, next_day(sysdate,7) from dual;
 --last_day
 select last_day(sysdate) from dual;
 select emp_name,last_day(hire_date) from employee;
 --extract
 select extract(year from sysdate) from dual;
 select extract(day from sysdate) from dual;
 select extract(month from sysdate) from dual;
 select emp_name, 
 extract(year from hire_date) ||'년'||
 extract(month from hire_date) || '월' || 
 extract(day from hire_date)|| '일' 입사일 from employee;
 
 --형변환 함수
 --to_char 날짜 - > 문자
 select to_char(sysdate,'yyyy-mm-dd') from dual;
 select to_char(sysdate,'yyyy/mm/dd') from dual;
 select to_char(sysdate,'yyyy/mm/dd/day') from dual;
 select to_char(sysdate,'yy/mm/dd') from dual;
 select to_char(sysdate,'yyyy/mm/dd/pmhh12"시"mi"분"ss"초"') from dual;
 select to_char(sysdate,'yyyy/mm/dd/hh24"시"mi"분"ss"초"') from dual;
 select to_char(sysdate,'fmyyyy/mm/dd/hh24"시"mi"분"ss"초"') from dual;
 
 --to_char 숫자- > 문자
 select 5000000, to_char(50000000,'999,999,999') from dual;
 select 5000000, to_char(50000000,'000,000,000') from dual;
 select 5000000, to_char(50000000,'999,999,999.99') from dual;
 select 5000000, to_char(50000000,'$999,999,999') from dual;
 select 5000000, to_char(50000000,'L999,999,999') from dual;-- local 원화 단워 = L
 
 --to_date
 select to_date('20200917','yyyymmdd')from dual;
 select to_date(20200917,'yyyymmdd') from dual;
 select to_char(to_date('20200917','yyyymmdd'),'yyyy/mm/dd hh24:mi:ss') from dual;
 select to_char(sysdate,'yyyy/mm/dd hh24:mi:ss') from dual; 

 
--employee테이블에서 2000년도이후에 입사한 사원의 이름, 입사일 조회
select emp_name,hire_date from employee;
select emp_name,hire_date from employee where hire_date > TO_DATE(20000101,'yyyymmdd');

--to_number
select to_number('1234') from dual;
select to_number('1,000,000','9,999,999') from dual;

select to_number('123a') from dual;--문자를 숫자로 바꿀순없음

select 100+100 from dual;
select '100'+'100' from dual; -- 자동 형변환 자바랑 다름
select '100a'+'100' from dual; -- 형변환 에러와 똑같이 나옴 문자열-> 숫자로

-- 직원의 이름, 연봉(보너스 포함된)
select emp_name, (salary * 12 + bonus * salary) from employee;

--nvl null처리함수 
select emp_name,salary*12 연봉,bonus 보너스, (salary * 12 + nvl(bonus,0) * salary) "보너스 포함된 연봉"from employee;

--decode(표현식,조건1,결과1,조건2,결과2 ..)
select emp_name,emp_no,decode(substr(emp_no,8,1),'1','남자','2','여자','3','외국인남자','4','외국인여자') 성별
from employee;

--  case
select emp_name,emp_no,case when substr(emp_no,8,1)In(1,3) then '남자'
                            when substr(emp_no,8,1)In(2,4) then '여자' 
                        end 성별
from employee;

-- sum 누적합계 avg 평균리턴 count 총개수  max 최대값 min 최소값
select salary from employee;
SELECT sum(salary) from employee;
select salary from employee where substr(emp_no,8,1)='1';
select sum(salary) from employee where substr(emp_no,8,1)='1';
-- avg
select to_char(floor(avg(salary)),'L999,999,999')"월급 평균" from employee;
-- count 결과의 로우 순
select count(salary) from employee;
select to_char(floor(sum(salary) /count(salary)),'L999,999,999') "월급 평균"from employee ;

--max 행중 가장 큰값 min 작은값 
select to_char(max(salary),'L999,999,999') from employee;
select to_char(min(salary),'L999,999,999') from employee;

select max(hire_date),min(hire_date) from employee;
