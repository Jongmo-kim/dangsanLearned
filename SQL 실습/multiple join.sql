-- employee엔 없는 location 조회
select emp_name,dept_title,national_code, local_name
from employee
left join department on dept_id=dept_code  --반드시 테이블에 중복된 컬럼이 있어야한다.
left join location on location_id = local_code;