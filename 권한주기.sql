--user ����
--create user �����̸� identified ��й�ȣ
create user test01 identified by 1234;
--���� �ο����
--GRANT ROLE �̸� to �����̸�
grant connect, resource to test01;
--���� ȸ�� ���
--REVOKE ȸ���� ROLE FROM �����̸�
revoke connect from test01;