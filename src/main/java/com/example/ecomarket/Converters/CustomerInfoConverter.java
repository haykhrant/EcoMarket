package com.example.ecomarket.Converters;

import com.example.ecomarket.DOM.CustomerInfoRequest;
import com.example.ecomarket.DOM.CustomerInfoResponse;
import com.example.ecomarket.DOM.CustomerRequest;
import com.example.ecomarket.DOM.CustomerResponse;
import com.example.ecomarket.Facade.DTO.AddressDTO;
import com.example.ecomarket.Facade.DTO.CustomerDTO;
import com.example.ecomarket.Facade.DTO.CustomerInfoDTO;
import com.example.ecomarket.anotations.Converter;

@Converter
public class CustomerInfoConverter {

    public CustomerInfoDTO buildDTOFromRequest(CustomerInfoRequest customerInfoRequest, AddressDTO addressDTO) {
        CustomerInfoDTO customerInfoDTO = new CustomerInfoDTO();
        customerInfoDTO.setDescription(customerInfoRequest.getDescription());
        customerInfoDTO.setCustomerResponse(customerInfoRequest.getCustomerResponse());
        customerInfoDTO.setAddressDTO(addressDTO);

        return customerInfoDTO;
    }

    public CustomerInfoResponse buildResponseFromDTO(CustomerInfoDTO customerInfoDTO) {
        CustomerInfoResponse customerInfoResponse = new CustomerInfoResponse();
        customerInfoResponse.setId(customerInfoDTO.getId());
        customerInfoResponse.setDescription(customerInfoDTO.getDescription());
        customerInfoResponse.setRating(customerInfoDTO.getRating());
        customerInfoResponse.setCustomerResponse(customerInfoDTO.getCustomerResponse());


        return customerInfoResponse;
    }

}
