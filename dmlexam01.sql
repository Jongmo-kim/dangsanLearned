create table runningman(
no number primary key,
id varchar2(20) unique,
pass varchar2(20) not null,
name varchar2(20) not null,
nickname varchar2(20) unique,
gender char(1),
tel varchar2(20) default '010-0000-0000',
address varchar2 (90)
);

insert into runningman values(1,'muhan','1234','���缮','��������','M','010-4958-2333','�б���');
insert into runningman values(2,'bignose','4444','������','������','M',default,'����');
insert into runningman values(3,'tiger','6658','������','�Ȳ�','M','010-6674-8986','�Ⱦ�');
insert into runningman values(4,'haha','5356','����','�źм�Ź','M','010-8997-1122','��������');
insert into runningman values(5,'ace','5555','����ȿ','õ����','F',default,'�����');
insert into runningman values(6,'grrafe','6658','�̱���','�߱�ģ��','M','010-2378-9991','������');
insert into runningman values(7,'ssapssap','5357','�缼��','��������','M','010-1215-7777','����õ');
insert into runningman values(8,'doli','5555','���ҹ�','���θ�','F',default,'�ϻ�');
select * from runningman;

update runningman set pass = '9999'  where nickname='�߱�ģ��';
update runningman set tel = '����' where tel = '010-0000-0000';

delete running 