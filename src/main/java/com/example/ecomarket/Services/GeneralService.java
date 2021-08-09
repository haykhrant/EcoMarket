package com.example.ecomarket.Services;

import com.example.ecomarket.Facade.DTO.CategoryDTO;
import com.example.ecomarket.Facade.DTO.ProductTypeDTO;
import com.example.ecomarket.Models.Category;
import com.example.ecomarket.Models.ProductType;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class GeneralService {
    protected Category buildCategoryFromDto(CategoryDTO dto) {
        Category category = new Category();
        category.setName(dto.getCategoryName());
        category.setId(dto.getId());
        category.setProductTypeList(dto.getProductTypeDTOS().stream().map(each -> buildProductTypeFromDto(each)).collect(Collectors.toList()));
        return category;
    }

    protected CategoryDTO buildDtoFromCategory(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setCategoryName(category.getName());
        dto.setProductTypeDTOS((ArrayList<ProductTypeDTO>) category.getProductTypeList().stream().map(each -> buildDtoFromProductType(each)).collect(Collectors.toList()));
        return dto;
    }

    protected ProductType buildProductTypeFromDto(ProductTypeDTO dto) {
        ProductType productType = new ProductType();
        productType.setName(dto.getProductTypeName());
        return productType;
    }

    protected ProductTypeDTO buildDtoFromProductType(ProductType productType) {
        ProductTypeDTO dto = new ProductTypeDTO();
        dto.setId(productType.getId());
        dto.setProductTypeName(productType.getName());
        return dto;
    }
}
