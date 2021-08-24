package com.example.ecomarket.Services;

import com.example.ecomarket.Facade.DTO.CategoryDTO;
import com.example.ecomarket.Facade.DTO.ProductTypeDTO;

import java.util.ArrayList;

public interface ICategoryService {
    CategoryDTO create(CategoryDTO dto);

    CategoryDTO getById(Long id);

    ArrayList<CategoryDTO> findAll();

    ArrayList<CategoryDTO> findAllByName(String name);

    CategoryDTO updateById(CategoryDTO dto);

    void deleteById(Long id);
}
