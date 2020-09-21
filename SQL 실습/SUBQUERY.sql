select avg(salary) from employee;
select emp_id,emp_name, salary from employee 
where salary >= (select avg(salary) from employee);

-- �� ���� ������ ������ �̸� ���
select emp_name 
from employee 
where emp_id = 
(select manager_id from employee where emp_name = '������');

-- �������� �޿��� ���� ������� �˻��ؼ� �����ȣ �̸� �޿� ���
-- ��, �������� ��µǸ� �ȵ�

select emp_id,emp_name,salary from employee
where salary = (
                    select salary 
                    from employee
                    where 
                        emp_name = '������'
                )
            and
    emp_name != '������';

--employee���̺��� �޿��� ���� ��������� ���� ���������
-- ��� ����� �޿� ���
select emp_id, emp_name, salary from employee
where salary = (select max(salary) from employee) 
or salary = (select min(salary) from employee);

-- D1,D2 �μ��� �ٹ��ϴ� �������
-- �޿��� D5 �μ��� �������� ��ձ޿����� ���� �������
-- �����ȣ ����� �޿� ���
select emp_id, emp_name, salary from employee
where dept_code in ('D1','D2') and
salary > (select avg(salary) from employee where dept_code = 'D5');

--������ �������� ( IN / NOT IN)
-- ���߱�, �ڳ��� ���� �μ��� ����� ���� ���
--1. ���߱�, �ڳ��� ���� �μ���ȸ
select dept_code from employee where emp_name in ('������','�ڳ���');

select * from employee
where
    dept_code in (
                    select dept_code 
                    from 
                        employee 
                    where 
                        emp_name 
                    in
                        ('������','�ڳ���')
                );
-- JOIN ����
-- ������ ��ǥ, �λ����� ����� �̸�, ���޸�, �μ��ڵ� ���
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
                    job_name in ('��ǥ','�λ���')
            );
            
-- ���� �� ��������
-- ����� �������� ����
-- �� ������ ���� �μ�, ���� ���޿� �ش��ϴ� ����� �̸� ���� �Ի���
-- 1. ����� �������� �μ� ������ȸ
select dept_code, job_code from employee
where substr(emp_no,8,1) = 2 and ent_yn ='Y';

select emp_name, job_code, hire_date
from employee
where (dept_code, job_code) in (
                        select dept_code, job_code from employee
                        where substr(emp_no,8,1) = 2 and ent_yn ='Y'
);

--������ ���߿�
-- ���޺� �ּұ޿��� �޴� ������ �̸�, ��� , �μ� �ڵ�, �޿�
--1. ���޺� �ּұ޿�
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


--������� -> ��ȣ��������
-- ���������� ���� ���������� �ְ� ���������� ��������
-- �������� ����
-- ���������� where���� �����ϱ� ���� ���������� ���� �ʿ��� ���
-- ���������� ���� ���� ���� �������� ���� �޶����� �ϴ� ��� ���

select * from employee;
--�����ڰ� �ִ� ����� �� �������� ����� employee���̺� �����ϴ�
-- ������ ��� �̸� �μ��ڵ� ������ ��� ��ȸ

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

-- �λ������, ȸ�������, �����úο� �ִ� ���� �̸�, �μ��ڵ� , �޿���
-- �̸��� ���� �������� ��ȸ�϶�
select emp_name, dept_code, salary 
from employee e1
where 
exists
    (select
        1
        from department d
    where
        d.dept_title IN('�λ������','ȸ�������','�����ú�')
        and
        e1.dept_code = d.dept_id
        )
        order by 1;

-- ��Į�� ��������
-- ������� �̸鼭 ������� 1���� ��������
-- 1.��Į�� �������� select ��
-- ������� ���, �̸� , �����ڻ�� , ��������� ��ȸ
select e1.emp_id, e1.emp_name,e1.manager_ID,
NVL((select e2.emp_name from employee e2 where e1.manager_id =e2.emp_id),'����') �������
from employee e1;

select dept_code,floor(avg(salary)) from employee e2 
where e2.dept_code = e2.dept_code 
group by dept_code order by dept_code;
select * from employee;
select * from employee;
-- ����� �μ��ڵ� �ش�μ��� ����ӱ� ���
select e1.emp_name, e1.dept_code
,(select floor(avg(e2.salary)) from employee e2 
    where e1.dept_code = e2.dept_code
    group by dept_code
)�μ�������ӱ�
from employee e1
where dept_code is not null;

-- ��Į�� �������� - where ��
-- �ڽ��� ���� ������ ��� �޿����� ���� �޴� ������ �̸�, �����ڵ� �޿�
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

-- ��Į�󼭺����� order by ��
-- ��� ������ ���, �̸� , �μ��ڵ带 �μ��� ������ ��ȸ
select emp_no, emp_name, dept_code from employee e1
order by (select dept_title from department d where e1.dept_code = dept_id)
;
-- ��Į�� �������� - from �� - > �ζ��� ��
-- ��Į�󼭺������� ����� �ϳ��� ���̺�� ����ϴ� ����
select emp_name, salary,dept_code,job_code from employee order by 2 desc;

select rownum, e.* from (select emp_name, salary,dept_code,job_code from employee order by 2 desc) e;
