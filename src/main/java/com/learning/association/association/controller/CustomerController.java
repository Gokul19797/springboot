package com.learning.association.association.controller;

import com.learning.association.association.model.Customer;
import com.learning.association.association.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/")
@AllArgsConstructor
public class CustomerController {


    private final CustomerRepository customerRepository;

    @GetMapping("getcustomers")
    public List<Customer> getAllCustomer(){

       return customerRepository.findAll();
    }


    @PostMapping("addCustomer")
    public Customer SaveCustomerDetails(@RequestBody Customer customer){

        Customer customer1 =   customerRepository.save(customer);

        return customer1;
    }
}
