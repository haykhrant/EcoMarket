package com.example.ecomarket.Services;

import com.example.ecomarket.Converters.CustomerConverter;
import com.example.ecomarket.Converters.CustomerInfoConverter;
import com.example.ecomarket.DOM.ProductCommentRequest;
import com.example.ecomarket.DOM.ProductDescriptionRequest;
import com.example.ecomarket.DOM.ProductTypeResponse;
import com.example.ecomarket.Facade.DTO.*;
import com.example.ecomarket.Models.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class GeneralService {
    protected Category buildCategoryFromDto(CategoryDTO dto) {
        Category category = new Category();
        category.setId(dto.getId());
        category.setName(dto.getCategoryName());
        return category;
    }

    protected CategoryDTO buildDtoFromCategory(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setCategoryName(category.getName());
        return dto;
    }

    protected ProductType buildProductTypeFromDto(ProductTypeDTO dto) {
        ProductType productType = new ProductType();
        productType.setId(dto.getId());
        productType.setName(dto.getProductTypeName());
        productType.setCategory(buildCategoryFromDto(dto.getCategoryDTO()));
        return productType;
    }

    protected ProductTypeDTO buildDtoFromProductType(ProductType productType) {
        ProductTypeDTO dto = new ProductTypeDTO();
        dto.setId(productType.getId());
        dto.setProductTypeName(productType.getName());
        dto.setCategoryDTO(buildDtoFromCategory(productType.getCategory()));
        return dto;
    }

    protected Product buildProductFromDto(ProductDTO productDTO)
    {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setOwnerComment(productDTO.getOwnerComment());
        product.setPrice(productDTO.getPrice());
        product.setRating(productDTO.getRating());
        product.setProductType(buildProductTypeFromDto(productDTO.getProductTypeDTO()));
        product.setCustomer(customerFromDTO(productDTO.getCustomerDTO()));
        return product;
    }

    protected ProductDTO buildDtoFromProduct(Product product)
    {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setOwnerComment(product.getOwnerComment());
        productDTO.setPrice(product.getPrice());
        productDTO.setRating(product.getRating());
        productDTO.setProductTypeDTO(buildDtoFromProductType(product.getProductType()));
        productDTO.setCustomerDTO(dtoFromCustomer(product.getCustomer()));
        return productDTO;
    }

    protected ProductDescription buildProductDescriptionFromRequest(ProductDescriptionRequest request){
        ProductDescription productDescription = new ProductDescription();
        productDescription.setDescription(request.getDescription());
        return productDescription;
    }

    protected ProductDescriptionRequest buildRequestFromProductDescription(ProductDescription productDescription){
        ProductDescriptionRequest productDescriptionRequest = new ProductDescriptionRequest();
        productDescriptionRequest.setDescription(productDescription.getDescription());
        return productDescriptionRequest;
    }

    protected ProductCommentRequest buildRequestFromProductComment(ProductComment productComment){
        ProductCommentRequest productCommentRequest = new ProductCommentRequest();
        productCommentRequest.setComment(productComment.getComment());
        return productCommentRequest;
    }

    protected Customer customerFromDTO(CustomerDTO customerDTO) {
        Customer customer=new Customer();
        customer.setId(customerDTO.getId());
        customer.setFullname(customerDTO.getFullname());
        customer.setUsername(customerDTO.getUsername());
        customer.setPassword(customerDTO.getPassword());
        customer.setRole("USER");

        return customer;
    }

    protected CustomerDTO dtoFromCustomer(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setFullname(customer.getFullname());
        customerDTO.setUsername(customer.getUsername());
        customerDTO.setPassword(customer.getPassword());

        return customerDTO;
    }

    protected  CustomerInfo customerInfoFromDTO(CustomerInfoDTO customerInfoDTO){

        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setDescription(customerInfoDTO.getDescription());
        customerInfo.setCustomer(customerFromDTO(customerInfoDTO.getCustomerDTO()));
        customerInfo.setAdress(addressFromDTO(customerInfoDTO.getAddressDTO()));
        customerInfo.setRating(customerInfoDTO.getRating());
        customerInfo.setId(customerInfo.getId());
        return customerInfo;
    }

    protected  CustomerInfoDTO dtoFromCustomerInfo(CustomerInfo customerInfo){
        CustomerInfoDTO customerInfoDTO = new CustomerInfoDTO();
        customerInfoDTO.setCustomerDTO(dtoFromCustomer(customerInfo.getCustomer()));
        customerInfoDTO.setRating(customerInfo.getRating());
        customerInfoDTO.setAddressDTO(dtoFromAddress(customerInfo.getAddress()));
        customerInfoDTO.setId(customerInfo.getId());
        customerInfoDTO.setDescription(customerInfo.getDescription());

        return customerInfoDTO;
    }

    protected Address addressFromDTO(AddressDTO addressDTO){
        Address address=new Address();
        address.setId(addressDTO.getId());
        address.setRegion(addressDTO.getRegion());
        address.setCity(addressDTO.getCity());
        address.setStreet(addressDTO.getStreet());
        address.setHouse(addressDTO.getHouse());

        return address;
    }

    protected AddressDTO dtoFromAddress(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(addressDTO.getId());
        addressDTO.setRegion(addressDTO.getRegion());
        addressDTO.setCity(addressDTO.getCity());
        addressDTO.setHouse(addressDTO.getHouse());
        addressDTO.setStreet(addressDTO.getStreet());

        return addressDTO;
    }
}
