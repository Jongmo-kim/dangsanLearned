--�����ͺ��̽� ���������ֱ�
create user kcalRecorder identified by 1234;
grant resource, connect to kcalRecorder;

--�����ͺ��̽� ������ 
drop table user_;
drop table meals;
drop table meal;
drop table foods;
drop table food;

DROP TRIGGER food_AI_TRG;
DROP TRIGGER foods_AI_TRG;
DROP TRIGGER user__AI_TRG;
DROP trigger meals_ai_trg;
DROP TRIGGER MEAL_AI_TRG;

DROP SEQUENCE food_SEQ;
drop sequence meal_seq;
drop sequence meals_seq;
DROP SEQUENCE user__SEQ;
DROP SEQUENCE foods_SEQ;
-- �� ���� ����
-- ������ ������ �ʱ�ȭ

SELECT * FROM FOOD;
SELECT * FROM USER_;
SELECT * FROM MEAL;
SELECT * FROM FOODS;

insert into meal values(meal_seq.nextval,
insert into user_ values(user__seq.nextval,'id1','pw1','nick');




----���̺� ����
2-- ���̺� ������ ���踦 ����Ͽ� �� ���� �����ص� ������ �߻����� �ʰ� ���ĵǾ����ϴ�.

-- user_ Table Create SQL

create SEQUENCE food_SEQ;
create sequence meal_seq;
create sequence meals_seq;
create SEQUENCE user__SEQ;
create SEQUENCE foods_SEQ;
CREATE TABLE user_
(
    u_code      NUMBER          NOT NULL, 
    id          VARCHAR2(20)    NOT NULL, 
    pw          VARCHAR2(20)    NOT NULL, 
    nickname    VARCHAR2(20)    NOT NULL, 
    CONSTRAINT USER__PK PRIMARY KEY (u_code)
)
/

COMMENT ON TABLE user_ IS '�����'
/

COMMENT ON COLUMN user_.u_code IS '������ڵ�'
/

COMMENT ON COLUMN user_.id IS '���̵�'
/

COMMENT ON COLUMN user_.pw IS '��й�ȣ'
/

COMMENT ON COLUMN user_.nickname IS '�г���'
/

ALTER TABLE user_
    ADD CONSTRAINT UC_id UNIQUE (id)
/

ALTER TABLE user_
    ADD CONSTRAINT UC_nickname UNIQUE (nickname)
/


-- user_ Table Create SQL
CREATE TABLE food
(
    f_code    NUMBER          NOT NULL, 
    f_name    VARCHAR2(20)    NOT NULL, 
    kcal      NUMBER          NOT NULL, 
    CONSTRAINT FOOD_PK PRIMARY KEY (f_code)
)
/

COMMENT ON TABLE food IS '����'
/

COMMENT ON COLUMN food.f_code IS '�����ڵ�'
/

COMMENT ON COLUMN food.f_name IS '�����̸�'
/

COMMENT ON COLUMN food.kcal IS 'Į�θ�'
/

ALTER TABLE food
    ADD CONSTRAINT UC_f_name UNIQUE (f_name)
/


-- user_ Table Create SQL
CREATE TABLE Meal
(
    m_code      NUMBER    NOT NULL, 
    eat_date    DATE      DEFAULT sysdate NOT NULL, 
    u_code      NUMBER    NOT NULL, 
    CONSTRAINT MEAL_PK PRIMARY KEY (m_code)
)
/

COMMENT ON TABLE Meal IS '����'
/

COMMENT ON COLUMN Meal.m_code IS '�����ڵ�'
/

COMMENT ON COLUMN Meal.eat_date IS '������'
/

COMMENT ON COLUMN Meal.u_code IS '������ڵ�'
/

ALTER TABLE Meal
    ADD CONSTRAINT FK_Meal_u_code_user__u_code FOREIGN KEY (u_code)
        REFERENCES user_ (u_code)
/


-- user_ Table Create SQL
CREATE TABLE foods
(
    m_code    NUMBER    NOT NULL, 
    f_code    NUMBER    NOT NULL, 
    amount    NUMBER    DEFAULT 1 NOT NULL
)
/

COMMENT ON TABLE foods IS '���ĵ�'
/

COMMENT ON COLUMN foods.m_code IS '�����ڵ�'
/

COMMENT ON COLUMN foods.f_code IS '�����ڵ�'
/

COMMENT ON COLUMN foods.amount IS '���ľ�'
/

ALTER TABLE foods
    ADD CONSTRAINT FK_foods_f_code_food_f_code FOREIGN KEY (f_code)
        REFERENCES food (f_code)
/

ALTER TABLE foods
    ADD CONSTRAINT FK_foods_m_code_Meal_m_code FOREIGN KEY (m_code)
        REFERENCES Meal (m_code)
/


