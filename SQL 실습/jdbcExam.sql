--drop table exam_member;
--drop table exam_board;
--drop sequence exam_member_seq;
--drop sequence exam_board_seq;
insert into exam_board values(
create table exam_member(
    MEMBER_NO   number primary key,
    MEMBER_ID   VARCHAR2(20) UNIQUE,
    MEMBER_PW   VARCHAR2(30) NOT NULL,
    MEMBER_NAME VARCHAR2(20) NOT NULL,
    PHONE       CHAR(11)
);
COMMENT ON COLUMN exam_member.MEMBER_NO IS 'ȸ����ȣ';
COMMENT ON COLUMN exam_member.MEMBER_ID IS '���̵�';
COMMENT ON COLUMN  exam_member.MEMBER_PW IS '��й�ȣ';
COMMENT ON COLUMN  exam_member.MEMBER_NAME IS '�̸�';
COMMENT ON COLUMN  exam_member.PHONE IS '��ȭ��ȣ';

CREATE TABLE EXAM_BOARD(
    BOARD_NO    NUMBER  PRIMARY KEY,
    BOARD_TITLE VARCHAR2(100) NOT NULL,
    BOARD_CONTENT   VARCHAR2(2000) NOT NULL,
    BOARD_WRITER    VARCHAR2(20)    REFERENCES EXAM_MEMBER(MEMBER_ID) ON delete set null,
    READ_COUNT      NUMBER  DEFAULT 0, 
    WRITE_DATE      DATE    DEFAULT SYSDATE
);
COMMENT ON COLUMN  exam_board.BOARD_NO   IS '�Խù���ȣ';
COMMENT ON COLUMN  exam_board.BOARD_TITLE IS '����';
COMMENT ON COLUMN  exam_board.BOARD_CONTENT IS '����';
COMMENT ON COLUMN  exam_board.BOARD_WRITER IS '�ۼ���';
COMMENT ON COLUMN  exam_board.read_COUNT IS '��ȸ��';
COMMENT ON COLUMN  exam_board.WRITE_DATE IS '�ۼ���';

CREATE SEQUENCE EXAM_MEMBER_SEQ;
CREATE SEQUENCE EXAM_BOARD_SEQ;