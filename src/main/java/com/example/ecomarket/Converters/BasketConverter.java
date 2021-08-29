package com.example.ecomarket.Converters;

import com.example.ecomarket.DOM.BasketRequest;
import com.example.ecomarket.DOM.BasketResponse;
import com.example.ecomarket.Facade.DTO.BasketDTO;
import com.example.ecomarket.Facade.DTO.CustomerDTO;
import com.example.ecomarket.anotations.Converter;

@Converter
public class BasketConverter {
    public BasketDTO basketDTOFromRequest(BasketRequest basketRequest, CustomerDTO customerDTO){
        BasketDTO basketDTO = new BasketDTO();
        basketDTO.setCustomerDTO(customerDTO);
        return basketDTO;
    }

    public BasketResponse responseFromBasketDTO(BasketDTO basketDTO){
        BasketResponse basketResponse = new BasketResponse();
        basketResponse.setId(basketDTO.getId());
        basketResponse.setCustomerId(basketDTO.getCustomerDTO().getId());
        return basketResponse;
    }
}
