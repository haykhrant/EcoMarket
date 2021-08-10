package com.example.ecomarket.DOM;

import com.example.ecomarket.Facade.DTO.ProductTypeDTO;

import java.util.ArrayList;

public class CategoryRequest {
    private String categoryName;
    private ArrayList<ProductTypeDTO> productTypeDTOS;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ArrayList<ProductTypeDTO> getProductTypeDTOS() {
        return productTypeDTOS;
    }

    public void setProductTypeDTOS(ArrayList<ProductTypeDTO> productTypeDTOS) {
        this.productTypeDTOS = productTypeDTOS;
    }

}
