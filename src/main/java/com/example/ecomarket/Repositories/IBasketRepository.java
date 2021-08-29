package com.example.ecomarket.Repositories;

import com.example.ecomarket.Models.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBasketRepository extends JpaRepository<Basket,Long> {
}
