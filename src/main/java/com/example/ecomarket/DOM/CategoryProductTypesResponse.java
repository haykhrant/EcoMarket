package com.example.ecomarket.DOM;

import java.util.ArrayList;

public class CategoryProductTypesResponse {
    private CategoryResponse categoryResponse;
    private ArrayList<ProductTypeResponse> productTypeResponses;

    public CategoryResponse getCategoryResponse() {
        return categoryResponse;
    }

    public void setCategoryResponse(CategoryResponse categoryResponse) {
        this.categoryResponse = categoryResponse;
    }

    public ArrayList<ProductTypeResponse> getProductTypeResponses() {
        return productTypeResponses;
    }

    public void setProductTypeResponses(ArrayList<ProductTypeResponse> productTypeResponses) {
        this.productTypeResponses = productTypeResponses;
    }
}
