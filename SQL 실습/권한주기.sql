--user ����
--create user �����̸� identified ��й�ȣ
create user kh identified by kh;
--���� �ο����
--GRANT ROLE �̸� to �����̸�
grant connect, resource to kh;
--���� ȸ�� ���
--REVOKE ȸ���� ROLE FROM �����̸�
revoke connect from test01;
--VIEW �����ֱ�
grant create view to kh;
--synonym ���Ǿ� �����ֱ�
grant create synonym to kh;