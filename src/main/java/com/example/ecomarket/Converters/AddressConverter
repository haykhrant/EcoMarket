package com.example.ecomarket.Converters;

import com.example.ecomarket.DOM.AddressRequest;
import com.example.ecomarket.DOM.AddressResponse;
import com.example.ecomarket.Facade.DTO.AddressDTO;
import com.example.ecomarket.anotations.Converter;

@Converter
public class AddressConverter {
    public AddressDTO buildDTOFromRequest(AddressRequest addressRequest){
        AddressDTO addressDTO=new AddressDTO();
        addressDTO.setRegion(addressRequest.getRegion());
        addressDTO.setCity(addressRequest.getCity());
        addressDTO.setStreet(addressRequest.getStreet());
        addressDTO.setHouse(addressRequest.getHouse());

        return addressDTO;
    }

    public AddressResponse buildResponseFromDTO(AddressDTO addressDTO){
        AddressResponse addressResponse=new AddressResponse();
        addressResponse.setId(addressDTO.getId());
        addressResponse.setRegion(addressDTO.getRegion());
        addressResponse.setCity(addressDTO.getCity());
        addressResponse.setStreet(addressDTO.getStreet());
        addressResponse.setHouse(addressDTO.getHouse());

        return addressResponse;
    }
}
