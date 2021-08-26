package com.example.ecomarket.Facade;

import com.example.ecomarket.Converters.ProductCommentConverter;
import com.example.ecomarket.Converters.ProductConverter;
import com.example.ecomarket.DOM.ProductCommentRequest;
import com.example.ecomarket.DOM.ProductDescriptionRequest;
import com.example.ecomarket.DOM.ProductRequest;
import com.example.ecomarket.DOM.ProductResponse;
import com.example.ecomarket.Facade.DTO.ProductDTO;
import com.example.ecomarket.Models.ProductComment;
import com.example.ecomarket.Repositories.IProductRepository;
import com.example.ecomarket.Services.IProductService;
import com.example.ecomarket.anotations.Facade;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Facade
public class ProductFacade {

    private final IProductRepository iProductRepository;
    private final IProductService iProductService;
    private final ProductConverter productConverter;
    private final ProductCommentConverter productCommentConverter;

    public ProductFacade(IProductRepository iProductRepository,IProductService iProductService,ProductConverter productConverter,
                         ProductCommentConverter productCommentConverter){
        this.iProductRepository = iProductRepository;
        this.iProductService = iProductService;
        this.productConverter = productConverter;
        this.productCommentConverter = productCommentConverter;
    }

    public ProductResponse create(ProductRequest request)
    {
        ProductDTO productDTO = iProductService.create(productConverter.productDTOFromRequest(request));
        return productConverter.responseFromDTO(productDTO);
    }

    public ArrayList<ProductResponse> getAll()
    {
        return (ArrayList<ProductResponse>)iProductService.getAll()
                .stream()
                .map(each -> productConverter.responseFromDTO(each))
                .collect(Collectors.toList());
    }

    public ProductResponse comment(ProductCommentRequest request)
    {
        ProductComment productComment = productCommentConverter.productCommentFromRequest(request);
        ProductDTO productDTO = iProductService.comment(productComment,iProductService.getById(request.getProductId()));
        return productConverter.responseFromDTO(productDTO);
    }
}
