package com.example.ecomarket.Services;
import com.example.ecomarket.DOM.ProductDescriptionRequest;
import com.example.ecomarket.Facade.DTO.ProductDTO;
import com.example.ecomarket.Models.Product;
import com.example.ecomarket.Models.ProductComment;
import com.example.ecomarket.Models.ProductDescription;
import com.example.ecomarket.Repositories.IProductDescriptionRepository;
import com.example.ecomarket.Repositories.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class ProductService extends GeneralService implements IProductService{
    private IProductRepository iProductRepository;
    private IProductDescriptionRepository iProductDescriptionRepository;
    public ProductService(IProductRepository iProductRepository,IProductDescriptionRepository iProductDescriptionRepository) {
        this.iProductRepository = iProductRepository;
        this.iProductDescriptionRepository = iProductDescriptionRepository;
    }

    @Override
    public ProductDTO create(ProductDTO dto)
    {
        Product product = iProductRepository.save(buildProductFromDto(dto));
        iProductDescriptionRepository.saveAll(dto.getProductDescriptionRequests()
                .stream()
                .map(each ->{
                    ProductDescription productDescription = buildProductDescriptionFromRequest(each);
                    productDescription.setProduct(product);
                    return productDescription;
                })
                .collect(Collectors.toList()));
        return buildDtoFromProduct(product);
    }

    @Override
    public ArrayList<ProductDescriptionRequest> getProductDescriptions(Long id)
    {
        return (ArrayList<ProductDescriptionRequest>) iProductDescriptionRepository
                .findAllByProduct_Id(id)
                .stream()
                .map(each -> buildRequestFromProductDescription(each))
                .collect(Collectors.toList());
    }

    @Override
    public ArrayList<ProductDTO> getAll()
    {
        return  (ArrayList<ProductDTO>)iProductRepository
                .findAll()
                .stream()
                .map(each -> buildDtoFromProduct(each))
                .collect(Collectors.toList())
                .stream()
                .map(each -> {
                    each.setProductDescriptionRequests(getProductDescriptions(each.getId()));
                    return each;
                })
                .collect(Collectors.toList());
    }

}
