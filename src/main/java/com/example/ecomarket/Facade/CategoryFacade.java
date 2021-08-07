package com.example.ecomarket.Facade;

import com.example.ecomarket.Converters.CategoryConverter;
import com.example.ecomarket.DOM.CategoryRequest;
import com.example.ecomarket.DOM.CategoryResponse;
import com.example.ecomarket.Services.CategoryService;
import com.example.ecomarket.anotations.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Facade
public class CategoryFacade {
    private final CategoryService categoryService;
    private final CategoryConverter categoryConverter;

    public CategoryFacade(CategoryService service,CategoryConverter converter)
    {
        categoryService = service;
        categoryConverter = converter;
    }

    public CategoryResponse create(CategoryRequest request) {
        return new CategoryResponse();
    }

    public CategoryResponse getById(Long id) {
        return new CategoryResponse();
    }

    public ArrayList<CategoryResponse> findAll() {
        return new ArrayList<>();
    }

    public ArrayList<CategoryResponse> findAllByName(String name) {
        return new ArrayList<>();
    }

    public CategoryResponse updateById(CategoryRequest request, Long id) {
        return new CategoryResponse();
    }

    public void deleteById(Long id) {

    }
}
