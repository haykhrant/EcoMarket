package com.example.ecomarket.Converters;

import com.example.ecomarket.DOM.CategoryRequest;
import com.example.ecomarket.DOM.CategoryResponse;
import com.example.ecomarket.DOM.ProductTypeResponse;
import com.example.ecomarket.Facade.DTO.CategoryDTO;
import com.example.ecomarket.anotations.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;


@Converter
public class CategoryConverter {
    public CategoryDTO categoryDTOFromRequest(CategoryRequest request) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryName(request.getCategoryName());
        categoryDTO.setProductTypeDTOS(request.getProductTypeDTOS());
        return categoryDTO;
    }

    public CategoryResponse responseFromDTO(CategoryDTO dto){
        CategoryResponse response = new CategoryResponse();
        response.setId(dto.getId());
        response.setCategoryName(dto.getCategoryName());
        response.setProductTypeResponses((ArrayList<ProductTypeResponse>)
                dto.getProductTypeDTOS().stream()
                        .map(each -> new ProductTypeConverter().responseFromDTO(each))
                        .collect(Collectors.toList()));
        return response;
    }
}
