package com.example.ecomarket.DOM;

import java.util.ArrayList;

public class CategoryResponse {
    private Long id;
    private String categoryName;
    private ArrayList<ProductTypeResponse> productTypeResponses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ArrayList<ProductTypeResponse> getProductTypeResponses() {
        return productTypeResponses;
    }

    public void setProductTypeResponses(ArrayList<ProductTypeResponse> productTypeResponses) {
        this.productTypeResponses = productTypeResponses;
    }
}
