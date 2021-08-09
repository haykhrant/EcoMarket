package com.example.ecomarket.Controllers;

import com.example.ecomarket.DOM.CategoryRequest;
import com.example.ecomarket.DOM.CategoryResponse;
import com.example.ecomarket.DOM.ProductTypeRequest;
import com.example.ecomarket.DOM.ProductTypeResponse;
import com.example.ecomarket.Facade.ProductTypeFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Component
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ProductTypeController {

    private final ProductTypeFacade productTypeFacade;

    public ProductTypeController(ProductTypeFacade productTypeFacade)
    {
        this.productTypeFacade = productTypeFacade;
    }

    @PostMapping("/subcategory")
    public ResponseEntity<ProductTypeResponse> create(@RequestBody ProductTypeRequest request) {
        ProductTypeResponse saved = productTypeFacade.create(request);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/subcategory/{id}")
    public ResponseEntity<ProductTypeResponse> getById(@PathVariable Long id) {
        ProductTypeResponse byId = productTypeFacade.getById(id);
        return ResponseEntity.ok(byId);
    }

    @GetMapping("/subcategories")
    public ResponseEntity<ArrayList<ProductTypeResponse>> getAll() {
        ArrayList<ProductTypeResponse> all = productTypeFacade.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/subcategory/name/{id}")
    public ResponseEntity<ArrayList<ProductTypeResponse>> getByCategory(@PathVariable Long id) {
        ArrayList<ProductTypeResponse> allByName = productTypeFacade.findAllByCategoryId(id);
        return ResponseEntity.ok(allByName);
    }

    @PutMapping("/subcategory/{id}")
    public ResponseEntity<ProductTypeResponse> updateById(@RequestBody ProductTypeRequest request, @PathVariable Long id){
        ProductTypeResponse updatedById = productTypeFacade.updateById(request, id);
        return ResponseEntity.ok(updatedById);
    }

    @DeleteMapping("/subcategory/{id}")
    public void deleteById(@PathVariable Long id){
        productTypeFacade.deleteById(id);
    }
}
