package com.example.ecomarket.Converters;

import com.example.ecomarket.DOM.ProductCommentRequest;
import com.example.ecomarket.DOM.ProductDescriptionRequest;
import com.example.ecomarket.Models.ProductComment;
import com.example.ecomarket.Models.ProductDescription;
import com.example.ecomarket.anotations.Converter;

@Converter
public class ProductCommentConverter {
    public ProductComment productCommentFromRequest(ProductCommentRequest request) {
        ProductComment productComment = new ProductComment();
        productComment.setComment(request.getComment());
        return productComment;
    }
}