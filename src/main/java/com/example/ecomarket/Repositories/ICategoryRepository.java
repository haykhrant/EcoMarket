package com.example.ecomarket.Repositories;

import com.example.ecomarket.Models.Category;
import com.example.ecomarket.Models.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
    ArrayList<Category> findAllByName(String name);
    @Modifying
    @Query(value = "insert into category_product_types(product_type_id,category_id) values(?2,?1)", nativeQuery = true)
    void addToList(Long categoryId,Long productTypeId);

}
