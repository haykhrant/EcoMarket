package com.example.ecomarket.Repositories;

import com.example.ecomarket.Facade.DTO.ProductTypeDTO;
import com.example.ecomarket.Models.Category;
import com.example.ecomarket.Models.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface IProductTypeRepository extends JpaRepository<ProductType, Long> {
    ArrayList<ProductType> findAllByCategory_Id(Long id);
}
