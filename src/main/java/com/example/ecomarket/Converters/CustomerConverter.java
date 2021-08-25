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
        CustomerResponse customerResponseModel = new CustomerResponse();
        customerResponseModel.setId(customerDTO.getId());
        customerResponseModel.setFullname(customerDTO.getFullname());
        customerResponseModel.setUsername(customerDTO.getUsername());
        customerResponseModel.setRole("USER");

        return customerResponseModel;
    }

}
