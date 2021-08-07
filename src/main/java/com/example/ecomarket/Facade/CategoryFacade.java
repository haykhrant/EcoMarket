package com.example.ecomarket.Facade;

import com.example.ecomarket.DOM.CategoryRequest;
import com.example.ecomarket.DOM.CategoryResponse;
import com.example.ecomarket.anotations.Facade;

import java.util.ArrayList;

@Facade
public class CategoryFacade {
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
