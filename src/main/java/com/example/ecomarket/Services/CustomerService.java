package com.example.ecomarket.Services;


import com.example.ecomarket.Facade.DTO.CustomerDTO;
import com.example.ecomarket.Models.Basket;
import com.example.ecomarket.Models.Customer;
import com.example.ecomarket.Repositories.IBasketRepository;
import com.example.ecomarket.Repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService extends GeneralService implements ICustomerService {

    private final ICustomerRepository ICustomerRepository;
    private final IBasketRepository iBasketRepository;

    @Autowired
    public CustomerService(ICustomerRepository iCustomerRepository,IBasketRepository iBasketRepository) {
        this.ICustomerRepository = iCustomerRepository;
        this.iBasketRepository = iBasketRepository;
    }

    @Override
    public CustomerDTO create(CustomerDTO dto) {
        Customer customer = customerFromDTO(dto);
        Customer saved = ICustomerRepository.save(customer);
        Basket basket = new Basket();
        basket.setCustomer(saved);
        iBasketRepository.save(basket);
        return dtoFromCustomer(saved);
    }

    @Override
    public  CustomerDTO findCustomerByUsername(String username) {
        Customer byUsername = ICustomerRepository.findCustomerByUsername(username);
        CustomerDTO customerDTO = new CustomerDTO(
                byUsername.getId(),
                byUsername.getFullname(),
                byUsername.getUsername(),
                byUsername.getPassword(),
                byUsername.getRole());
        return customerDTO;
    }

    @Override
    public CustomerDTO getById(Long id) {
        Customer byId=ICustomerRepository.getById(id);
        return dtoFromCustomer(byId);
    }

    @Override
    public ArrayList<CustomerDTO> findAll() {
        List<Customer> all = ICustomerRepository.findAll();
        List<CustomerDTO> dataObjects = all.stream()
                .map(each -> dtoFromCustomer(each))
                .collect(Collectors.toList());
        return (ArrayList<CustomerDTO>) dataObjects;
    }

    @Override
    public CustomerDTO updateById(CustomerDTO dto) {
        Customer byId = ICustomerRepository.getById(dto.getId());
        byId.setId(dto.getId());
        byId.setFullname(dto.getFullname());
        byId.setUsername(dto.getUsername());
        byId.setPassword(dto.getPassword());
        Customer saved = ICustomerRepository.save(byId);
        return dtoFromCustomer(saved);
    }

    @Override
    public void deleteById(Long id) {
        ICustomerRepository.deleteById(id);
    }

}

