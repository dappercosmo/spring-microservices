package com.mybank.app.controller;

import com.mybank.app.model.Customer;
import com.mybank.app.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/{branchId}")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer, @PathVariable("branchId") long branchId){
        try{
            customerService.addCustomer(customer,branchId);
            return ResponseEntity.ok(customer);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
