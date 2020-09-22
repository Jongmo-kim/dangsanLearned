-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

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

COMMENT ON COLUMN customer.no IS '고객번호'
/

COMMENT ON COLUMN customer.name IS '고객명'
/

COMMENT ON COLUMN customer.phone IS '연락처'
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

COMMENT ON TABLE product IS '상품'
/

COMMENT ON COLUMN product.p_code IS '상품코드'
/

COMMENT ON COLUMN product.p_name IS '상품명'
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

COMMENT ON TABLE contract IS '계약'
/

COMMENT ON COLUMN contract.c_no IS '계약번호'
/

COMMENT ON COLUMN contract.no IS '고객번호'
/

COMMENT ON COLUMN contract.p_code IS '상품코드'
/

COMMENT ON COLUMN contract.c_date IS '계약일자'
/

COMMENT ON COLUMN contract.start_date IS '보험시작일'
/

COMMENT ON COLUMN contract.end_date IS '보험종료일'
/

COMMENT ON COLUMN contract.price IS '납입보험료'
/

COMMENT ON COLUMN contract.count IS '총납입회차'
/

ALTER TABLE contract
    ADD CONSTRAINT FK_contract_no_customer_no FOREIGN KEY (no)
        REFERENCES customer (no)
/

ALTER TABLE contract
    ADD CONSTRAINT FK_contract_p_code_product_p_c FOREIGN KEY (p_code)
        REFERENCES product (p_code)
/

