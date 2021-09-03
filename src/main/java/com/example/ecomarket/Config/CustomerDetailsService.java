package com.example.ecomarket.Config;

import com.example.ecomarket.Facade.DTO.CustomerDTO;
import com.example.ecomarket.Services.ICustomerService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsService implements UserDetailsService {

    private final ICustomerService iCustomerService;

    public CustomerDetailsService(ICustomerService iCustomerService) {
        this.iCustomerService = iCustomerService;
    }

    @Override
    public UserDetails loadUserByUsername(String term) throws UsernameNotFoundException {
        CustomerDTO customerDTO = iCustomerService.findCustomerByUsername(term);
        if (customerDTO == null) {
            throw new UsernameNotFoundException(term);
        }

        return new CustomerDetails(customerDTO.getId(),customerDTO.getUsername(),customerDTO.getPassword(), customerDTO.getRole());
    }
}
