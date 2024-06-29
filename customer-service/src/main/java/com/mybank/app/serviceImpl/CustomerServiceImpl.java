package com.mybank.app.serviceImpl;

import com.mybank.app.model.*;
import com.mybank.app.repository.BranchRepository;
import com.mybank.app.repository.CustomerRepository;
import com.mybank.app.service.CustomerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Date;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private static final SecureRandom RANDOM = new SecureRandom();
    private final CustomerRepository customerRepository;
    private final BranchRepository branchRepository;

    @Override
    public Customer addCustomer(Customer customer, long branchId) {
            Customer newCustomer = new Customer();
            newCustomer.setFirstName(customer.getFirstName());
            newCustomer.setLastName(customer.getLastName());
            newCustomer.setPhoneNumber(customer.getPhoneNumber());
            newCustomer.setPhoneNumberVerified(true);
            newCustomer.setEmail(customer.getEmail());
            newCustomer.setEmailVerified(true);
            newCustomer.setPassword(customer.getPassword());
            newCustomer.setKycSuccess(true);
            newCustomer.setDob(customer.getDob());
            newCustomer.setActive(true);
            newCustomer.setCreatedOn(new Date());

            Address newAddress = new Address();
            newAddress.setStreet(customer.getAddress().getStreet());
            newAddress.setDistrict(customer.getAddress().getDistrict());
            newAddress.setState(customer.getAddress().getState());
            newAddress.setCountry(customer.getAddress().getCountry());
            newAddress.setPincode(customer.getAddress().getPincode());
            newCustomer.setAddress(newAddress);

            Account newAccount = new Account();
            Branch branch = branchRepository.findById(branchId).orElseThrow(() -> new EntityNotFoundException("branch id not found."));
            newAccount.setAccountNumber(generateAccountNumber());
            newAccount.setAccountType(AccountType.SAVINGS);
            newCustomer.setAccount(newAccount);
            newAccount.setBranch(branch);
            return customerRepository.save(newCustomer);
    }

    private String generateAccountNumber() {
        StringBuilder accountNumber = new StringBuilder("789247");
        for(int i=0;i<4;i++){
            int digit = RANDOM.nextInt(10);
            accountNumber.append(digit);
        }
        return accountNumber.toString();
    }
}
