package com.example.ecomarket.DOM;

import com.example.ecomarket.Facade.DTO.CategoryDTO;

public class ProductTypeRequest {
    private String productTypeName;

    private CategoryDTO categoryDTO;

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

}
