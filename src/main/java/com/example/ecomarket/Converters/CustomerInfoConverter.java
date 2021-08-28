package com.example.ecomarket.Converters;

import com.example.ecomarket.DOM.*;
import com.example.ecomarket.Facade.DTO.AddressDTO;
import com.example.ecomarket.Facade.DTO.CustomerDTO;
import com.example.ecomarket.Facade.DTO.CustomerInfoDTO;
import com.example.ecomarket.Models.Customer;
import com.example.ecomarket.anotations.Converter;

@Converter
public class CustomerInfoConverter {

    public CustomerInfoDTO buildDTOFromRequest(CustomerInfoRequest customerInfoRequest, CustomerDTO customerDTO, AddressDTO addressDTO) {
        CustomerInfoDTO customerInfoDTO = new CustomerInfoDTO();
        customerInfoDTO.setDescription(customerInfoRequest.getDescription());
        customerInfoDTO.setCustomerDTO(customerDTO);
        customerInfoDTO.setAddressDTO(addressDTO);

        return customerInfoDTO;
    }

    public CustomerInfoResponse buildResponseFromDTO(CustomerInfoDTO customerInfoDTO, CustomerResponse customerResponse, AddressResponse addressResponse) {
        CustomerInfoResponse customerInfoResponse = new CustomerInfoResponse();
        customerInfoResponse.setId(customerInfoDTO.getId());
        customerInfoResponse.setDescription(customerInfoDTO.getDescription());
        customerInfoResponse.setRating(customerInfoDTO.getRating());
        customerInfoResponse.setCustomerResponse(customerResponse);
        customerInfoResponse.setAdressResponse(addressResponse);

        return customerInfoResponse;
    }

}
