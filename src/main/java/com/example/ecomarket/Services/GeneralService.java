package com.example.ecomarket.Services;

import com.example.ecomarket.DOM.ProductTypeResponse;
import com.example.ecomarket.Facade.DTO.CategoryDTO;
import com.example.ecomarket.Facade.DTO.ProductDTO;
import com.example.ecomarket.Facade.DTO.ProductTypeDTO;
import com.example.ecomarket.Models.Category;
import com.example.ecomarket.Models.Product;
import com.example.ecomarket.Models.ProductType;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class GeneralService {
    protected Category buildCategoryFromDto(CategoryDTO dto) {
        Category category = new Category();
        category.setName(dto.getCategoryName());
        category.setId(dto.getId());
        if(dto.getProductTypeDTOS() != null && dto.getProductTypeDTOS().size() != 0) {
            category.setProductTypeList(dto.getProductTypeDTOS().stream().map(each -> buildProductTypeFromDto(each)).collect(Collectors.toList()));
        }
        return category;
    }

    protected CategoryDTO buildDtoFromCategory(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setCategoryName(category.getName());
        if(category.getProductTypeList() != null && category.getProductTypeList().size() != 0) {
            dto.setProductTypeDTOS((ArrayList<ProductTypeDTO>) category.getProductTypeList()
                    .stream().map(each -> buildDtoFromProductType(each)).collect(Collectors.toList()));
        }
        return dto;
    }

    protected ProductType buildProductTypeFromDto(ProductTypeDTO dto) {
        ProductType productType = new ProductType();
        productType.setName(dto.getProductTypeName());
        return productType;
    }

    protected ProductType buildProductTypeFromDtoByCategory(ProductTypeDTO productTypeDTO,CategoryDTO categoryDTO)
    {
        ProductType productType = buildProductTypeFromDto(productTypeDTO);
        productType.setCategory(buildCategoryFromDto(categoryDTO));
        return productType;
    }

    protected ProductTypeDTO buildDtoFromProductType(ProductType productType) {
        ProductTypeDTO dto = new ProductTypeDTO();
        dto.setId(productType.getId());
        dto.setProductTypeName(productType.getName());
        return dto;
    }

    protected Product buildProductFromDto(ProductDTO productDTO)
    {
        ProductType productType = new ProductType();
        productType.setId(productDTO.getProductTypeResponse().getId());
        productType.setName(productDTO.getProductTypeResponse().getProductTypeName());

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setOwnerComment(productDTO.getOwnerComment());
        product.setPrice(productDTO.getPrice());
        product.setRating(productDTO.getRating());
        product.setProductType(productType);
        product.setProductDescriptions(productDTO.getProductDescriptions());
        product.setProductComments(productDTO.getProductComments());
        return product;
    }

    protected ProductDTO buildDtoFromProduct(Product product)
    {
        ProductTypeResponse productTypeResponse = new ProductTypeResponse();
        productTypeResponse.setId(product.getId());
        productTypeResponse.setProductTypeName(product.getName());

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setOwnerComment(product.getOwnerComment());
        productDTO.setPrice(product.getPrice());
        productDTO.setRating(product.getRating());
        productDTO.setProductTypeResponse(productTypeResponse);
        productDTO.setProductDescriptions(product.getProductDescriptions());
        productDTO.setProductComments(product.getProductComments());
        return productDTO;
    }
}
