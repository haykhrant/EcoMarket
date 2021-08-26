package com.example.ecomarket.Services;
import com.example.ecomarket.DOM.ProductCommentRequest;
import com.example.ecomarket.DOM.ProductDescriptionRequest;
import com.example.ecomarket.Facade.DTO.ProductDTO;
import com.example.ecomarket.Models.Product;
import com.example.ecomarket.Models.ProductComment;
import com.example.ecomarket.Models.ProductDescription;
import com.example.ecomarket.Repositories.IProductCommentRepository;
import com.example.ecomarket.Repositories.IProductDescriptionRepository;
import com.example.ecomarket.Repositories.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class ProductService extends GeneralService implements IProductService{
    private IProductRepository iProductRepository;
    private IProductDescriptionRepository iProductDescriptionRepository;
    private IProductCommentRepository iProductCommentRepository;
    public ProductService(IProductRepository iProductRepository,
                          IProductDescriptionRepository iProductDescriptionRepository,
                          IProductCommentRepository iProductCommentRepository) {
        this.iProductRepository = iProductRepository;
        this.iProductDescriptionRepository = iProductDescriptionRepository;
        this.iProductCommentRepository =  iProductCommentRepository;
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
    public ArrayList<ProductCommentRequest> getProductComments(Long id)
    {
        return (ArrayList<ProductCommentRequest>) iProductCommentRepository
                .findAllByProduct_Id(id)
                .stream()
                .map(each -> buildRequestFromProductComment(each))
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
                    each.setProductCommentRequests(getProductComments(each.getId()));
                    return each;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getById(Long id){
        return buildDtoFromProduct(iProductRepository.getById(id));
    }

    @Override
    public ProductDTO comment(ProductComment productComment, ProductDTO dto){
        productComment.setProduct(buildProductFromDto(dto));
        iProductCommentRepository.save(productComment);
        dto.setProductCommentRequests(getProductComments(dto.getId()));
        return dto;
    }
}
