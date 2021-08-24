package com.example.ecomarket.Repositories;
import com.example.ecomarket.Models.ProductDescription;
import com.example.ecomarket.Models.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface IProductDescriptionRepository extends JpaRepository<ProductDescription,Long> {
    ArrayList<ProductDescription> findAllByProduct_Id(Long id);
}