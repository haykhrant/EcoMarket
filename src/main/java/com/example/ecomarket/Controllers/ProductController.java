package com.example.ecomarket.Controllers;

import com.example.ecomarket.DOM.*;
import com.example.ecomarket.Facade.CategoryFacade;
import com.example.ecomarket.Facade.ProductFacade;
import com.example.ecomarket.Models.ProductComment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Component
@RestController
//@CrossOrigin(origins = "*" )
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

    @GetMapping("/subcategory/{id}/products")
    public ResponseEntity<ArrayList<ProductResponse>> getAllByProductTypeId(@PathVariable Long id) {
        ArrayList<ProductResponse> saved = productFacade.getAllByProductTypeId(id);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/person/{id}/products")
    public ResponseEntity<ArrayList<ProductResponse>> getAllByCustomerId(@PathVariable Long id) {
        ArrayList<ProductResponse> saved = productFacade.getAllByCustomerId(id);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/product/{id}/comment")
    public ResponseEntity<ProductCommentRequest> comment(@RequestBody ProductCommentRequest request) {
        ProductCommentRequest saved = productFacade.comment(request);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/product/{id}/comments")
    public ResponseEntity<ArrayList<ProductCommentRequest>> getComments(@PathVariable Long id) {
        ArrayList<ProductCommentRequest> result = productFacade.getComments(id);
        return ResponseEntity.ok(result);
    }

}
