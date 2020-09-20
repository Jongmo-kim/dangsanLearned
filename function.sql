--length
select emp_name,length(emp_name) "�̸�����" , email,length(email) "�̸��ϱ���" from employee;

--lengthb
select emp_name ,lengthb(emp_name),email,lengthb(email) from employee;

--instr
select sysdate from dual;
select 'hello world' from dual;
select instr('hello world hi high','h',1,1) from dual; --���ۺ��� 1���� H�� ��ġ ��ȯ
select instr('hello world hi high','h',1,2) from dual;--���ۺ��� 2���� H��ġ��ȯ
select instr('hello world hi high','h',2,1) from dual; --2������1���� H��ġ��ȯ
select instr('hello world hi high','h',-1,1) from dual; -- -�� �ں��Ͱ˻�
select instr('hello world hi high','h',-1,2) from dual;
select instr('hello world hi high','h',-1,3) from dual;

select instr(email,'@',1,1) from employee;

-- lpad / rpad
select email,length(email) from employee;
select email,length(email), lpad(email,20,'#') from employee;
select email, length(email), rpad(email,20,'#') from employee;
select email,length(email), lpad(email,10,'#') from employee; --���ڿ����� �̸��̸� ©��

--ltrim/rtrim/trim
select '--kh' from dual;
select ltrim('--kh','-') from dual;
select ltrim('A--kh','-') from dual;
select trim('--kh','-') from dual;
select ltrim('000kh','0') from dual;
select ltrim('123123kh','123123') from dual;
select ltrim('abcabaccaccacabkh','abc') from dual; --a or b or c �ٻ���
select rtrim('kh029424292302549023923','0123789456070889') from dual; --���ڻ��� 

select trim('z' from 'zzzkhzzz') from dual; --�������� �ѱ��ڹۿ� ����
select trim(leading 'z' from 'zzzkhzzz') from dual;--���ʿ����� ����
select trim(trailing 'z' from 'zzzkhzzz')from dual;-- ���ʸ� �İ�
select trim(both 'z' from 'zzzkhzzz')from dual; --default both 

select * from department;
select trim('��' from DEPT_TITLE) from department;

select rtrim(ltrim('63487643867438657348574358787682768hello1290382509812051834806','0123456789'),'0123456789') from dual;

--substr
select substr('showmethemoney',1,3) from dual;
select substr('showmethemoney',5,4) from dual;
select substr('showmethemoney',7) from dual; --������ ��ȣ���� ������
select substr('showmethemoney',-8,3)from dual; --�ڿ������� 8��° ���� 3��¥
--employee ���̺��� ����̸��� �������
select substr(emp_name,0,1) from employee;

--employee ���̺��� ���ڸ� �����ȣ,����� �ֹι�ȣ ���
--�� �ֹι�ȣ�� �� 6�ڸ��� ******�� ���
select emp_id,emp_name,rpad(substr(emp_no,0,8),14,'*') from employee where substr(emp_no,8,1) = '1';

--lower/upper/inicap
select lower('Welcome To KH') from dual;
select upper('Welcome to KH') from dual;
select initcap('Welcome to KH') from dual; --�ܾ�� ù���ڸ� �빮��

--concat
select concat('�����ٶ�','abcd') from dual;
select '�����ٶ�'||'abcd' from dual;

--replace 
select replace('�ȳ��ϼ���HIHELLO','HI','BYE') from dual;

--employee���̺��� ��� ������ �̸�, �ֹι�ȣ, email�� ���
--email�ּ� ��½� kh.or.kr ->iei.or.kr �����Ͽ� ���
--sub_di@kh.or.kr -> sud_di@iei.or.kr

select emp_name,emp_no,replace(email,'kh','iei') from employee;

--����ó���Լ�
--abs
select abs(10) from dual;
select abs(-10) from dual;
--mod
select mod(10,3) from dual;
select mod(10,2) from dual;
select mod(10,4) from dual;

--round ���� �ڸ� �ݿø�
select round(126.456,3) from dual;
select round(126.456,2) from dual;
select round(126.456,1) from dual;
select round(126.456,0) from dual;
select round(126.456,-1) from dual;
select round(126.456,-2) from dual;

--floor �Ҽ�������
select floor(126.456) from dual;

--trunc 
select trunc(1235) from dual;

-- ceil
select ceil(123.46) from dual;

