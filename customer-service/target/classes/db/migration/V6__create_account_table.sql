CREATE TABLE account(
id BIGINT AUTO_INCREMENT,
account_type VARCHAR(10),
account_number VARCHAR(12),
balance VARCHAR(10),
customer_id BIGINT,
PRIMARY KEY(id),
FOREIGN KEY(customer_id) REFERENCES customer(id) ON DELETE CASCADE
);