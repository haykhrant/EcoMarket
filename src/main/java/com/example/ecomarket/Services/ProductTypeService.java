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
        List<ProductTypeDTO> dataObjects = new ArrayList<>();
        for (ProductType each : iProductTypeRepository
                .findAllByCategoryAndName(buildCategoryFromDto(categoryDTO), name)) {
            ProductType productType = buildProductTypeFromDtoByCategory(buildDtoFromProductType(each), categoryDTO);
            dataObjects.add(buildDtoFromProductType(productType));
        }
        return (ArrayList<ProductTypeDTO>) dataObjects;
    }

    @Override
    public ArrayList<ProductTypeDTO> getProductTypesByCategoryId(Long id)
    {
        return (ArrayList<ProductTypeDTO>)iProductTypeRepository.getProductTypesByCategoryId(id)
                .stream().map(each -> buildDtoFromProductType(each))
                .collect(Collectors.toList());
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
                .stream().map(each -> buildProductTypeFromDtoByCategory(each,categoryDTO))
                .collect(Collectors.toList()));
    }

}
