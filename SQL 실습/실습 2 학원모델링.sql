--DB설계에 대한 의뢰가 하나 들어왔다.
--학원시스템에 관련하여 개발하고자 한다.
--해당 학원에는 많은 과목이 존재하고 과목코드, 과목명이 있다.
--과목에 따라 여러 강좌를 개강하기 위해서는 과목과 강사 정보가 필요하며
--강좌마다 강좌번호가 있으며, 하나의 강좌당 한명의 강사가 배치된다.
--강좌 정보는 요일,교시,강의시간(총 강의시간)을 기록할 수 있어야 한다.
--해당 학원은 강사를 관리하며, 강사는 강사별 ID,이름,전화번호, 주소를 관리 한다.
--또한 학생들도 관리하며 학생은 학생별 ID,이름,전화번호,주소를 관리 한다.
--학생들은 강좌를 듣기 위해 수강신청을 할 수 있다.
--수강신청시 필요한 정보는 강좌번호와 학생 ID가 필요하다.

--과목
-- 과목 코드
-- 과목 명


--강좌
-- 강좌 번호
-- 강사 ID
-- 과목 ID
-- 요일
-- 교시
-- 강의시간 (총강의시간)

-- 강사
-- 강사 id
-- 강사 이름
-- 전화번호
-- 주소

--학생
-- id
-- 이름
-- 전화번호
-- 주소

-- 수강신청
-- 강좌번호
--학생 ID

-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

-- 과목 Table Create SQL
--system 으로 실행
create user datamodelexam2 identified by 1234;
grant resource, connect to datamodelexam2;

----------------------------------
drop table 강사;
drop table 과목;
drop table 수강신청;
drop table 학생;
drop TRIGGER 과목_AI_TRG;
drop sequence 강사_seq;
drop sequence 강좌_seq;
drop sequence 과목_seq;
drop sequence 학생_seq;

-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

drop table applylecture;
drop table lecture;
drop table student;
drop table subject;
drop table teacher;
drop table 과목;
drop index lecture_pk;
drop index student_pk;
drop index subject_pk;
drop index teacher_pk;
drop index 과목_pk;
DROP TRIGGER 과목_AI_TRG;
drop sequence lecture_seq;
drop sequence student_seq;
drop sequence subject_seq;
drop sequence teacher_seq;

DROP SEQUENCE subject_SEQ;
DROP TRIGGER lecture_AI_TRG;

DROP SEQUENCE lecture_SEQ;

DROP TRIGGER student_AI_TRG;

DROP SEQUENCE student_SEQ;


-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

-- subject Table Create SQL
CREATE TABLE subject
(
    s_code    NUMBER          NOT NULL, 
    s_name    VARCHAR2(20)    NULL, 
    CONSTRAINT SUBJECT_PK PRIMARY KEY (s_code)
)
/

CREATE SEQUENCE subject_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER subject_AI_TRG
BEFORE INSERT ON subject 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT subject_SEQ.NEXTVAL
    INTO :NEW.s_code
    FROM DUAL;
END;
/

--DROP TRIGGER subject_AI_TRG;
/

--DROP SEQUENCE subject_SEQ;
/

COMMENT ON TABLE subject IS 'subject'
/

COMMENT ON COLUMN subject.s_code IS '과목코드'
/

COMMENT ON COLUMN subject.s_name IS '과목명'
/


-- subject Table Create SQL
CREATE TABLE teacher
(
    t_code     NUMBER           NOT NULL, 
    t_name     VARCHAR2(20)     NULL, 
    t_phone    VARCHAR2(20)     NULL, 
    t_addr     VARCHAR2(100)    NULL, 
    CONSTRAINT TEACHER_PK PRIMARY KEY (t_code)
)
/

CREATE SEQUENCE teacher_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER teacher_AI_TRG
BEFORE INSERT ON teacher 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT teacher_SEQ.NEXTVAL
    INTO :NEW.t_code
    FROM DUAL;
