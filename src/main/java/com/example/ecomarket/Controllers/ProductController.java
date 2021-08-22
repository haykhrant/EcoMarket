package com.example.ecomarket.Controllers;

import com.example.ecomarket.DOM.CategoryRequest;
import com.example.ecomarket.DOM.CategoryResponse;
import com.example.ecomarket.DOM.ProductRequest;
import com.example.ecomarket.DOM.ProductResponse;
import com.example.ecomarket.Facade.CategoryFacade;
import com.example.ecomarket.Facade.ProductFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@CrossOrigin(origins = "http://localhost:8080" )
public class ProductController {
    private final ProductFacade productFacade;

    public ProductController(ProductFacade productFacade)
    {
        this.productFacade = productFacade;
    }

    @PostMapping("/product")
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest request) {
        ProductResponse saved = productFacade.create(request);
        return ResponseEntity.ok(saved);
    }
}
