create table address(
id BIGINT AUTO_INCREMENT,
customer_id BIGINT UNIQUE,
street varchar(100),
district varchar(20),
state VARCHAR(20),
country VARCHAR(20),
pincode VARCHAR(20),
PRIMARY KEY(id),
FOREIGN KEY(customer_id) REFERENCES customer(id) ON DELETE CASCADE
);