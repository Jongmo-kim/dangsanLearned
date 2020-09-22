-- ���̺� ������ ���踦 ����Ͽ� �� ���� �����ص� ������ �߻����� �ʰ� ���ĵǾ����ϴ�.

-- customer Table Create SQL
CREATE TABLE customer
(
    no       NUMBER          NOT NULL, 
    name     VARCHAR2(20)    NOT NULL, 
    phone    VARCHAR2(20)    NOT NULL, 
    CONSTRAINT CUSTOMER_PK PRIMARY KEY (no)
)
/
CREATE SEQUENCE customer_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER customer_AI_TRG
BEFORE INSERT ON customer 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT customer_SEQ.NEXTVAL
    INTO :NEW.no
    FROM DUAL;
END;
/

--DROP TRIGGER customer_AI_TRG;
/

--DROP SEQUENCE customer_SEQ;
/

COMMENT ON COLUMN customer.no IS '����ȣ'
/

COMMENT ON COLUMN customer.name IS '����'
/

COMMENT ON COLUMN customer.phone IS '����ó'
/


-- customer Table Create SQL
CREATE TABLE product
(
    p_code    NUMBER           NOT NULL, 
    p_name    VARCHAR2(100)    NOT NULL, 
    CONSTRAINT PRODUCT_PK PRIMARY KEY (p_code)
)
/

CREATE SEQUENCE product_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER product_AI_TRG
BEFORE INSERT ON product 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT product_SEQ.NEXTVAL
    INTO :NEW.p_code
    FROM DUAL;
END;
/

--DROP TRIGGER product_AI_TRG;
/

--DROP SEQUENCE product_SEQ;
/

COMMENT ON TABLE product IS '��ǰ'
/

COMMENT ON COLUMN product.p_code IS '��ǰ�ڵ�'
/

COMMENT ON COLUMN product.p_name IS '��ǰ��'
/


-- customer Table Create SQL
CREATE TABLE contract
(
    c_no          NUMBER    NOT NULL, 
    no            NUMBER    NOT NULL, 
    p_code        NUMBER    NOT NULL, 
    c_date        DATE      NOT NULL, 
    start_date    DATE      NOT NULL, 
    end_date      DATE      NOT NULL, 
    price         NUMBER    NOT NULL, 
    count         number    NOT NULL, 
    CONSTRAINT CONTRACT_PK PRIMARY KEY (c_no)
)
/

CREATE SEQUENCE contract_SEQ
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER contract_AI_TRG
BEFORE INSERT ON contract 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT contract_SEQ.NEXTVAL
    INTO :NEW.c_no
    FROM DUAL;
END;
/

--DROP TRIGGER contract_AI_TRG;
/

--DROP SEQUENCE contract_SEQ;
/

COMMENT ON TABLE contract IS '���'
/

COMMENT ON COLUMN contract.c_no IS '����ȣ'
/

COMMENT ON COLUMN contract.no IS '����ȣ'
/

COMMENT ON COLUMN contract.p_code IS '��ǰ�ڵ�'
/

COMMENT ON COLUMN contract.c_date IS '�������'
/

COMMENT ON COLUMN contract.start_date IS '���������'
/

COMMENT ON COLUMN contract.end_date IS '����������'
/

COMMENT ON COLUMN contract.price IS '���Ժ����'
/

COMMENT ON COLUMN contract.count IS '�ѳ���ȸ��'
/

ALTER TABLE contract
    ADD CONSTRAINT FK_contract_no_customer_no FOREIGN KEY (no)
        REFERENCES customer (no)
/

ALTER TABLE contract
    ADD CONSTRAINT FK_contract_p_code_product_p_c FOREIGN KEY (p_code)
        REFERENCES product (p_code)
/

