package com.example.ecomarket.Facade;

import com.example.ecomarket.Converters.CategoryConverter;
import com.example.ecomarket.Converters.ProductTypeConverter;
import com.example.ecomarket.DOM.CategoryRequest;
import com.example.ecomarket.DOM.CategoryResponse;
import com.example.ecomarket.DOM.ProductTypeRequest;
import com.example.ecomarket.DOM.ProductTypeResponse;
import com.example.ecomarket.Facade.DTO.CategoryDTO;
import com.example.ecomarket.Facade.DTO.ProductTypeDTO;
import com.example.ecomarket.Services.ICategoryService;
import com.example.ecomarket.Services.IProductTypeService;
import com.example.ecomarket.anotations.Facade;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Facade
public class ProductTypeFacade {
    private final ICategoryService iCategoryService;
    private final ProductTypeConverter productTypeConverter;
    private final IProductTypeService iProductTypeService;

    public ProductTypeFacade(ICategoryService iCategoryService,ProductTypeConverter productTypeConverter,IProductTypeService iProductTypeService)
    {
        this.iCategoryService = iCategoryService;
        this.iProductTypeService = iProductTypeService;
        this.productTypeConverter = productTypeConverter;
    }

    public ProductTypeResponse create(ProductTypeRequest request)
    {
        ProductTypeDTO productTypeDTO = iProductTypeService.create(productTypeConverter.productTypeDTOFromRequest(request));
        iCategoryService.addToList(productTypeConverter.productTypeDTOFromRequest(request));
        return productTypeConverter.responseFromDTO(productTypeDTO);
    }

    public ProductTypeResponse getById(Long id)
    {
        return productTypeConverter.responseFromDTO(iProductTypeService.getById(id));
    }

    public ArrayList<ProductTypeResponse> findAll()
    {
        ArrayList<ProductTypeDTO> all = iProductTypeService.findAll();
        List<ProductTypeResponse> responses = all.stream()
                .map(each -> productTypeConverter.responseFromDTO(each))
                .collect(Collectors.toList());
        return (ArrayList<ProductTypeResponse>) responses;
    }

    public ArrayList<ProductTypeResponse> findAllByCategoryId( Long id)
    {
        CategoryDTO categoryDTO = iCategoryService.getById(id);
        ArrayList<ProductTypeDTO> all = iProductTypeService.findAllByCategoryName(categoryDTO,categoryDTO.getCategoryName());
        List<ProductTypeResponse> responseModels = all.stream()
                .map(each -> productTypeConverter.responseFromDTO(each))
                .collect(Collectors.toList());
        return (ArrayList<ProductTypeResponse>) responseModels;
    }

    public ProductTypeResponse updateById(ProductTypeRequest request, Long id)
    {
        ProductTypeDTO dto = productTypeConverter.productTypeDTOFromRequest(request);
        dto.setId(id);
        ProductTypeDTO dataObject = iProductTypeService.updateById(dto);
        return productTypeConverter.responseFromDTO(iProductTypeService.updateById(dto));
    }

    public void deleteById(Long id)
    {
        iProductTypeService.deleteById(id);
        CategoryDTO categoryDTO = iProductTypeService.getById(id).getCategoryDTO();
        iCategoryService.deleteProductTypeFromList(categoryDTO.getId(),id);
    }
}
