package com.example.ecomarket.Repositories;

import com.example.ecomarket.Models.Category;
import com.example.ecomarket.Models.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface IProductTypeRepository extends JpaRepository<ProductType, Long> {
    ArrayList<ProductType> findAllByCategoryAndName(Category category, String name);
}
