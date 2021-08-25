package com.example.ecomarket.Services;


import com.example.ecomarket.Facade.DTO.CustomerDTO;
import com.example.ecomarket.Models.Customer;
import com.example.ecomarket.Repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {
    private final ICustomerRepository ICustomerRepository;

    @Autowired
    public CustomerService(ICustomerRepository iCustomerRepository) {
        this.ICustomerRepository = iCustomerRepository;
    }



    @Override
    public CustomerDTO create(CustomerDTO dto) {
        Customer customer = customerFromDTO(dto);
        Customer saved = ICustomerRepository.save(customer);
        return dtoFromCustomer(saved);
    }

    @Override
    public  CustomerDTO findCustomerByUsername(String username) {
        Customer byUsername = ICustomerRepository.findCustomerByUsername(username);
        return dtoFromCustomer(byUsername);
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


    public Customer customerFromDTO(CustomerDTO customerDTO) {
        Customer customer=new Customer();
        customer.setId(customerDTO.getId());
        customer.setFullname(customerDTO.getFullname());
        customer.setUsername(customerDTO.getUsername());
        customer.setPassword(customerDTO.getPassword());
        customer.setRole("USER");

        return customer;
    }

    public CustomerDTO dtoFromCustomer(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setFullname(customer.getFullname());
        customerDTO.setUsername(customer.getUsername());
        customerDTO.setPassword(customer.getPassword());

        return customerDTO;
    }
}
