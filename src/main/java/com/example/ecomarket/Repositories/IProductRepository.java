package com.example.ecomarket.Repositories;

import com.example.ecomarket.Models.Product;
import com.example.ecomarket.Models.ProductDescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface IProductRepository extends JpaRepository<Product,Long> {
}
