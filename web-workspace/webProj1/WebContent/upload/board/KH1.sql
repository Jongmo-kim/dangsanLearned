select * from employee;

-- EMPLOYEE 테이블에서 '전' 씨 성을 가진 직원의 이름과 급여 조회
SELECT EMP_NAME, SALARY FROM EMPLOYEE WHERE EMP_NAME LIKE '전__';
SELECT EMP_NAME, SALARY FROM EMPLOYEE WHERE EMP_NAME LIKE '전%';
--이름이 '전'인 사람 조회
SELECT CMP_NAME, SALARY FROM EMPLOYEE WHERE EMP_NAME='전';
SELECT * FROM EMPLOYEE;

--EMAIL주소 중 S가 포함되어있는 직원의 이름과 EMIL주소 출력

SELECT EMP_NAME,EMAIL FROM EMPLOYEE WHERE EMAIL LIKE '%s%'; 

SELECT EMP_NAME, EMAIL FROM EMPLOYEE WHERE EMAIL NOT LIKE '%s%';


SELECT EMAIL FROM EMPLOYEE;

--EMAIL중 '_'앞의 글자가 3글자인 직원의 이메일주소 출력


SELECT EMAIL FROM EMPLOYEE WHERE EMAIL LIKE '___#_%'ESCAPE '#';

SELECT EMP_NAME FROM EMPLOYEE WHERE EMP_NAME NOT LIKE '이%';

SELECT * FROM EMPLOYEE;

SELECT EMP_NAME, BONUS FROM EMPLOYEE WHERE BONUS  IS NULL;

SELECT EMP_NAME, BONUS FROM EMPLOYEE WHERE BONUS  IS NOT NULL;

-- 부서코드가 D6이거나 D8인 직원의 이름, 부서코드, 급여조회

SELECT EMP_NAME, DEPT_CODE, SALARY FROM EMPLOYEE WHERE DEPT_CODE= 'D6' OR DEPT_CODE= 'D8';

SELECT EMP_NAME, DEPT_CODE, SALARY FROM EMPLOYEE WHERE DEPT_CODE IN('D6','D8');

SELECT EMP_NAME, DEPT_CODE, SALARY FROM EMPLOYEE WHERE DEPT_CODE NOT IN('D6,D8,D1');

-- 부서원 중 직급코드가  J7 또는 J2이고, 급여가 2000000원 초과인 사람의 이름, 급여, 직급코드 출력
SELECT EMP_NAME, JOB_CODE, SALARY FROM EMPLOYEE WHERE JOB_CODE IN('J2','J7') AND SALARY > 2000000;

SELECT EMP_NAME, JOB_CODE, SALARY FROM EMPLOYEE WHERE (JOB_CODE =('J7') OR JOB_CODE =('J2')) AND SALARY >2000000; 
-- J2 AND SALARY가 먼저 조건검사하기때문에 괄호 감싸준다


--정렬
-- ORDER BY : SELECT 한 컬럼에 대해 정렬할 때 사용하는 구문
-- SELECT문 가장 마지막에 작성, 실행도 가장마지막에 실행
SELECT EMP_NAME, SALARY FROM EMPLOYEE ORDER BY SALARY; --오름차순 정렬

SELECT EMP_NAME, SALARY FROM EMPLOYEE ORDER BY SALARY ASC; --오름차순 정렬
SELECT EMP_NAME, SALARY FROM EMPLOYEE ORDER BY SALARY DESC;--내림차순 정렬

--데이터 정렬
 --       NUMBER      CHARACTER          DATE         NULL
 --ASC    작->큰        사전순            빠->늦        아래
 --DESK   큰->작        사전역순          늦->빠         위
 --ORDER BY 는 SELECT문 가장 마지막
-- ASC DESC 생략시 자동으로 ASC적용

--JOB_CODE가 J7이거나 J2인 직원들의 이름, 급여, JOB_CODE 출력 이름으로 내림차순
SELECT *FROM EMPLOYEE;

