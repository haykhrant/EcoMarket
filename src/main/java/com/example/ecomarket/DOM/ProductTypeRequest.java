package com.example.ecomarket.DOM;

import com.example.ecomarket.Facade.DTO.CategoryDTO;
import com.example.ecomarket.Models.Category;

public class ProductTypeRequest {
    private String productTypeName;

    private Long categoryId;

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