END;
/

--DROP TRIGGER teacher_AI_TRG;
/

--DROP SEQUENCE teacher_SEQ;
/

COMMENT ON TABLE teacher IS 'teacher'
/

COMMENT ON COLUMN teacher.t_code IS '강사ID'
/

COMMENT ON COLUMN teacher.t_name IS '강사이름'
/

COMMENT ON COLUMN teacher.t_phone IS '전화번호'
/

COMMENT ON COLUMN teacher.t_addr IS '주소'
/


-- subject Table Create SQL
CREATE TABLE lecture
(
    l_code       NUMBER     NOT NULL, 
    t_code       NUMBER     NULL, 
    s_code       NUMBER     NULL, 
    date1        DATE       NULL, 
    period       char(7)    NULL, 
    lect_time    NUMBER     NULL, 
    CONSTRAINT LECTURE_PK PRIMARY KEY (l_code)
)
/

CREATE SEQUENCE lecture_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER lecture_AI_TRG
BEFORE INSERT ON lecture 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT lecture_SEQ.NEXTVAL
    INTO :NEW.l_code
    FROM DUAL;
END;
/

--DROP TRIGGER lecture_AI_TRG;
/

--DROP SEQUENCE lecture_SEQ;
/

COMMENT ON TABLE lecture IS 'lecture'
/

COMMENT ON COLUMN lecture.l_code IS '강좌번호'
/

COMMENT ON COLUMN lecture.t_code IS '강사ID'
/

COMMENT ON COLUMN lecture.s_code IS '과목ID'
/

COMMENT ON COLUMN lecture.date1 IS '요일'
/

COMMENT ON COLUMN lecture.period IS '교시'
/

COMMENT ON COLUMN lecture.lect_time IS '강의시간'
/

ALTER TABLE lecture
    ADD CONSTRAINT FK_lecture_s_code_subject_s_co FOREIGN KEY (s_code)
        REFERENCES subject (s_code)
/

ALTER TABLE lecture
    ADD CONSTRAINT FK_lecture_t_code_teacher_t_co FOREIGN KEY (t_code)
        REFERENCES teacher (t_code)
/


-- subject Table Create SQL
CREATE TABLE student
(
    st_code     NUMBER           NOT NULL, 
    st_name     VARCHAR2(20)     NULL, 
    st_phone    VARCHAR2(20)     NULL, 
    st_addr     VARCHAR2(100)    NULL, 
    CONSTRAINT STUDENT_PK PRIMARY KEY (st_code)
)
/

CREATE SEQUENCE student_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER student_AI_TRG
BEFORE INSERT ON student 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT student_SEQ.NEXTVAL
    INTO :NEW.st_code
    FROM DUAL;
END;
/

--DROP TRIGGER student_AI_TRG;
/

--DROP SEQUENCE student_SEQ;
/

COMMENT ON TABLE student IS 'student'
/

COMMENT ON COLUMN student.st_code IS '학생ID'
/

COMMENT ON COLUMN student.st_name IS '학생이름'
/

COMMENT ON COLUMN student.st_phone IS '전화번호'
/

COMMENT ON COLUMN student.st_addr IS '주소'
/


-- subject Table Create SQL
CREATE TABLE applyLecture
(
    l_code     NUMBER    NULL, 
    st_code    NUMBER    NULL   
)
/

COMMENT ON TABLE applyLecture IS 'applyLecture'
/

COMMENT ON COLUMN applyLecture.l_code IS '강좌번호'
/

COMMENT ON COLUMN applyLecture.st_code IS '학생ID'
/

ALTER TABLE applyLecture
    ADD CONSTRAINT FK_applyLecture_st_code_studen FOREIGN KEY (st_code)
        REFERENCES student (st_code)
/

ALTER TABLE applyLecture
    ADD CONSTRAINT FK_applyLecture_l_code_lecture FOREIGN KEY (l_code)
        REFERENCES lecture (l_code)
/



