package com.example.ecomarket.Controllers;

import com.example.ecomarket.DOM.CustomerRequest;
import com.example.ecomarket.DOM.CustomerResponse;
import com.example.ecomarket.Facade.CustomerFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@CrossOrigin(origins = "*" )
public class SignUpController {

    private final CustomerFacade customerFacade;

    public SignUpController(CustomerFacade customerFacade) {
        this.customerFacade = customerFacade;
    }


    @PostMapping("/register")
    public ResponseEntity<CustomerResponse> register(@RequestBody CustomerRequest request) {
        CustomerResponse response = customerFacade.create(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/login")
    public ResponseEntity<CustomerResponse> login(Authentication authentication) {
        Long id = customerFacade.getIdByAuthentication(authentication);
        return ResponseEntity.ok(customerFacade.getById(id));
    }
}
