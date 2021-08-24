package com.example.ecomarket.Facade.DTO;

import com.example.ecomarket.Models.ProductType;

import java.util.ArrayList;

public class CategoryDTO {
    private Long id;
    private String categoryName;

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
}
