package com.example.ecomarket.Services;

import com.example.ecomarket.Facade.DTO.CategoryDTO;
import com.example.ecomarket.Facade.DTO.ProductTypeDTO;
import com.example.ecomarket.Models.Category;
import com.example.ecomarket.Repositories.ICategoryRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CategoryService  extends GeneralService implements ICategoryService
{
    private final ICategoryRepository iCategoryRepository;

    public CategoryService(ICategoryRepository iCategoryRepository)
    {
        this.iCategoryRepository = iCategoryRepository;
    }

    @Override
    public CategoryDTO create(CategoryDTO dto)
    {
        Category category = buildCategoryFromDto(dto);
        return buildDtoFromCategory(iCategoryRepository.save(category));
    }

    @Override
    public CategoryDTO getById(Long id)
    {
        Category category = iCategoryRepository.getById(id);
        return buildDtoFromCategory(category);
    }

    @Override
    public ArrayList<CategoryDTO> findAll()
    {
        List<CategoryDTO> dataObjects = iCategoryRepository.findAll().stream()
                .map(each -> buildDtoFromCategory(each))
                .collect(Collectors.toList());
        return (ArrayList<CategoryDTO>) dataObjects;
    }

    @Override
    public ArrayList<CategoryDTO> findAllByName(String name)
    {
        List<CategoryDTO> dataObjects = iCategoryRepository.findAllByName(name)
                .stream()
                .map(each -> buildDtoFromCategory(each))
                .collect(Collectors.toList());
        return (ArrayList<CategoryDTO>) dataObjects;
    }

    @Override
    public CategoryDTO updateById(CategoryDTO dto)
    {
        Category byId = iCategoryRepository.getById(dto.getId());
        byId.setName(dto.getCategoryName());
        Category saved = iCategoryRepository.save(byId);
        return buildDtoFromCategory(saved);
    }

    @Override
    public void addToList(Long categoryId , ProductTypeDTO productTypeDTO)
    {
        Category category = iCategoryRepository.getById(categoryId);
        category.addIntoProductTypes(buildProductTypeFromDto(productTypeDTO));
        iCategoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id)
    {
        iCategoryRepository.deleteById(id);
    }

    @Override
    public void deleteProductTypeFromList(Long categoryId,Long productTypeId){
        Category byId = iCategoryRepository.getById(categoryId);
        byId.getProductTypeList().stream()
                .forEach(each -> {
                    if(each.getId() == productTypeId)
                        byId.getProductTypeList().remove(each);
                });
    }
}
