--DB���迡 ���� �Ƿڰ� �ϳ� ���Դ�.
--�п��ý��ۿ� �����Ͽ� �����ϰ��� �Ѵ�.
--�ش� �п����� ���� ������ �����ϰ� �����ڵ�, ������� �ִ�.
--���� ���� ���� ���¸� �����ϱ� ���ؼ��� ����� ���� ������ �ʿ��ϸ�
--���¸��� ���¹�ȣ�� ������, �ϳ��� ���´� �Ѹ��� ���簡 ��ġ�ȴ�.
--���� ������ ����,����,���ǽð�(�� ���ǽð�)�� ����� �� �־�� �Ѵ�.
--�ش� �п��� ���縦 �����ϸ�, ����� ���纰 ID,�̸�,��ȭ��ȣ, �ּҸ� ���� �Ѵ�.
--���� �л��鵵 �����ϸ� �л��� �л��� ID,�̸�,��ȭ��ȣ,�ּҸ� ���� �Ѵ�.
--�л����� ���¸� ��� ���� ������û�� �� �� �ִ�.
--������û�� �ʿ��� ������ ���¹�ȣ�� �л� ID�� �ʿ��ϴ�.

--����
-- ���� �ڵ�
-- ���� ��


--����
-- ���� ��ȣ
-- ���� ID
-- ���� ID
-- ����
-- ����
-- ���ǽð� (�Ѱ��ǽð�)

-- ����
-- ���� id
-- ���� �̸�
-- ��ȭ��ȣ
-- �ּ�

--�л�
-- id
-- �̸�
-- ��ȭ��ȣ
-- �ּ�

-- ������û
-- ���¹�ȣ
--�л� ID

-- ���̺� ������ ���踦 ����Ͽ� �� ���� �����ص� ������ �߻����� �ʰ� ���ĵǾ����ϴ�.

-- ���� Table Create SQL
--system ���� ����
create user datamodelexam2 identified by 1234;
grant resource, connect to datamodelexam2;

----------------------------------
drop table ����;
drop table ����;
drop table ������û;
drop table �л�;
drop TRIGGER ����_AI_TRG;
drop sequence ����_seq;
drop sequence ����_seq;
drop sequence ����_seq;
drop sequence �л�_seq;

-- ���̺� ������ ���踦 ����Ͽ� �� ���� �����ص� ������ �߻����� �ʰ� ���ĵǾ����ϴ�.

drop table applylecture;
drop table lecture;
drop table student;
drop table subject;
drop table teacher;
drop table ����;
drop index lecture_pk;
drop index student_pk;
drop index subject_pk;
drop index teacher_pk;
drop index ����_pk;
DROP TRIGGER ����_AI_TRG;
drop sequence lecture_seq;
drop sequence student_seq;
drop sequence subject_seq;
drop sequence teacher_seq;

DROP SEQUENCE subject_SEQ;
DROP TRIGGER lecture_AI_TRG;

DROP SEQUENCE lecture_SEQ;

DROP TRIGGER student_AI_TRG;

DROP SEQUENCE student_SEQ;


-- ���̺� ������ ���踦 ����Ͽ� �� ���� �����ص� ������ �߻����� �ʰ� ���ĵǾ����ϴ�.

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

COMMENT ON COLUMN subject.s_code IS '�����ڵ�'
/

COMMENT ON COLUMN subject.s_name IS '�����'
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

COMMENT ON COLUMN teacher.t_code IS '����ID'
/

COMMENT ON COLUMN teacher.t_name IS '�����̸�'
/

COMMENT ON COLUMN teacher.t_phone IS '��ȭ��ȣ'
/

COMMENT ON COLUMN teacher.t_addr IS '�ּ�'
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

COMMENT ON COLUMN lecture.l_code IS '���¹�ȣ'
/

COMMENT ON COLUMN lecture.t_code IS '����ID'
/

COMMENT ON COLUMN lecture.s_code IS '����ID'
/

COMMENT ON COLUMN lecture.date1 IS '����'
/

COMMENT ON COLUMN lecture.period IS '����'
/

COMMENT ON COLUMN lecture.lect_time IS '���ǽð�'
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

COMMENT ON COLUMN student.st_code IS '�л�ID'
/

COMMENT ON COLUMN student.st_name IS '�л��̸�'
/

COMMENT ON COLUMN student.st_phone IS '��ȭ��ȣ'
/

COMMENT ON COLUMN student.st_addr IS '�ּ�'
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

COMMENT ON COLUMN applyLecture.l_code IS '���¹�ȣ'
/

COMMENT ON COLUMN applyLecture.st_code IS '�л�ID'
/

ALTER TABLE applyLecture
    ADD CONSTRAINT FK_applyLecture_st_code_studen FOREIGN KEY (st_code)
        REFERENCES student (st_code)
/

ALTER TABLE applyLecture
    ADD CONSTRAINT FK_applyLecture_l_code_lecture FOREIGN KEY (l_code)
        REFERENCES lecture (l_code)
/



