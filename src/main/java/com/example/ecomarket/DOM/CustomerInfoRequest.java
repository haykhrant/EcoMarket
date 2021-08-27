package com.example.ecomarket.DOM;

public class CustomerInfoRequest {
    private String description;
    private CustomerResponse customerResponse;
    private AddressRequest adressRequest;

    //region Getters and Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CustomerResponse getCustomerResponse() {
        return customerResponse;
    }

    public void setCustomerResponse(CustomerResponse customerResponse) {
        this.customerResponse = customerResponse;
    }

    public AddressRequest getAdressRequest() {
        return adressRequest;
    }

    public void setAdressRequest(AddressRequest adressRequest) {
        this.adressRequest = adressRequest;
    }
    //endregion
}
