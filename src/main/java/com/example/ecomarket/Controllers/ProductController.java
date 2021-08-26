package com.example.ecomarket.Controllers;

import com.example.ecomarket.DOM.*;
import com.example.ecomarket.Facade.CategoryFacade;
import com.example.ecomarket.Facade.ProductFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Component
@RestController
@CrossOrigin(origins = "*" )
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

    @GetMapping("/products")
    public ResponseEntity<ArrayList<ProductResponse>> getAll()
    {
        ArrayList<ProductResponse> saved = productFacade.getAll();
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/product/{id}/comment")
    public ResponseEntity<ProductResponse> comment(@RequestBody ProductCommentRequest request) {
            ProductResponse saved = productFacade.comment(request);
        return ResponseEntity.ok(saved);
    }

}
