CREATE TABLE customer(
id BIGINT AUTO_INCREMENT,
first_name VARCHAR(20),
last_name VARCHAR(20),
email VARCHAR(20),
password VARCHAR(100),
created_on DATE,
PRIMARY KEY (id)
);