package com.example.ecomarket.Services;

import com.example.ecomarket.DOM.CustomerRequest;
import com.example.ecomarket.Models.Customer;
import com.example.ecomarket.Models.Role;
import com.example.ecomarket.Repositories.CustomerRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    public final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final CustomerRepository customerRepository;


    public CustomerService(BCryptPasswordEncoder bCryptPasswordEncoder, CustomerRepository customerRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.customerRepository = customerRepository;
    }

    public Customer register(CustomerRequest request){
        Customer customer = convertFromRequestToUser(request);
        return customerRepository.save(customer);
    }

    private Customer convertFromRequestToUser(CustomerRequest request){
        Customer customer = new Customer();
        customer.setFullname(request.getFullname());
        customer.setUsername(request.getUsername());
        customer.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        customer.setRole(Role.USER);
        return customer;

    }
}
