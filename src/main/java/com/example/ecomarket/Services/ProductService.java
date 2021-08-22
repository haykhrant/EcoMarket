package com.example.ecomarket.Services;
import com.example.ecomarket.Facade.DTO.ProductDTO;
import com.example.ecomarket.Models.Product;
import com.example.ecomarket.Models.ProductComment;
import com.example.ecomarket.Models.ProductDescription;
import com.example.ecomarket.Repositories.IProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends GeneralService implements IProductService{
    private IProductRepository iProductRepository;
    public ProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    @Override
    public ProductDTO create(ProductDTO dto)
    {
        Product product = buildProductFromDto(dto);
        return buildDtoFromProduct(iProductRepository.save(product));
    }

    @Override
    public void addDescription(ProductDTO dto, String description){
        Product product = buildProductFromDto(dto);
        ProductDescription productDescription = new ProductDescription();
        productDescription.setProduct(product);
        productDescription.setDescription(description);
        product.addIntoDescriptions(productDescription);
        iProductRepository.save(product);
    }

    @Override
    public void addComment(ProductDTO dto, String comment){
        Product product = buildProductFromDto(dto);
        ProductComment productComment = new ProductComment();
        productComment.setProduct(product);
        productComment.setComment(comment);
        product.addIntoComments(productComment);
        iProductRepository.save(product);
    }
}
