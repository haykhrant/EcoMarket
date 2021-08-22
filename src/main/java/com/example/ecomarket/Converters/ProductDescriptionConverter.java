package com.example.ecomarket.Converters;

import com.example.ecomarket.DOM.ProductDescriptionRequest;
import com.example.ecomarket.DOM.ProductRequest;
import com.example.ecomarket.Facade.DTO.ProductDTO;
import com.example.ecomarket.Models.ProductDescription;
import com.example.ecomarket.anotations.Converter;

@Converter
public class ProductDescriptionConverter {
    public ProductDescription productDescriptionFromRequest(ProductDescriptionRequest request) {
        ProductDescription productDescription = new ProductDescription();
        productDescription.setDescription(request.getDescription());
        return productDescription;
    }
}
