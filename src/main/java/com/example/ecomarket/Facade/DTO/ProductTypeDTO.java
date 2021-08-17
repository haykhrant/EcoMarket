package com.example.ecomarket.Facade.DTO;

public class ProductTypeDTO {
    private Long id;
    private String productTypeName;

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }


}
