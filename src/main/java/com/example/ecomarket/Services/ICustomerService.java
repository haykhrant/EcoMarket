package com.example.ecomarket.Services;

import com.example.ecomarket.Facade.DTO.CustomerDTO;
import com.example.ecomarket.Models.Customer;

import java.util.ArrayList;

public interface ICustomerService {
    CustomerDTO create(CustomerDTO dto);

    CustomerDTO getById(Long id);

    ArrayList<CustomerDTO> findAll();

    CustomerDTO findCustomerByUsername(String username);;

    CustomerDTO updateById(CustomerDTO dto);

    void deleteById(Long id);


}