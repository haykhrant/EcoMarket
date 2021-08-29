package com.example.ecomarket.Repositories;

import com.example.ecomarket.Models.BasketProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBasketProductRepository extends JpaRepository<BasketProducts,Long> {
}
