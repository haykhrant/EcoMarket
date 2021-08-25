package com.example.ecomarket.Facade;

import com.example.ecomarket.Converters.CategoryConverter;
import com.example.ecomarket.Converters.ProductTypeConverter;
import com.example.ecomarket.DOM.CategoryProductTypesResponse;
import com.example.ecomarket.DOM.CategoryRequest;
import com.example.ecomarket.DOM.CategoryResponse;
import com.example.ecomarket.DOM.ProductTypeResponse;
import com.example.ecomarket.Facade.DTO.CategoryDTO;
import com.example.ecomarket.Services.ICategoryService;
import com.example.ecomarket.Services.IProductTypeService;
import com.example.ecomarket.anotations.Facade;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Facade
public class CategoryFacade {
    private final ICategoryService iCategoryService;
    private final CategoryConverter categoryConverter;
    private final ProductTypeConverter productTypeConverter;
    private final IProductTypeService iProductTypeService;

    public CategoryFacade(ICategoryService iCategoryService,CategoryConverter categoryConverter,
                          IProductTypeService iProductTypeService,ProductTypeConverter productTypeConverter)
    {
        this.iCategoryService = iCategoryService;
        this.iProductTypeService = iProductTypeService;
        this.productTypeConverter = productTypeConverter;
        this.categoryConverter = categoryConverter;
    }

    public CategoryResponse create(CategoryRequest request)
    {
        return categoryConverter.responseFromDTO(iCategoryService.create(categoryConverter.categoryDTOFromRequest(request)));
    }

    public CategoryResponse getById(Long id)
    {
        return categoryConverter.responseFromDTO(iCategoryService.getById(id));
    }

    public ArrayList<CategoryProductTypesResponse> findAll()
    {
        List<CategoryResponse> responses = iCategoryService.findAll()
                .stream()
                .map(each -> categoryConverter.responseFromDTO(each))
                .collect(Collectors.toList());

        ArrayList<CategoryProductTypesResponse> categoryProductTypesResponses = new ArrayList<>(responses.size());

        categoryProductTypesResponses.stream().map(each -> each = new CategoryProductTypesResponse());

        for(int i = 0 ; i < responses.size() ; i++) {
            CategoryProductTypesResponse any = new CategoryProductTypesResponse();
            any.setCategoryResponse(responses.get(i));
            any.setProductTypeResponses(
                    (ArrayList<ProductTypeResponse>) iProductTypeService.getProductTypesByCategoryId(responses.get(i).getId())
                            .stream()
                            .map(each -> productTypeConverter.responseFromDTO(each))
                            .collect(Collectors.toList())
            );
            categoryProductTypesResponses.add(any);
        }
        return categoryProductTypesResponses;
    }

    public ArrayList<CategoryResponse> findAllByName(String name)
    {
        ArrayList<CategoryDTO> all = iCategoryService.findAllByName(name);
        List<CategoryResponse> responseModels = all.stream()
                .map(each -> categoryConverter.responseFromDTO(each))
                .collect(Collectors.toList());
        return (ArrayList<CategoryResponse>) responseModels;
    }

    public CategoryResponse updateById(CategoryRequest request, Long id)
    {
        CategoryDTO dto = categoryConverter.categoryDTOFromRequest(request);
        dto.setId(id);
        CategoryDTO dataObject = iCategoryService.updateById(dto);
        return categoryConverter.responseFromDTO(iCategoryService.updateById(dto));
    }

    public void deleteById(Long id)
    {
        iCategoryService.deleteById(id);
        CategoryDTO categoryDTO = iCategoryService.getById(id);
    }

    public ArrayList<ProductTypeResponse> getProductTypesBYCategoryId(Long id) {
        return (ArrayList<ProductTypeResponse>)iProductTypeService.getProductTypesByCategoryId(id)
                .stream()
                .map(each -> productTypeConverter.responseFromDTO(each))
                .collect(Collectors.toList());
    }
}
