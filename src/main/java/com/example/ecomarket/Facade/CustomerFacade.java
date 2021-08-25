package com.example.ecomarket.Facade;

import com.example.ecomarket.Converters.CustomerConverter;
import com.example.ecomarket.DOM.CustomerRequest;
import com.example.ecomarket.DOM.CustomerResponse;
import com.example.ecomarket.Facade.DTO.CustomerDTO;
import com.example.ecomarket.Services.CustomerService;
import com.example.ecomarket.anotations.Facade;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Facade
public class CustomerFacade {
    private final CustomerService customerService;
    private final CustomerConverter customerConverter;

    @Autowired
    public CustomerFacade(CustomerService customerService, CustomerConverter customerConverter) {
        this.customerService = customerService;
        this.customerConverter = customerConverter;
    }


    public CustomerResponse create(CustomerRequest requestModel) {
        CustomerDTO customerDTO = customerConverter.buildDTOFromRequest(requestModel);
        CustomerDTO savedDataObject = customerService.create(customerDTO);
        CustomerResponse responseModel = customerConverter.buildResponseFromDTO(savedDataObject);
        return responseModel;
    }

    public CustomerResponse findCustomerByUsername(String name) {
        CustomerDTO byName = customerService.findCustomerByUsername(name);
        CustomerResponse customerResponse = customerConverter.buildResponseFromDTO(byName);
        return customerResponse;
    }

    public CustomerResponse getById(Long id) {
        CustomerDTO byId = customerService.getById(id);
        CustomerResponse customerResponseModel = customerConverter.buildResponseFromDTO(byId);
        return customerResponseModel;
    }


    public ArrayList<CustomerResponse> findAll() {
        ArrayList<CustomerDTO> all = customerService.findAll();
        List<CustomerResponse> responseModels = all.stream()
                .map(each -> customerConverter.buildResponseFromDTO(each))
                .collect(Collectors.toList());
        return (ArrayList<CustomerResponse>) responseModels;
    }


    public CustomerDTO updateById(CustomerDTO dto) {
        return customerService.updateById(dto);
    }

    public CustomerResponse updateById(CustomerRequest requestModel, Long id) {
        CustomerDTO customerDTO = customerConverter.buildDTOFromRequest(requestModel);
        customerDTO.setId(id);
        CustomerDTO updateById = customerService.updateById(customerDTO);
        CustomerResponse responseModel = customerConverter.buildResponseFromDTO(updateById);
        return responseModel;
    }

    public void deleteById(Long id) {
        customerService.deleteById(id);
    }

}
