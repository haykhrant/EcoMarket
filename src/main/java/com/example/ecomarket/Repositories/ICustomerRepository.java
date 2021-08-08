package com.example.ecomarket.Repositories;

import com.example.ecomarket.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerByUsername(String username);
}
