package com.example.ecomarket.Repositories;

import com.example.ecomarket.Models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdressRepository extends JpaRepository<Address,Long> {
}
