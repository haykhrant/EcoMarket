package com.example.ecomarket.DOM;

import com.example.ecomarket.Models.ProductComment;
import com.example.ecomarket.Models.ProductDescription;
import com.example.ecomarket.Models.ProductType;

import java.util.List;

public class ProductRequest {
    private String name;
    private String ownerComment;
    private String price;
    private ProductTypeResponse productTypeResponse;
    private List<ProductDescriptionRequest> productDescriptions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerComment() {
        return ownerComment;
    }

    public void setOwnerComment(String ownerComment) {
        this.ownerComment = ownerComment;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ProductTypeResponse getProductTypeResponse() {
        return productTypeResponse;
    }

    public void setProductTypeResponse(ProductTypeResponse productType) {
        this.productTypeResponse = productTypeResponse;
    }

    public List<ProductDescriptionRequest> getProductDescriptions() {
        return productDescriptions;
    }

    public void setProductDescriptions(List<ProductDescriptionRequest> productDescriptions) {
        this.productDescriptions = productDescriptions;
    }
}
