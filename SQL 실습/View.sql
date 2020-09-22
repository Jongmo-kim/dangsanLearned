create view emp_view
as 
select emp_id,emp_name,phone,email from employee;

create table emp_test
as 
select emp_id,emp_name,phone,email from employee;

--view 얕은복사
--table 깊은복사 with read only 뷰에대해 조회만가능
-- with check option 옵션을 설정한 컬럼의 값은 수정 불가
select * from employee;
select * from emp_view;
select * from emp_test;

update emp_test set phone = '0103654485' where emp_name = '심봉선';
update emp_view set phone = '0103654485' where emp_name = '심봉선';