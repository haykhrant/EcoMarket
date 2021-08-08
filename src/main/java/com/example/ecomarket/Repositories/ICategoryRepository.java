package com.example.ecomarket.Repositories;

import com.example.ecomarket.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
    ArrayList<Category> findAllByName(String name);
}
