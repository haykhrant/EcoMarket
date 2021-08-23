package com.example.ecomarket.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<ProductType> productTypeList;

    public Category() {
        productTypeList = new ArrayList<>();
    }

    public Category(String name, List<ProductType> productTypeList) {
        this.name = name;
        this.productTypeList = productTypeList;
    }

    public void addIntoProductTypes(ProductType productType){
        productTypeList.add(productType);
    }

    public void deleteFromProductTypes(ProductType productType){
        productTypeList.removeIf(t -> t.getCategory() == productType.getCategory());
    }

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

    public List<ProductType> getProductTypeList() {
        return productTypeList;
    }

    public void setProductTypeList(List<ProductType> productTypeList) {
        this.productTypeList = productTypeList;
    }
}
