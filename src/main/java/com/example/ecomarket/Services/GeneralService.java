package com.example.ecomarket.Services;

import com.example.ecomarket.Facade.DTO.CategoryDTO;
import com.example.ecomarket.Facade.DTO.ProductTypeDTO;
import com.example.ecomarket.Models.Category;
import com.example.ecomarket.Models.ProductType;

public class GeneralService {
    protected Category buildCategoryFromDto(CategoryDTO dto) {
        Category category = new Category();
        category.setName(dto.getCategoryName());
        category.setId(dto.getId());
        return category;
    }

    protected CategoryDTO buildDtoFromCategory(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setCategoryName(category.getName());
        return dto;
    }

    protected ProductType buildProductTypeFromDto(ProductTypeDTO dto) {
        ProductType productType = new ProductType();
        productType.setName(dto.getProductTypeName());
        productType.setId(dto.getId());
        productType.setCategory(buildCategoryFromDto(dto.getCategoryDTO()));
        return productType;
    }

    protected ProductTypeDTO buildDtoFromProductType(ProductType productType) {
        ProductTypeDTO dto = new ProductTypeDTO();
        dto.setId(productType.getId());
        dto.setProductTypeName(productType.getName());
        dto.setCategoryDTO(buildDtoFromCategory(productType.getCategory()));
        return dto;
    }
}
