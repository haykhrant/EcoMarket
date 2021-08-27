package com.example.ecomarket.Facade.DTO;

import com.example.ecomarket.DOM.AddressRequest;
import com.example.ecomarket.DOM.CustomerResponse;

public class CustomerInfoDTO {
    private Long id;
    private String description;
    private Double rating;
    private CustomerResponse customerResponse;
    private AddressDTO addressDTO;

    //region Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public CustomerResponse getCustomerResponse() {
        return customerResponse;
    }

    public void setCustomerResponse(CustomerResponse customerResponse) {
        this.customerResponse = customerResponse;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    //endregion
}
