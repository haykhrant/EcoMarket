package com.example.ecomarket.Services;

import com.example.ecomarket.Facade.DTO.CategoryDTO;
import com.example.ecomarket.Facade.DTO.ProductTypeDTO;
import com.example.ecomarket.Models.Category;
import com.example.ecomarket.Models.ProductType;
import com.example.ecomarket.Repositories.IProductTypeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductTypeService extends GeneralService implements IProductTypeService{

    private final IProductTypeRepository iProductTypeRepository;

    public ProductTypeService(IProductTypeRepository iProductTypeRepository) {
        this.iProductTypeRepository = iProductTypeRepository;
    }

    @Override
    public ProductTypeDTO create(ProductTypeDTO dto)
    {
        ProductType productType = buildProductTypeFromDto(dto);
        return buildDtoFromProductType(iProductTypeRepository.save(productType));
    }

    @Override
    public ProductTypeDTO getById(Long id)
    {
        ProductType productType = iProductTypeRepository.getById(id);
        return buildDtoFromProductType(productType);
    }

    @Override
    public ArrayList<ProductTypeDTO> findAll()
    {
        List<ProductTypeDTO> dataObjects = iProductTypeRepository.findAll().stream()
                .map(each -> buildDtoFromProductType(each))
                .collect(Collectors.toList());
        return (ArrayList<ProductTypeDTO>) dataObjects;
    }

    @Override
    public ArrayList<ProductTypeDTO> findAllByCategoryName(CategoryDTO categoryDTO,String name)
    {
        List<ProductTypeDTO> dataObjects = iProductTypeRepository
                .findAllByCategoryAndName(buildCategoryFromDto(categoryDTO),name)
                .stream().map(each -> buildDtoFromProductType(each))
                .collect(Collectors.toList());
        return (ArrayList<ProductTypeDTO>) dataObjects;
    }

    @Override
    public ProductTypeDTO updateById(ProductTypeDTO dto)
    {
        ProductType productType = iProductTypeRepository.getById(dto.getId());
        productType.setName(dto.getProductTypeName());
        ProductType saved = iProductTypeRepository.save(productType);
        return buildDtoFromProductType(saved);
    }

    @Override
    public void deleteById(Long id)
    {
        iProductTypeRepository.deleteById(id);
    }

    @Override
    public void deleteAllByCategory(CategoryDTO categoryDTO,String name)
    {
        iProductTypeRepository.deleteAll(findAllByCategoryName(categoryDTO,name)
                .stream().map(each -> buildProductTypeFromDto(each))
                .collect(Collectors.toList()));
    }

}
