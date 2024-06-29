package com.mybank.app.service;

import com.mybank.app.model.Customer;

public interface CustomerService {
    Customer addCustomer(Customer customer, long branchId);
}
