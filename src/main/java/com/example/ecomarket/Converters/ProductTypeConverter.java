package com.example.ecomarket.Converters;

import com.example.ecomarket.DOM.CategoryRequest;
import com.example.ecomarket.DOM.CategoryResponse;
import com.example.ecomarket.DOM.ProductTypeRequest;
import com.example.ecomarket.DOM.ProductTypeResponse;
import com.example.ecomarket.Facade.DTO.CategoryDTO;
import com.example.ecomarket.Facade.DTO.ProductTypeDTO;
import com.example.ecomarket.Facade.ProductTypeFacade;
import com.example.ecomarket.Models.Category;
import com.example.ecomarket.Models.ProductType;
import com.example.ecomarket.Services.CategoryService;
import com.example.ecomarket.Services.ICategoryService;
import com.example.ecomarket.anotations.Converter;

import java.util.stream.Collectors;

@Converter
public class ProductTypeConverter {

    public ProductTypeDTO productTypeDTOFromRequest(ProductTypeRequest request,CategoryDTO categoryDTO) {

        ProductTypeDTO productTypeDTO = new ProductTypeDTO();
        productTypeDTO.setProductTypeName(request.getProductTypeName());
        productTypeDTO.setCategoryDTO(categoryDTO);
        return productTypeDTO;
    }

    public ProductTypeResponse responseFromDTO(ProductTypeDTO dto){
        ProductTypeResponse response = new ProductTypeResponse();
        response.setId(dto.getId());
        response.setProductTypeName(dto.getProductTypeName());
        return response;
    }

    public ProductTypeResponse responseFromModel(ProductType productType){
        ProductTypeResponse response = new ProductTypeResponse();
        response.setId(productType.getId());
        response.setProductTypeName(productType.getName());
        return response;
    }
}
