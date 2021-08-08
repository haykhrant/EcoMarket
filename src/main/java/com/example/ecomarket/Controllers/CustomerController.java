package com.example.ecomarket.Controllers;

import com.example.ecomarket.DOM.CustomerRequest;
import com.example.ecomarket.DOM.CustomerResponse;
import com.example.ecomarket.Services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "https://haykhrant.github.io/frontend/#/")
public class CustomerController
{
    public final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<CustomerResponse> register(@RequestBody CustomerRequest request) {
        customerService.register(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
        //return ResponseEntity.ok("Hello");
    }
}
