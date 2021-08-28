package com.example.ecomarket.Facade.DTO;

import com.example.ecomarket.DOM.CustomerInfoResponse;
import com.example.ecomarket.DOM.ProductCommentRequest;
import com.example.ecomarket.DOM.ProductDescriptionRequest;
import com.example.ecomarket.DOM.ProductTypeResponse;
import com.example.ecomarket.Models.ProductComment;
import com.example.ecomarket.Models.ProductDescription;
import com.example.ecomarket.Models.ProductType;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {
    private Long id;
    private String name;
    private String ownerComment;
    private String price;
    private Double rating;
    private ProductTypeDTO productTypeDTO;
    private CustomerDTO customerDTO;
    private ArrayList<ProductDescriptionRequest> productDescriptionRequests;
    private ArrayList<ProductCommentRequest> productCommentRequests;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public ArrayList<ProductDescriptionRequest> getProductDescriptionRequests() {
        return productDescriptionRequests;
    }

    public void setProductDescriptionRequests(ArrayList<ProductDescriptionRequest> productDescriptionRequests) {
        this.productDescriptionRequests = productDescriptionRequests;
    }

    public ArrayList<ProductCommentRequest> getProductCommentRequests() {
        return productCommentRequests;
    }

    public void setProductCommentRequests(ArrayList<ProductCommentRequest> productCommentRequests) {
        this.productCommentRequests = productCommentRequests;
    }

    public ProductTypeDTO getProductTypeDTO() {
        return productTypeDTO;
    }

    public void setProductTypeDTO(ProductTypeDTO productTypeDTO) {
        this.productTypeDTO = productTypeDTO;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }
}
