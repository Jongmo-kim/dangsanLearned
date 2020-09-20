--1.������� �̸���, �̸��� ���̸� ����Ͻÿ�
select email, length(email) "�̸��� ����" from employee;

--2. ������ �̸��� �̸��� �ּ��� ���̵� �κи� ����Ͻÿ�.
select emp_name �̸�,substr(email,0,instr(email,'@')-1) �̸��� from employee;

--3. 60������ ������� ���, ���ʽ����� ����Ͻÿ�
select emp_name ������,substr(emp_no,0,2) ���,
nvl(bonus,0) ���ʽ�  from employee 
where substr(emp_no,0,2) < 70;

--4. 010 �ڵ��� ��ȣ�� ���� �ʴ� ����� ���� �Է��Ͻÿ� �ڿ� ���� ���̽ÿ�
select count(emp_no)||'��' �ο� from employee where substr(phone,0,3) != '010';

--5. ������� �Ի����� ����Ͻÿ�.
select emp_name ������,to_char(hire_date,'yyyy"��"mm"��"') �Ի��� from employee;

--6. ������, �����ڵ�, ����(��) ��ȸ
-- ��, ������ 57,000,000 ���� ǥ�õǰ���
-- ������ ���ʽ� ����Ʈ�� ����� 1���� �޿���.
select emp_name,job_code,to_char(salary*12 + ((nvl(bonus,0) * (salary*12))) ,'L999,999,999') ���� from employee;

--7. �μ��ڵ尡 d5,d9�� ������ �߿��� 2004�⵵�� �Ի��� ������ ��� ����� �μ��ڵ� �Ի��� ��ȸ
select emp_id ���,emp_name �����,dept_code �μ��ڵ�,hire_date �Ի��� from employee
where dept_code in('D5','D9') 
and extract(year from hire_date) = extract(year from to_date('2004/01/01','yyyy/mm/dd'));

--8. ������, �Ի���, ���ñ����� �ٹ��ϼ� ��ȸ
-- ��, �ָ��� ����, �Ҽ��� �Ʒ��� ����
select emp_name ������,hire_date �Ի���,floor((sysdate-hire_date)) �ٹ��ϼ� from employee;

--9. ��� ������ ������ ���� ���� ���̿� ���� ���� ���̸� ����Ͽ���. (���̸� ���)
select
    extract(year from sysdate) - (min(to_number(substr(emp_no,0,2)))+1900) "�ִ볪��" ,
    extract(year from sysdate) - (max(to_number(substr(emp_no,0,2)))+1900) "�ּҳ���" 
from employee;

--10. ȸ�翡�� �߱��� �ؾߵǴ� �μ��� ��ǥ�Ͽ��� �Ѵ�.
-- �μ��ڵ尡 d5,d6,d9 �߱�, �׿ܴ� �߱پ������� ��µǵ��� �Ͽ���.
-- ��°��� �̸�,�μ��ڵ�,�߱����� (�μ��ڵ� ���� �������� ������.)
--  (�μ��ڵ尡 null�� ����� �߱پ�����)
select emp_name,dept_code,
    case 
        when dept_code in ('D5','D6','D9') then '�߱�'
        else '�߱پ���'
    end as "�߱�����"
from employee;

select emp_name,dept_code, 
decode(dept_code,'D5','�߱�','D6','�߱�','D9','�߱�','�߱پ���') 
�߱�����
from employee order by dept_code;

-- 11.������, �μ��ڵ�, �������, ������ȸ
-- ��, ��������� �ֹι�ȣ���� �����ؼ�
-- ������ ������ �����Ϸ� ��µǰ���
-- ���̴� �ֹι�ȣ���� �����ؼ� ���ڵ����ͷ� ��ȯ�� ����, �����
-- * �ֹι�ȣ�� �̻��� ������� ���ܽ�Ű�� ���� 200,201,214 ����

select * from employee;
select emp_name,dept_code,
    to_char(to_date(substr(emp_no,0,6),'yymmdd'),'yy"��"mm"��"dd"��"') �������,
    extract(year from sysdate) - (extract(year from to_date(substr(emp_no,0,6),'YYMMDD'))-101)  ����  
from employee 
where EMP_ID not In(200,201,214);

--12. �������� �Ի��Ϸκ��� �⵵�� ������, �� �⵵�� �Ի��ο����� ���Ͻÿ�
-- 1998��~2004 �⿡ �Ի��� �ο����� ��ȸ�Ͻÿ�. ���������� ��ü �������� ���Ͻÿ�.
--1998�� ���ϱ�
select count(*) from employee 
where 
extract(year from hire_date) = extract(year from to_date('1998','yyyy'));


select 
(select count(*) 
    from employee 
    where extract(year from hire_date) = extract(year from to_date('1998','yyyy'))
) as "1998��",
(select count(*) 
    from employee 
    where extract(year from hire_date) = extract(year from to_date('1999','yyyy'))
) as "1999��",
(select count(*) 
    from employee 
    where extract(year from hire_date) = extract(year from to_date('2000','yyyy'))
) as "2000��",
(select count(*) 
    from employee 
    where extract(year from hire_date) = extract(year from to_date('2001','yyyy'))
) as "2001��",
(select count(*) 
    from employee 
    where extract(year from hire_date) = extract(year from to_date('2002','yyyy'))
) as "2002��",
(select count(*) 
    from employee 
    where extract(year from hire_date) = extract(year from to_date('2003','yyyy'))
) as "2003��",
(select count(*) 
    from employee 
    where extract(year from hire_date) = extract(year from to_date('2004','yyyy'))
) as "2004��",
(select count(*)
    from employee 
) as "��ü������"
from dual;