SELECT EMP_NAME, SALARY, JOB_CODE FROM EMPLOYEE WHERE JOB_CODE IN ('J7','J2')ORDER BY 1 DESC;
--숫자 1은 컬럼 자리 (1=NAME 내림차순정렬)(2=SALARY 내림차순정렬)(3=JOB_CODE 내림차순정렬)
SELECT SALARY, EMP_NAME, JOB_CODE FROM EMPLOYEE WHERE JOB_CODE IN ('J7','J2')ORDER BY 2 DESC;
-- 문제1. 
-- 입사일이 5년 이상, 10년 이하인 직원의 이름,주민번호,급여,입사일을 검색하여라
SELECT EMP_NAME, HIRE_DATE FROM EMPLOYEE;
SELECT EMP_NAME, FLOOR(SYSDATE - HIRE_DATE) 근무일 FROM EMPLOYEE;
SELECT EMP_NAME, EMP_NO, SALARY, HIRE_DATE FROM EMPLOYEE WHERE (SYSDATE-HIRE_DATE)/365 BETWEEN 5 AND 10;
-- 문제2.
-- 재직중이 아닌 직원의 이름,부서코드를 검색하여라 (퇴사 여부 : ENT_YN)
SELECT EMP_NAME, DEPT_CODE FROM EMPLOYEE WHERE ENT_YN='Y';
-- 문제3.
-- 근속년수가 10년 이상인 직원들을 검색하여
-- 출력 결과는 이름,급여,근속년수를 근속년수가 오름차순으로 정렬하여 출력하여라
SELECT EMP_NAME, SALARY*0.5, HIRE_DATE FROM EMPLOYEE WHERE (SYSDATE-HIRE_DATE)/365 >=10 ORDER BY HIRE_DATE ASC;
-- 단, 급여는 50% 인상된 급여로 출력되도록 하여라.

-- 문제4.
-- 입사일이 99/01/01 ~ 10/01/01 인 사람 중에서 급여가 2000000 원 이하인 사람의
-- 이름,주민번호,이메일,폰번호,급여를 검색 하시오
SELECT EMP_NAME, EMP_NO, EMAIL, PHONE, SALARY FROM EMPLOYEE WHERE HIRE_DATE BETWEEN '99/01/01' AND '10/01/01' AND SALARY<2000001;
-- 문제5.
-- 급여가 2000000원 ~ 3000000원 인 여직원 중에서 4월 생일자를 검색하여 
-- 이름,주민번호,급여,부서코드를 주민번호 순으로(내림차순) 출력하여라
SELECT EMP_NAME, EMP_NO, SALARY, DEPT_CODE FROM EMPLOYEE WHERE SALARY BETWEEN 2000000 AND 3000000 AND EMP_NO LIKE '___4___2%'ORDER BY EMP_NO DESC; 

-- 문제6.
-- 남자 사원 중 보너스가 없는 사원의 오늘까지 근무일을 측정하여 
-- 1000일 마다(소수점 제외) 
-- 급여의 10% 보너스를 계산하여 이름,특별 보너스 (계산 금액) 결과를 출력하여라.
-- 단, 이름 순으로 오름 차순 정렬하여 출력하여라.
SELECT EMP_NAME, FLOOR((SYSDATE-HIRE_DATE)/1000)*(SALARY*0.1) AS "특별보너스" FROM EMPLOYEE WHERE EMP_NO LIKE '_______1%' AND BONUS  IS NULL  ORDER BY EMP_NAME ASC; 







-- 문제1. 
-- 입사일이 5년 이상, 10년 이하인 직원의 이름,주민번호,급여,입사일을 검색하여라
SELECT EMP_NAME, EMP_NO,SALARY,HIRE_DATE
-- 문제2.
-- 재직중이 아닌 직원의 이름,부서코드를 검색하여라 (퇴사 여부 : ENT_YN)
-- 문제3.
-- 근속년수가 10년 이상인 직원들을 검색하여
-- 출력 결과는 이름,급여,근속년수를 근속년수가 오름차순으로 정렬하여 출력하여라
-- 단, 급여는 50% 인상된 급여로 출력되도록 하여라.
-- 문제4.
-- 입사일이 99/01/01 ~ 10/01/01 인 사람 중에서 급여가 2000000 원 이하인 사람의
-- 이름,주민번호,이메일,폰번호,급여를 검색 하시오
-- 문제5.
-- 급여가 2000000원 ~ 3000000원 인 여직원 중에서 4월 생일자를 검색하여 
-- 이름,주민번호,급여,부서코드를 주민번호 순으로(내림차순) 출력하여라
-- 문제6.
-- 남자 사원 중 보너스가 없는 사원의 오늘까지 근무일을 측정하여 
-- 1000일 마다(소수점 제외) 
-- 급여의 10% 보너스를 계산하여 이름,특별 보너스 (계산 금액) 결과를 출력하여라.
-- 단, 이름 순으로 오름 차순 정렬하여 출력하여라.












