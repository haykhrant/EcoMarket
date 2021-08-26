package com.example.ecomarket.Converters;

import com.example.ecomarket.DOM.CustomerRequest;
import com.example.ecomarket.DOM.CustomerResponse;
import com.example.ecomarket.Facade.DTO.CustomerDTO;
import com.example.ecomarket.anotations.Converter;

@Converter
public class CustomerConverter {

    public CustomerDTO buildDTOFromRequest(CustomerRequest customerRequest) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFullname(customerRequest.getFullname());
        customerDTO.setUsername(customerRequest.getUsername());
        customerDTO.setPassword(customerRequest.getPassword());
        customerDTO.setRole("USER");

        return customerDTO;
    }

    public CustomerResponse buildResponseFromDTO(CustomerDTO customerDTO) {
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(customerDTO.getId());
        customerResponse.setFullname(customerDTO.getFullname());
        customerResponse.setUsername(customerDTO.getUsername());
        customerResponse.setRole("USER");

        return customerResponse;
    }

}
