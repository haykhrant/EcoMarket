package com.example.ecomarket.Controllers;

import com.example.ecomarket.DOM.CategoryProductTypesResponse;
import com.example.ecomarket.DOM.CategoryRequest;
import com.example.ecomarket.DOM.CategoryResponse;
import com.example.ecomarket.DOM.ProductTypeResponse;
import com.example.ecomarket.Facade.CategoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.ArrayList;

@Component
@RestController
//@CrossOrigin(origins = "*" )
public class CategoryController {


    private final CategoryFacade categoryFacade;

    public CategoryController(CategoryFacade categoryFacade)
    {
        this.categoryFacade = categoryFacade;
    }

    @PostMapping("/category")
    public ResponseEntity<CategoryResponse> create(@RequestBody CategoryRequest request) {
        CategoryResponse saved = categoryFacade.create(request);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryResponse> getById(@PathVariable Long id) {
        CategoryResponse byId = categoryFacade.getById(id);
        return ResponseEntity.ok(byId);
    }

    @GetMapping("/categories")
    public ResponseEntity<ArrayList<CategoryProductTypesResponse>> getAll() {
        ArrayList<CategoryProductTypesResponse> all = categoryFacade.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/category/{id}/subcategories")
    public ResponseEntity<ArrayList<ProductTypeResponse>> getProductTypesBYCategoryId(@PathVariable Long id) {
        ArrayList<ProductTypeResponse> all = categoryFacade.getProductTypesBYCategoryId(id);
        return ResponseEntity.ok(all);
    }

    @GetMapping("/category/name/{name}")
    public ResponseEntity<ArrayList<CategoryResponse>> getByName(@PathVariable String name) {
        ArrayList<CategoryResponse> allByName = categoryFacade.findAllByName(name);
        return ResponseEntity.ok(allByName);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<CategoryResponse> updateById(@RequestBody CategoryRequest request,@PathVariable Long id){
        CategoryResponse updatedById = categoryFacade.updateById(request, id);
        return ResponseEntity.ok(updatedById);
    }

    @DeleteMapping("/category/{id}")
    public void deleteById(@PathVariable Long id){
        categoryFacade.deleteById(id);
    }

}
