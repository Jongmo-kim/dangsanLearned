select * from employee;

-- EMPLOYEE ���̺��� '��' �� ���� ���� ������ �̸��� �޿� ��ȸ
SELECT EMP_NAME, SALARY FROM EMPLOYEE WHERE EMP_NAME LIKE '��__';
SELECT EMP_NAME, SALARY FROM EMPLOYEE WHERE EMP_NAME LIKE '��%';
--�̸��� '��'�� ��� ��ȸ
SELECT CMP_NAME, SALARY FROM EMPLOYEE WHERE EMP_NAME='��';
SELECT * FROM EMPLOYEE;

--EMAIL�ּ� �� S�� ���ԵǾ��ִ� ������ �̸��� EMIL�ּ� ���

SELECT EMP_NAME,EMAIL FROM EMPLOYEE WHERE EMAIL LIKE '%s%'; 

SELECT EMP_NAME, EMAIL FROM EMPLOYEE WHERE EMAIL NOT LIKE '%s%';


SELECT EMAIL FROM EMPLOYEE;

--EMAIL�� '_'���� ���ڰ� 3������ ������ �̸����ּ� ���


SELECT EMAIL FROM EMPLOYEE WHERE EMAIL LIKE '___#_%'ESCAPE '#';

SELECT EMP_NAME FROM EMPLOYEE WHERE EMP_NAME NOT LIKE '��%';

SELECT * FROM EMPLOYEE;

SELECT EMP_NAME, BONUS FROM EMPLOYEE WHERE BONUS  IS NULL;

SELECT EMP_NAME, BONUS FROM EMPLOYEE WHERE BONUS  IS NOT NULL;

-- �μ��ڵ尡 D6�̰ų� D8�� ������ �̸�, �μ��ڵ�, �޿���ȸ

SELECT EMP_NAME, DEPT_CODE, SALARY FROM EMPLOYEE WHERE DEPT_CODE= 'D6' OR DEPT_CODE= 'D8';

SELECT EMP_NAME, DEPT_CODE, SALARY FROM EMPLOYEE WHERE DEPT_CODE IN('D6','D8');

SELECT EMP_NAME, DEPT_CODE, SALARY FROM EMPLOYEE WHERE DEPT_CODE NOT IN('D6,D8,D1');

-- �μ��� �� �����ڵ尡  J7 �Ǵ� J2�̰�, �޿��� 2000000�� �ʰ��� ����� �̸�, �޿�, �����ڵ� ���
SELECT EMP_NAME, JOB_CODE, SALARY FROM EMPLOYEE WHERE JOB_CODE IN('J2','J7') AND SALARY > 2000000;

SELECT EMP_NAME, JOB_CODE, SALARY FROM EMPLOYEE WHERE (JOB_CODE =('J7') OR JOB_CODE =('J2')) AND SALARY >2000000; 
-- J2 AND SALARY�� ���� ���ǰ˻��ϱ⶧���� ��ȣ �����ش�


--����
-- ORDER BY : SELECT �� �÷��� ���� ������ �� ����ϴ� ����
-- SELECT�� ���� �������� �ۼ�, ���൵ ���帶������ ����
SELECT EMP_NAME, SALARY FROM EMPLOYEE ORDER BY SALARY; --�������� ����

SELECT EMP_NAME, SALARY FROM EMPLOYEE ORDER BY SALARY ASC; --�������� ����
SELECT EMP_NAME, SALARY FROM EMPLOYEE ORDER BY SALARY DESC;--�������� ����

--������ ����
 --       NUMBER      CHARACTER          DATE         NULL
 --ASC    ��->ū        ������            ��->��        �Ʒ�
 --DESK   ū->��        ��������          ��->��         ��
 --ORDER BY �� SELECT�� ���� ������
-- ASC DESC ������ �ڵ����� ASC����

--JOB_CODE�� J7�̰ų� J2�� �������� �̸�, �޿�, JOB_CODE ��� �̸����� ��������
SELECT *FROM EMPLOYEE;

