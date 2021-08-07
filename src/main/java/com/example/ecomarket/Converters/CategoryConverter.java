package com.example.ecomarket.Converters;

import com.example.ecomarket.DOM.CategoryRequest;
import com.example.ecomarket.DOM.CategoryResponse;
import com.example.ecomarket.Facade.DTO.CategoryDTO;
import com.example.ecomarket.anotations.Converter;
import org.springframework.stereotype.Component;


@Converter
public class CategoryConverter {
    public CategoryDTO categoryDTOFromRequest(CategoryRequest request) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryName(request.getCategoryName());
        return categoryDTO;
    }

    public CategoryResponse responseFromDTO(CategoryDTO dto){
        CategoryResponse response = new CategoryResponse();
        response.setId(dto.getId());
        response.setCategoryName(dto.getCategoryName());
        return response;
    }
}
