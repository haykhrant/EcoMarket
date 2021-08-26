package com.example.ecomarket.Facade.DTO;

import com.example.ecomarket.Models.Category;

public class ProductTypeDTO {
    private Long id;
    private String productTypeName;
    private CategoryDTO categoryDTO;

    //region Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

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
    //endregion
}
