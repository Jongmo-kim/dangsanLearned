--�����ͺ��̽� ���������ֱ�
create user kcalRecorder identified by 1234;
grant resource, connect to kcalRecorder;




SELECT * FROM FOOD;
SELECT * FROM USER_;
SELECT * FROM MEAL;
select * from foods;

--user_code�� 1�� ������ ��� ���ĸ�� ���
select fs.m_code,f_name,amount
from foods fs
inner join food f 
    on fs.f_code = f.f_code
inner join meal m 
    on fs.m_code = m.m_code
where u_code = 1
order by m_code;
    
--��� meal���
select fs.m_code,f_name,amount
from foods fs
inner join food f 
    on fs.f_code = f.f_code
inner join meal m 
    on fs.m_code = m.m_code
order by m_code;


insert into meal values(meal_seq.nextval,
insert into user_ values(user__seq.nextval,'id1','pw1','nick');



