package com.example.ecomarket.Services;
import com.example.ecomarket.Facade.DTO.CategoryDTO;
import com.example.ecomarket.Facade.DTO.ProductTypeDTO;

import java.util.ArrayList;

public interface IProductTypeService {
    ProductTypeDTO create(ProductTypeDTO dto);

    ProductTypeDTO getById(Long id);

    ArrayList<ProductTypeDTO> findAll();

    ArrayList<ProductTypeDTO> getProductTypesByCategoryId(Long id);

    ProductTypeDTO updateById(ProductTypeDTO dto);

    void deleteById(Long id);
}
