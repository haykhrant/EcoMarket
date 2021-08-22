package com.example.ecomarket.Facade;

import com.example.ecomarket.Converters.ProductConverter;
import com.example.ecomarket.DOM.CategoryProductTypeRequest;
import com.example.ecomarket.DOM.ProductRequest;
import com.example.ecomarket.DOM.ProductResponse;
import com.example.ecomarket.DOM.ProductTypeResponse;
import com.example.ecomarket.Facade.DTO.ProductDTO;
import com.example.ecomarket.Facade.DTO.ProductTypeDTO;
import com.example.ecomarket.Repositories.IProductRepository;
import com.example.ecomarket.Services.IProductService;
import com.example.ecomarket.anotations.Facade;

import javax.transaction.Transactional;

@Facade
@Transactional
public class ProductFacade {

    private IProductRepository iProductRepository;
    private IProductService iProductService;
    private ProductConverter productConverter;

    public ProductResponse create(ProductRequest request)
    {
        ProductDTO productDTO = iProductService.create(productConverter.productDTOFromRequest(request));
        return productConverter.responseFromDTO(productDTO);
    }
}
