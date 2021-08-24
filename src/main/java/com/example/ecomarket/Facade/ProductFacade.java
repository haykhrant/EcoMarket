package com.example.ecomarket.Facade;

import com.example.ecomarket.Converters.ProductConverter;
import com.example.ecomarket.DOM.ProductDescriptionRequest;
import com.example.ecomarket.DOM.ProductRequest;
import com.example.ecomarket.DOM.ProductResponse;
import com.example.ecomarket.Facade.DTO.ProductDTO;
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

    public ProductFacade(IProductRepository iProductRepository,IProductService iProductService,ProductConverter productConverter){
        this.iProductRepository = iProductRepository;
        this.iProductService = iProductService;
        this.productConverter = productConverter;
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

    public ArrayList<ProductDescriptionRequest> getProductDescriptionRequests(Long id)
    {
        return iProductService.getProductDescriptions(id);
    }
}
