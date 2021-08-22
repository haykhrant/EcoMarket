package com.example.ecomarket.Converters;

import com.example.ecomarket.DOM.ProductRequest;
import com.example.ecomarket.DOM.ProductResponse;
import com.example.ecomarket.DOM.ProductTypeRequest;
import com.example.ecomarket.DOM.ProductTypeResponse;
import com.example.ecomarket.Facade.DTO.ProductDTO;
import com.example.ecomarket.Facade.DTO.ProductTypeDTO;
import com.example.ecomarket.anotations.Converter;

import java.util.stream.Collectors;

@Converter
public class ProductConverter {

    private ProductDescriptionConverter productDescriptionConverter;

    public ProductDTO productDTOFromRequest(ProductRequest request) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(request.getName());
        productDTO.setProductTypeResponse(request.getProductTypeResponse());
        productDTO.setOwnerComment(request.getOwnerComment());
        productDTO.setPrice(request.getPrice());
        productDTO.setProductDescriptions(request.getProductDescriptions()
                .stream()
                .map(each -> productDescriptionConverter.productDescriptionFromRequest(each))
                .collect(Collectors.toList()));
        return productDTO;
    }

    public ProductResponse responseFromDTO(ProductDTO dto){
        ProductResponse response = new ProductResponse();
        response.setId(dto.getId());
        response.setName(dto.getName());
        response.setPrice(dto.getPrice());
        response.setRating(dto.getRating());
        response.setOwnerComment(dto.getOwnerComment());
        response.setProductTypeResponse(dto.getProductTypeResponse());
        response.setProductDescriptions(dto.getProductDescriptions());
        response.setProductComments(dto.getProductComments());
        return response;
    }
}
