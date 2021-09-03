package com.example.ecomarket.DOM;

import com.example.ecomarket.Models.ProductComment;
import com.example.ecomarket.Models.ProductDescription;
import com.example.ecomarket.Models.ProductType;

import java.util.ArrayList;
import java.util.List;

public class ProductRequest {
    private String name;
    private String ownerComment;
    private String price;
    private Long   productTypeId;
    private Long   customerId;
    private ArrayList<ProductDescriptionRequest> descriptionRequests;

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

    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public ArrayList<ProductDescriptionRequest> getDescriptionRequests() {
        return descriptionRequests;
    }

    public void setDescriptionRequests(ArrayList<ProductDescriptionRequest> descriptionRequests) {
        this.descriptionRequests = descriptionRequests;
    }

}
