package com.example.ecomarket.Facade;

import com.example.ecomarket.Converters.AddressConverter;
import com.example.ecomarket.Converters.CustomerConverter;
import com.example.ecomarket.Converters.CustomerInfoConverter;
import com.example.ecomarket.Services.CustomerInfoService;
import com.example.ecomarket.Services.CustomerService;
import com.example.ecomarket.anotations.Facade;
import org.springframework.beans.factory.annotation.Autowired;

@Facade
public class CustomerInfoFacade {
    private final CustomerInfoService customerInfoService;
    private final CustomerInfoConverter customerInfoConverter;
    private final AddressConverter addressConverter;

    @Autowired
    public CustomerInfoFacade(CustomerInfoService customerInfoService,
                              CustomerInfoConverter customerInfoConverter,
                              AddressConverter addressConverter)
    {
        this.customerInfoService = customerInfoService;
        this.customerInfoConverter = customerInfoConverter;
        this.addressConverter = addressConverter;
    }


}
