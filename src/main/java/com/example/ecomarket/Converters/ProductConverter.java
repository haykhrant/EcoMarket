package com.example.ecomarket.Converters;

import com.example.ecomarket.DOM.*;
import com.example.ecomarket.Facade.DTO.CustomerDTO;
import com.example.ecomarket.Facade.DTO.ProductDTO;
import com.example.ecomarket.Facade.DTO.ProductTypeDTO;
import com.example.ecomarket.Models.ProductType;
import com.example.ecomarket.anotations.Converter;

import java.util.stream.Collectors;

@Converter
public class ProductConverter {

    public ProductDTO productDTOFromRequest(ProductRequest request, ProductTypeDTO productTypeDTO, CustomerDTO customerDTO) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(request.getName());
        productDTO.setProductTypeDTO(productTypeDTO);
        productDTO.setOwnerComment(request.getOwnerComment());
        productDTO.setPrice(request.getPrice());
        productDTO.setProductTypeDTO(productTypeDTO);
        productDTO.setCustomerDTO(customerDTO);
        productDTO.setProductDescriptionRequests(request.getDescriptionRequests());
        return productDTO;
    }

    public ProductResponse responseFromDTO(ProductDTO dto, ProductTypeResponse productTypeResponse, CustomerResponse customerResponse){
        ProductResponse response = new ProductResponse();
        response.setId(dto.getId());
        response.setName(dto.getName());
        response.setPrice(dto.getPrice());
        response.setRating(dto.getRating());
        response.setOwnerComment(dto.getOwnerComment());
        response.setProductTypeResponse(productTypeResponse);
        response.setCustomerResponse(customerResponse);
        response.setProductDescriptionRequestArrayList(dto.getProductDescriptionRequests());
        return response;
    }


}
