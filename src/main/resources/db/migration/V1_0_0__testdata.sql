CREATE TABLE PRODUCT (
   id INTEGER PRIMARY KEY,
   productName VARCHAR(255) NOT NULL,
   status VARCHAR(255) NOT NULL
);

INSERT INTO PRODUCT VALUES (1, 'Fancy Product 1', 'INACTIVE'), (2, 'Fancy Product 2', 'ACTIVE'), (3, 'Fancy Product 3', 'IN_CREATION')