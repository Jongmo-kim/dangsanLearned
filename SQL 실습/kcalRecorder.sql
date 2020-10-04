--데이터베이스 만들고권한주기
create user kcalRecorder identified by 1234;
grant resource, connect to kcalRecorder;

--데이터베이스 날리기 
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
-- 값 삽입 예제
-- 삽입전 시퀀스 초기화

SELECT * FROM FOOD;
SELECT * FROM USER_;

INSERT INTO FOOD(F_NAME,KCAL) VALUES('음식1',100);
INSERT INTO FOODS(F_CODE) VALUES (FOOD_SEQ.CURRVAL);
INSERT INTO MEAL(FS_CODE,AMOUNT,EAT_DATE) VALUES (FOODS_SEQ.CURRVAL,1,SYSDATE);
INSERT INTO MEALS(M_CODE) VALUES (MEAL_SEQ.CURRVAL);
INSERT INTO USER_(ID,PW,MS_CODE) VALUES ('ID3','1234',MEALS_SEQ.CURRVAL);






----테이블 생성
CREATE TABLE food
(
    f_code    NUMBER          NOT NULL, 
    f_name    VARCHAR2(20)    NOT NULL unique, 
    kcal      NUMBER          NOT NULL, 
    CONSTRAINT FOOD_PK PRIMARY KEY (f_code)
)
/

CREATE SEQUENCE food_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER food_AI_TRG
BEFORE INSERT ON food 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT food_SEQ.NEXTVAL
    INTO :NEW.f_code
    FROM DUAL;
END;
/

--DROP TRIGGER food_AI_TRG;
/

--DROP SEQUENCE food_SEQ;
/

COMMENT ON TABLE food IS '음식'
/

COMMENT ON COLUMN food.f_code IS '음식코드'
/

COMMENT ON COLUMN food.f_name IS '음식이름'
/

COMMENT ON COLUMN food.kcal IS '칼로리'
/


-- food Table Create SQL
CREATE TABLE foods
(
    fs_code    NUMBER    NOT NULL, 
    f_code     NUMBER    NOT NULL, 
    CONSTRAINT FOODS_PK PRIMARY KEY (fs_code)
)
/

CREATE SEQUENCE foods_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER foods_AI_TRG
BEFORE INSERT ON foods 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT foods_SEQ.NEXTVAL
    INTO :NEW.fs_code
    FROM DUAL;
END;
/

--DROP TRIGGER foods_AI_TRG;
/

--DROP SEQUENCE foods_SEQ;
/

COMMENT ON TABLE foods IS '음식들'
/

COMMENT ON COLUMN foods.fs_code IS '음식들코드'
/

COMMENT ON COLUMN foods.f_code IS '음식코드'
/

ALTER TABLE foods
    ADD CONSTRAINT FK_foods_f_code_food_f_code FOREIGN KEY (f_code)
        REFERENCES food (f_code)
/


-- food Table Create SQL
CREATE TABLE Meal
(
    m_code      NUMBER    NOT NULL, 
    fs_code     NUMBER    NOT NULL UNIQUE, 
    amount      NUMBER    NOT NULL, 
    eat_date    DATE      NOT NULL, 
    CONSTRAINT MEAL_PK PRIMARY KEY (m_code)
)
/

COMMENT ON TABLE Meal IS '끼니'
/

COMMENT ON COLUMN Meal.m_code IS '끼니코드'
/

COMMENT ON COLUMN Meal.fs_code IS '음식들코드'
/

COMMENT ON COLUMN Meal.amount IS '먹은양'
/

COMMENT ON COLUMN Meal.eat_date IS '먹은날'
/

ALTER TABLE Meal
    ADD CONSTRAINT FK_Meal_fs_code_foods_fs_code FOREIGN KEY (fs_code)
        REFERENCES foods (fs_code)
/

CREATE SEQUENCE Meal_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER Meal_AI_TRG
BEFORE INSERT ON Meal 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT Meal_SEQ.NEXTVAL
    INTO :NEW.m_code
    FROM DUAL;
END;
/

-- food Table Create SQL
CREATE TABLE Meals
(
    ms_code    NUMBER    NOT NULL, 
    m_code     NUMBER    NOT NULL UNIQUE, 
    CONSTRAINT MEALS_PK PRIMARY KEY (ms_code)
)
/

CREATE SEQUENCE Meals_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER Meals_AI_TRG
BEFORE INSERT ON Meals 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT Meals_SEQ.NEXTVAL
    INTO :NEW.ms_code
    FROM DUAL;
END;
/

--DROP TRIGGER Meals_AI_TRG;
/

--DROP SEQUENCE Meals_SEQ;
/

COMMENT ON TABLE Meals IS '끼니들'
/

COMMENT ON COLUMN Meals.ms_code IS '끼니들코드'
/

COMMENT ON COLUMN Meals.m_code IS '끼니코드'
/

ALTER TABLE Meals
    ADD CONSTRAINT FK_Meals_m_code_Meal_m_code FOREIGN KEY (m_code)
        REFERENCES Meal (m_code)
/


-- food Table Create SQL
CREATE TABLE user_
(
    u_code     NUMBER          NOT NULL , 
    id         VARCHAR2(20)    NOT NULL unique, 
    pw         VARCHAR2(20)    NOT NULL, 
    ms_code    NUMBER          NOT NULL UNIQUE, 
    CONSTRAINT USER__PK PRIMARY KEY (u_code)
)
/

CREATE SEQUENCE user__SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER user__AI_TRG
BEFORE INSERT ON user_ 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT user__SEQ.NEXTVAL
    INTO :NEW.u_code
    FROM DUAL;
END;
/

--DROP TRIGGER user__AI_TRG;
/

--DROP SEQUENCE user__SEQ;
/

COMMENT ON TABLE user_ IS '사용자'
/

COMMENT ON COLUMN user_.u_code IS '사용자코드'
/

COMMENT ON COLUMN user_.id IS '아이디'
/

COMMENT ON COLUMN user_.pw IS '비밀번호'
/

COMMENT ON COLUMN user_.ms_code IS '끼니들코드'
/

ALTER TABLE user_
    ADD CONSTRAINT FK_user__ms_code_Meals_ms_code FOREIGN KEY (ms_code)
        REFERENCES Meals (ms_code)
/



