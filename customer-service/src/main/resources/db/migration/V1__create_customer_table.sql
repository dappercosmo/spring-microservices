CREATE TABLE customer(
id BIGINT AUTO_INCREMENT,
first_name VARCHAR(20),
last_name VARCHAR(20),
phone_number VARCHAR(10),
is_phone_number_verified BIT,
email VARCHAR(30),
is_email_verified BIT,
password VARCHAR(100),
is_kyc_success BIT,
created_on DATE,
is_active BIT,
PRIMARY KEY (id)
);