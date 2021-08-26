package com.example.ecomarket.DOM;

public class CustomerInfoResponse {
    private Long id;
    private String description;
    private Double rating;
    private CustomerResponse customerResponse;
    private AddressResponse addressResponse;

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

    public AddressResponse getAdressResponse() {
        return addressResponse;
    }

    public void setAdressResponse(AddressResponse adressResponse) {
        this.addressResponse = adressResponse;
    }
    //endregion
}
