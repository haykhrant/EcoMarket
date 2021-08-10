package com.example.ecomarket.Converters;

import com.example.ecomarket.DOM.CategoryRequest;
import com.example.ecomarket.DOM.CategoryResponse;
import com.example.ecomarket.DOM.ProductTypeRequest;
import com.example.ecomarket.DOM.ProductTypeResponse;
import com.example.ecomarket.Facade.DTO.CategoryDTO;
import com.example.ecomarket.Facade.DTO.ProductTypeDTO;
import com.example.ecomarket.anotations.Converter;

@Converter
public class ProductTypeConverter {
    public ProductTypeDTO productTypeDTOFromRequest(ProductTypeRequest request) {
        ProductTypeDTO productTypeDTO = new ProductTypeDTO();
        productTypeDTO.setProductTypeName(request.getProductTypeName());
        productTypeDTO.setCategoryDTO(request.getCategoryDTO());
        return productTypeDTO;
    }

    public ProductTypeResponse responseFromDTO(ProductTypeDTO dto){
        ProductTypeResponse response = new ProductTypeResponse();
        response.setId(dto.getId());
        response.setProductTypeName(dto.getProductTypeName());
        return response;
    }
}
