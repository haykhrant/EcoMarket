package com.example.ecomarket.DOM;

public class CategoryProductTypeRequest {
    private Long categoryId;
    private ProductTypeRequest productTypeRequest;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public ProductTypeRequest getProductTypeRequest() {
        return productTypeRequest;
    }

    public void setProductTypeRequest(ProductTypeRequest productTypeRequest) {
        this.productTypeRequest = productTypeRequest;
    }
}