-- ����ó���Լ�
--sysdate
select sysdate from dual;
--month_between
select emp_name,hire_date,months_between(sysdate,hire_date) from employee;
-- add_month
select emp_name, hire_date, add_months(hire_date,3) from employee;
--next _day
 -- 1=�Ͽ���,2=������ ...
 select sysdate, next_day(sysdate,7) from dual;
 --last_day
 select last_day(sysdate) from dual;
 select emp_name,last_day(hire_date) from employee;
 --extract
 select extract(year from sysdate) from dual;
 select extract(day from sysdate) from dual;
 select extract(month from sysdate) from dual;
 select emp_name, 
 extract(year from hire_date) ||'��'||
 extract(month from hire_date) || '��' || 
 extract(day from hire_date)|| '��' �Ի��� from employee;
 
 --����ȯ �Լ�
 --to_char ��¥ - > ����
 select to_char(sysdate,'yyyy-mm-dd') from dual;
 select to_char(sysdate,'yyyy/mm/dd') from dual;
 select to_char(sysdate,'yyyy/mm/dd/day') from dual;
 select to_char(sysdate,'yy/mm/dd') from dual;
 select to_char(sysdate,'yyyy/mm/dd/pmhh12"��"mi"��"ss"��"') from dual;
 select to_char(sysdate,'yyyy/mm/dd/hh24"��"mi"��"ss"��"') from dual;
 select to_char(sysdate,'fmyyyy/mm/dd/hh24"��"mi"��"ss"��"') from dual;
 
 --to_char ����- > ����
 select 5000000, to_char(50000000,'999,999,999') from dual;
 select 5000000, to_char(50000000,'000,000,000') from dual;
 select 5000000, to_char(50000000,'999,999,999.99') from dual;
 select 5000000, to_char(50000000,'$999,999,999') from dual;
 select 5000000, to_char(50000000,'L999,999,999') from dual;-- local ��ȭ �ܿ� = L
 
 --to_date
 select to_date('20200917','yyyymmdd')from dual;
 select to_date(20200917,'yyyymmdd') from dual;
 select to_char(to_date('20200917','yyyymmdd'),'yyyy/mm/dd hh24:mi:ss') from dual;
 select to_char(sysdate,'yyyy/mm/dd hh24:mi:ss') from dual; 

 
--employee���̺��� 2000�⵵���Ŀ� �Ի��� ����� �̸�, �Ի��� ��ȸ
select emp_name,hire_date from employee;
select emp_name,hire_date from employee where hire_date > TO_DATE(20000101,'yyyymmdd');

--to_number
select to_number('1234') from dual;
select to_number('1,000,000','9,999,999') from dual;

select to_number('123a') from dual;--���ڸ� ���ڷ� �ٲܼ�����

select 100+100 from dual;
select '100'+'100' from dual; -- �ڵ� ����ȯ �ڹٶ� �ٸ�
select '100a'+'100' from dual; -- ����ȯ ������ �Ȱ��� ���� ���ڿ�-> ���ڷ�

-- ������ �̸�, ����(���ʽ� ���Ե�)
select emp_name, (salary * 12 + bonus * salary) from employee;

--nvl nulló���Լ� 
select emp_name,salary*12 ����,bonus ���ʽ�, (salary * 12 + nvl(bonus,0) * salary) "���ʽ� ���Ե� ����"from employee;

--decode(ǥ����,����1,���1,����2,���2 ..)
select emp_name,emp_no,decode(substr(emp_no,8,1),'1','����','2','����','3','�ܱ��γ���','4','�ܱ��ο���') ����
from employee;

--  case
select emp_name,emp_no,case when substr(emp_no,8,1)In(1,3) then '����'
                            when substr(emp_no,8,1)In(2,4) then '����' 
                        end ����
from employee;

-- sum �����հ� avg ��ո��� count �Ѱ���  max �ִ밪 min �ּҰ�
select salary from employee;
SELECT sum(salary) from employee;
select salary from employee where substr(emp_no,8,1)='1';
select sum(salary) from employee where substr(emp_no,8,1)='1';
-- avg
select to_char(floor(avg(salary)),'L999,999,999')"���� ���" from employee;
-- count ����� �ο� ��
select count(salary) from employee;
select to_char(floor(sum(salary) /count(salary)),'L999,999,999') "���� ���"from employee ;

--max ���� ���� ū�� min ������ 
select to_char(max(salary),'L999,999,999') from employee;
select to_char(min(salary),'L999,999,999') from employee;

select max(hire_date),min(hire_date) from employee;
