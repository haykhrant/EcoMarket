package com.example.ecomarket.Repositories;

import com.example.ecomarket.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {

}
