select emp_name �̸�, email �̸��� from employee where email LIKE '%s%';

select EMAIL from employee;
--email �� _���� ���ڰ� 3������ ������ �̸��� �ּ� ���
select EMAIL from employee where EMAIL LIKE '___#_%'ESCAPE'#';-- #_ ���ڿ� �����

select EMP_NAME FROM EMPLOYEE where emp_name not LIKE '��%'; --�̾����� ������ ���

select emp_name �̸�,Bonus from employee where BONUS is null;--���ʽ��� ���� �ʴ� ����
select emp_name �̸�,Bonus from employee where BONUS is not null;--���ʽ��� �޴� ����

-- �μ� �ڵ尡 D6 �̰ų� D8 �������� �̸� �μ��ڵ�, �޿� ��ȸ
select emp_name �̸�,dept_code �μ��ڵ�, salary �޿� from employee where dept_code IN('D6', 'D8');
select emp_name �̸�,dept_code �μ��ڵ�, salary �޿� from employee where dept_code = 'D6' or dept_code = 'D8'; --���� ����

select emp_name �̸�,dept_code �μ��ڵ�, salary �޿� from employee where dept_code NOT IN('D6', 'D8');

-- �μ����� �����ڵ尡 j7 �Ǵ� j2�̰� �޿��� 20000000�� �ʰ��� ����� �̸� �޿� �����ڵ� ���
select emp_name �̸�,salary �޿�,job_code �����ڵ� from employee 
where  salary > 2000000 AND job_code IN('J2','J7');

select emp_name �̸�,salary �޿�,job_code �����ڵ� from employee 
where  (job_code ='J7' or job_code = 'J2') AND salary >2000000;


--���� 
--ORDER BY : select�� �÷��� ���� �����ҋ� ����ϴ� ����
-- select �� ���� �������� �ۼ��� ���൵ ���� �������� ����
-- asc number ��-> ū character ������ date ����->��    null���ϾƷ�
-- desc number ū->�� character �������� date �� -> ���� null ��
select emp_name,salary from employee order by salary asc; --asc default 
select emp_name,salary from employee order by salary desc; -- desc ��������

--job cod�� j7�̰ų� j2�� �������� �̸� �޿�,job_code ���
--�̸����� �������� ���
select emp_name,salary,job_code from employee
where job_code In ('J7','J2') order by emp_name desc;

--��µȰ��� �������� �÷��� �����ؼ� ��°���
select emp_name,salary,job_code from employee
where job_code In ('J7','J2') order by 2 desc; --2 == salary

-- ����1. 
-- �Ի����� 5�� �̻�, 10�� ������ ������ �̸�,�ֹι�ȣ,�޿�,�Ի����� �˻��Ͽ���
select emp_name �̸�,emp_no �ֹε�Ϲ�ȣ,salary �޿�,hire_date �Ի��� from employee
where( sysdate-hire_date) / 365 between 5 and 10;
-- ����2.
-- �������� �ƴ� ������ �̸�,�μ��ڵ带 �˻��Ͽ��� (��� ���� : ENT_YN)
select emp_name,dept_code from employee where ent_yn ='Y';
-- ����3.
-- �ټӳ���� 10�� �̻��� �������� �˻��Ͽ�
-- ��� ����� �̸�,�޿�,�ټӳ���� �ټӳ���� ������������ �����Ͽ� ����Ͽ���
-- ��, �޿��� 50% �λ�� �޿��� ��µǵ��� �Ͽ���.
select 
    emp_name �̸�,
    salary*1.5 �޿�, 
    floor((sysdate-hire_date)/365) �ټӳ�� 
from employee
where 
    floor((sysdate-hire_date)/365) >= 10 
order by 3 asc;

-- ����4.
-- �Ի����� 99/01/01 ~ 10/01/01 �� ��� �߿��� �޿��� 2000000 �� ������ �����
-- �̸�,�ֹι�ȣ,�̸���,����ȣ,�޿��� �˻� �Ͻÿ�
select 
    emp_name �̸�,
    emp_no �ֹι�ȣ,
    email �̸���,
    phone ����ȣ,
    salary �޿� 
from employee
where 
    hire_date between TO_DATE('1999/01/01','yyyy/MM/dd') AND TO_DATE('2010/01/01','yyyy/MM/dd') 
    and salary < 2000000;

-- ����5.
-- �޿��� 2000000�� ~ 3000000�� �� ������ �߿��� 4�� �����ڸ� �˻��Ͽ� 
-- �̸�,�ֹι�ȣ,�޿�,�μ��ڵ带 �ֹι�ȣ ������(��������) ����Ͽ���
select 
    emp_name �̸�,
    emp_no �ֹι�ȣ, 
    salary �޿�,
    dept_code �μ��ڵ� 
from employee
where emp_no like '%-2%' 
    and (salary between 2000000 and 3000000) 
    and emp_no like '__04__-%'
order by emp_no desc;
-- ����6.
-- ���� ��� �� ���ʽ��� ���� ����� ���ñ��� �ٹ����� �����Ͽ� 
-- 1000�� ����(�Ҽ��� ����) 
-- �޿��� 10% ���ʽ��� ����Ͽ� �̸�,Ư�� ���ʽ� (��� �ݾ�) ����� ����Ͽ���.
-- ��, �̸� ������ ���� ���� �����Ͽ� ����Ͽ���.
select 
    emp_name �̸�, 
    salary * 0.1 * floor((sysdate - hire_date)/1000) Ư�����ʽ�
from employee
where 
    bonus is null and
    floor((sysdate -hire_date)/1000) != 0 and
    emp_no like '%-1%' 
order by emp_name;