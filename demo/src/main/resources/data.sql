CREATE TABLE PRICES (id NUMBER, brand_id NUMBER, start_date DATETIME, end_date DATETIME ,price_list NUMBER, product_id NUMBER, priority NUMBER, price NUMBER, curr VARCHAR2(5) );
insert into prices (id,brand_id,start_date,end_date,price_list,product_id,priority,price,curr) values (1,1, TO_DATE('2020-06-14-00.00.00','yyyy-mm-dd-hh24-mi-ss'), TO_DATE('2020-12-31-23.59.59','yyyy-mm-dd-hh24-mi-ss'), 1, 35455, 0, 35.50,'EUR');
insert into prices (id,brand_id,start_date,end_date,price_list,product_id,priority,price,curr) values (2,1, TO_DATE('2020-06-14-15.00.00','yyyy-mm-dd-hh24-mi-ss'), TO_DATE('2020-06-14-18.30.00','yyyy-mm-dd-hh24-mi-ss'), 2, 35455, 1, 25.45,'EUR');
insert into prices (id,brand_id,start_date,end_date,price_list,product_id,priority,price,curr) values (3,1, TO_DATE('2020-06-15-00.00.00','yyyy-mm-dd-hh24-mi-ss'), TO_DATE('2020-06-15-11.00.00','yyyy-mm-dd-hh24-mi-ss'), 3, 35455, 1, 30.50,'EUR');
insert into prices (id,brand_id,start_date,end_date,price_list,product_id,priority,price,curr) values (4,1, TO_DATE('2020-06-15-16.00.00','yyyy-mm-dd-hh24-mi-ss'), TO_DATE('2020-12-31-23.59.59','yyyy-mm-dd-hh24-mi-ss'), 4, 35455, 1, 38.95,'EUR');





