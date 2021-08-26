package com.example.ecomarket.Repositories;

import com.example.ecomarket.Models.ProductComment;
import com.example.ecomarket.Models.ProductDescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface IProductCommentRepository extends JpaRepository<ProductComment,Long> {
    ArrayList<ProductComment> findAllByProduct_Id(Long id);
}