SELECT EMP_NAME, SALARY, JOB_CODE FROM EMPLOYEE WHERE JOB_CODE IN ('J7','J2')ORDER BY 1 DESC;
--���� 1�� �÷� �ڸ� (1=NAME ������������)(2=SALARY ������������)(3=JOB_CODE ������������)
SELECT SALARY, EMP_NAME, JOB_CODE FROM EMPLOYEE WHERE JOB_CODE IN ('J7','J2')ORDER BY 2 DESC;
-- ����1. 
-- �Ի����� 5�� �̻�, 10�� ������ ������ �̸�,�ֹι�ȣ,�޿�,�Ի����� �˻��Ͽ���
SELECT EMP_NAME, HIRE_DATE FROM EMPLOYEE;
SELECT EMP_NAME, FLOOR(SYSDATE - HIRE_DATE) �ٹ��� FROM EMPLOYEE;
SELECT EMP_NAME, EMP_NO, SALARY, HIRE_DATE FROM EMPLOYEE WHERE (SYSDATE-HIRE_DATE)/365 BETWEEN 5 AND 10;
-- ����2.
-- �������� �ƴ� ������ �̸�,�μ��ڵ带 �˻��Ͽ��� (��� ���� : ENT_YN)
SELECT EMP_NAME, DEPT_CODE FROM EMPLOYEE WHERE ENT_YN='Y';
-- ����3.
-- �ټӳ���� 10�� �̻��� �������� �˻��Ͽ�
-- ��� ����� �̸�,�޿�,�ټӳ���� �ټӳ���� ������������ �����Ͽ� ����Ͽ���
SELECT EMP_NAME, SALARY*0.5, HIRE_DATE FROM EMPLOYEE WHERE (SYSDATE-HIRE_DATE)/365 >=10 ORDER BY HIRE_DATE ASC;
-- ��, �޿��� 50% �λ�� �޿��� ��µǵ��� �Ͽ���.

-- ����4.
-- �Ի����� 99/01/01 ~ 10/01/01 �� ��� �߿��� �޿��� 2000000 �� ������ �����
-- �̸�,�ֹι�ȣ,�̸���,����ȣ,�޿��� �˻� �Ͻÿ�
SELECT EMP_NAME, EMP_NO, EMAIL, PHONE, SALARY FROM EMPLOYEE WHERE HIRE_DATE BETWEEN '99/01/01' AND '10/01/01' AND SALARY<2000001;
-- ����5.
-- �޿��� 2000000�� ~ 3000000�� �� ������ �߿��� 4�� �����ڸ� �˻��Ͽ� 
-- �̸�,�ֹι�ȣ,�޿�,�μ��ڵ带 �ֹι�ȣ ������(��������) ����Ͽ���
SELECT EMP_NAME, EMP_NO, SALARY, DEPT_CODE FROM EMPLOYEE WHERE SALARY BETWEEN 2000000 AND 3000000 AND EMP_NO LIKE '___4___2%'ORDER BY EMP_NO DESC; 

-- ����6.
-- ���� ��� �� ���ʽ��� ���� ����� ���ñ��� �ٹ����� �����Ͽ� 
-- 1000�� ����(�Ҽ��� ����) 
-- �޿��� 10% ���ʽ��� ����Ͽ� �̸�,Ư�� ���ʽ� (��� �ݾ�) ����� ����Ͽ���.
-- ��, �̸� ������ ���� ���� �����Ͽ� ����Ͽ���.
SELECT EMP_NAME, FLOOR((SYSDATE-HIRE_DATE)/1000)*(SALARY*0.1) AS "Ư�����ʽ�" FROM EMPLOYEE WHERE EMP_NO LIKE '_______1%' AND BONUS  IS NULL  ORDER BY EMP_NAME ASC; 







-- ����1. 
-- �Ի����� 5�� �̻�, 10�� ������ ������ �̸�,�ֹι�ȣ,�޿�,�Ի����� �˻��Ͽ���
SELECT EMP_NAME, EMP_NO,SALARY,HIRE_DATE
-- ����2.
-- �������� �ƴ� ������ �̸�,�μ��ڵ带 �˻��Ͽ��� (��� ���� : ENT_YN)
-- ����3.
-- �ټӳ���� 10�� �̻��� �������� �˻��Ͽ�
-- ��� ����� �̸�,�޿�,�ټӳ���� �ټӳ���� ������������ �����Ͽ� ����Ͽ���
-- ��, �޿��� 50% �λ�� �޿��� ��µǵ��� �Ͽ���.
-- ����4.
-- �Ի����� 99/01/01 ~ 10/01/01 �� ��� �߿��� �޿��� 2000000 �� ������ �����
-- �̸�,�ֹι�ȣ,�̸���,����ȣ,�޿��� �˻� �Ͻÿ�
-- ����5.
-- �޿��� 2000000�� ~ 3000000�� �� ������ �߿��� 4�� �����ڸ� �˻��Ͽ� 
-- �̸�,�ֹι�ȣ,�޿�,�μ��ڵ带 �ֹι�ȣ ������(��������) ����Ͽ���
-- ����6.
-- ���� ��� �� ���ʽ��� ���� ����� ���ñ��� �ٹ����� �����Ͽ� 
-- 1000�� ����(�Ҽ��� ����) 
-- �޿��� 10% ���ʽ��� ����Ͽ� �̸�,Ư�� ���ʽ� (��� �ݾ�) ����� ����Ͽ���.
-- ��, �̸� ������ ���� ���� �����Ͽ� ����Ͽ���.












