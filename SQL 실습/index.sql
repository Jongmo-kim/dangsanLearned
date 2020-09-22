--index 
--sql 명령문의 처리속도를 향상시키기 위해 컬럼에 대해 생성하는 오라클에 객체로 내부구조는 B트리 형식으로 구성
-- 검색속도가 빨라지고 시스템 부하를 줄여서 성능향상
-- 단점 추가저장공간필요
-- 인덱스 생성시간 필요
-- 변경 작업이 자주 일어나느 경우 성능저하 발생
-- 제일 효율 적인 예 10~15% 이내의 데이터를 검색하는 경우
-- join 조건으로 사용되는경우
-- 데이터변경이없는경우
-- 테이블에 저장된 데이터 용량이 매우 클 경우

--create index 이름 on 테이블명 ...

create index emp_idx on employee(emp_name,emP_no,hire_date);
drop index emp_idx;
-- f10 계획설명
select emp_name,emp_no, hire_date from employee;