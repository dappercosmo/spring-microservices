package com.mybank.app.serviceImpl;

import com.mybank.app.model.Customer;
import com.mybank.app.repository.CustomerRepository;
import com.mybank.app.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) {
            Customer newCustomer = new Customer();
            newCustomer.setFirstName(customer.getFirstName());
            newCustomer.setLastName(customer.getLastName());
            newCustomer.setEmail(customer.getEmail());
            newCustomer.setPassword(customer.getPassword());
            newCustomer.setCreatedOn(new Date());
            return customerRepository.save(newCustomer);
    }
}
