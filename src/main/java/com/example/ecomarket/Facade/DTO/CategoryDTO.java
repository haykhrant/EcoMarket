package com.example.ecomarket.Facade.DTO;

import java.util.ArrayList;

public class CategoryDTO {
    private Long id;
    private String categoryName;
    private ArrayList<ProductTypeDTO> productTypeDTOS;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    public ArrayList<ProductTypeDTO> getProductTypeDTOS()
    {
        return productTypeDTOS;
    }

    public void setProductTypeDTOS(ArrayList<ProductTypeDTO> productTypeDTOS)
    {
        this.productTypeDTOS = productTypeDTOS;
    }
}
