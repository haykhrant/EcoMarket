package com.example.ecomarket.Services;

import com.example.ecomarket.DOM.ProductDescriptionRequest;
import com.example.ecomarket.Facade.DTO.ProductDTO;

import java.util.ArrayList;

public interface IProductService {
    ProductDTO create(ProductDTO dto);

    ArrayList<ProductDescriptionRequest> getProductDescriptions(Long id);

    ArrayList<ProductDTO> getAll();
}
