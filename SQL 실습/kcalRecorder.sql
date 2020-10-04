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
-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

-- user_ Table Create SQL
CREATE TABLE user_
(
    u_code      NUMBER          NOT NULL, 
    id          VARCHAR2(20)    NOT NULL, 
    pw          VARCHAR2(20)    NOT NULL, 
    nickname    VARCHAR2(20)    NOT NULL, 
    CONSTRAINT USER__PK PRIMARY KEY (u_code)
)
/

COMMENT ON TABLE user_ IS '사용자'
/

COMMENT ON COLUMN user_.u_code IS '사용자코드'
/

COMMENT ON COLUMN user_.id IS '아이디'
/

COMMENT ON COLUMN user_.pw IS '비밀번호'
/

COMMENT ON COLUMN user_.nickname IS '닉네임'
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

COMMENT ON TABLE food IS '음식'
/

COMMENT ON COLUMN food.f_code IS '음식코드'
/

COMMENT ON COLUMN food.f_name IS '음식이름'
/

COMMENT ON COLUMN food.kcal IS '칼로리'
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

COMMENT ON TABLE Meal IS '끼니'
/

COMMENT ON COLUMN Meal.m_code IS '끼니코드'
/

COMMENT ON COLUMN Meal.eat_date IS '먹은날'
/

COMMENT ON COLUMN Meal.u_code IS '사용자코드'
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

COMMENT ON TABLE foods IS '음식들'
/

COMMENT ON COLUMN foods.m_code IS '끼니코드'
/

COMMENT ON COLUMN foods.f_code IS '음식코드'
/

COMMENT ON COLUMN foods.amount IS '음식양'
/

ALTER TABLE foods
    ADD CONSTRAINT FK_foods_f_code_food_f_code FOREIGN KEY (f_code)
        REFERENCES food (f_code)
/

ALTER TABLE foods
    ADD CONSTRAINT FK_foods_m_code_Meal_m_code FOREIGN KEY (m_code)
        REFERENCES Meal (m_code)
/


