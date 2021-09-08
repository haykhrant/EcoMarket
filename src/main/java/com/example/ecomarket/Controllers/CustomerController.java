package com.example.ecomarket.Controllers;

import com.example.ecomarket.DOM.CustomerRequest;
import com.example.ecomarket.DOM.CustomerResponse;
import com.example.ecomarket.Facade.CustomerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Component
@RestController
//@CrossOrigin(origins = "*" )
public class CustomerController
{
    private final CustomerFacade customerFacade;

    @Autowired
    public CustomerController(CustomerFacade customerFacade) {
        this.customerFacade = customerFacade;
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<CustomerResponse> getById(@PathVariable Long id) {
        CustomerResponse customerById = customerFacade.getById(id);
        return ResponseEntity.ok(customerById);
    }

    @GetMapping("/persons")
    public ResponseEntity<ArrayList<CustomerResponse>> getAll() {
        ArrayList<CustomerResponse> responseModels = customerFacade.findAll();
        return ResponseEntity.ok(responseModels);
    }


    @GetMapping("/person/username/{username}")
    public ResponseEntity<CustomerResponse> getByUsername(@PathVariable String username) {
        CustomerResponse customerByUsername = customerFacade.findCustomerByUsername(username);
        return ResponseEntity.ok(customerByUsername);
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<CustomerResponse> updateById(@RequestBody CustomerRequest requestModel,@PathVariable Long id){
        CustomerResponse responseModel = customerFacade.updateById(requestModel, id);
        return ResponseEntity.ok(responseModel);
    }

    @DeleteMapping("/person/{id}")
    public void deleteById(@PathVariable Long id){
        customerFacade.deleteById(id);
    }

}