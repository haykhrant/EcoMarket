package com.example.ecomarket.Services;

import com.example.ecomarket.Facade.DTO.ProductDTO;

public interface IProductService {
    ProductDTO create(ProductDTO dto);

    void addDescription(ProductDTO dto, String description);

    void addComment(ProductDTO dto, String comment);
}
