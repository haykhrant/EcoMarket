package com.example.ecomarket.Facade;

import com.example.ecomarket.Converters.CustomerConverter;
import com.example.ecomarket.Converters.ProductCommentConverter;
import com.example.ecomarket.Converters.ProductConverter;
import com.example.ecomarket.Converters.ProductTypeConverter;
import com.example.ecomarket.DOM.ProductCommentRequest;
import com.example.ecomarket.DOM.ProductDescriptionRequest;
import com.example.ecomarket.DOM.ProductRequest;
import com.example.ecomarket.DOM.ProductResponse;
import com.example.ecomarket.Facade.DTO.CustomerDTO;
import com.example.ecomarket.Facade.DTO.ProductDTO;
import com.example.ecomarket.Facade.DTO.ProductTypeDTO;
import com.example.ecomarket.Models.ProductComment;
import com.example.ecomarket.Models.ProductType;
import com.example.ecomarket.Repositories.IProductRepository;
import com.example.ecomarket.Services.ICustomerService;
import com.example.ecomarket.Services.IProductService;
import com.example.ecomarket.Services.IProductTypeService;
import com.example.ecomarket.Services.ProductTypeService;
import com.example.ecomarket.anotations.Facade;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Facade
public class ProductFacade {

    private final IProductService iProductService;
    private final ProductConverter productConverter;
    private final ProductTypeConverter productTypeConverter;
    private final ProductCommentConverter productCommentConverter;
    private final IProductTypeService iProductTypeService;
    private final ICustomerService iCustomerService;
    private final CustomerConverter customerConverter;

    public ProductFacade(IProductRepository iProductRepository,IProductService iProductService,ProductConverter productConverter,
                         ProductCommentConverter productCommentConverter,IProductTypeService iProductTypeService,
                         ICustomerService iCustomerService,ProductTypeConverter productTypeConverter,
                         CustomerConverter customerConverter){
        this.iProductTypeService = iProductTypeService;
        this.iProductService = iProductService;
        this.productConverter = productConverter;
        this.iCustomerService = iCustomerService;
        this.productCommentConverter = productCommentConverter;
        this.productTypeConverter = productTypeConverter;
        this.customerConverter = customerConverter;
    }

    public ProductResponse create(ProductRequest request)
    {
        CustomerDTO customerDTO = iCustomerService.getById(request.getCustomerId());
        ProductTypeDTO productTypeDTO = iProductTypeService.getById(request.getProductTypeId());
        ProductDTO productDTO = iProductService.create(productConverter.productDTOFromRequest(request,productTypeDTO,customerDTO));
        return productConverter.responseFromDTO(productDTO,productTypeConverter.responseFromDTO(productTypeDTO),
                customerConverter.buildResponseFromDTO(customerDTO));
    }

    public ArrayList<ProductResponse> getAll()
    {
        return (ArrayList<ProductResponse>)iProductService.getAll()
                .stream()
                .map(each -> productConverter.responseFromDTO(each,
                                productTypeConverter.responseFromDTO(each.getProductTypeDTO()),
                                customerConverter.buildResponseFromDTO(each.getCustomerDTO())))
                .collect(Collectors.toList());
    }

    public ProductResponse comment(ProductCommentRequest request)
    {
        ProductComment productComment = productCommentConverter.productCommentFromRequest(request);
        ProductDTO productDTO = iProductService.comment(productComment,iProductService.getById(request.getProductId()));
        return productConverter.responseFromDTO(productDTO,
                productTypeConverter.responseFromDTO(productDTO.getProductTypeDTO()),
                customerConverter.buildResponseFromDTO(productDTO.getCustomerDTO()));
    }
}
