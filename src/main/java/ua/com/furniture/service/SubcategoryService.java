package ua.com.furniture.service;

import ua.com.furniture.dto.SubcategoryDto;
import ua.com.furniture.dto.SubcategoryDtoForSaveAndUpdate;
import ua.com.furniture.entity.Subcategory;

import java.util.List;

public interface SubcategoryService {
    Subcategory save(SubcategoryDtoForSaveAndUpdate subcategoryDtoForSaveAndUpdate);
    Subcategory save(Subcategory subcategory);
    List<SubcategoryDto> findAll();
    Subcategory findOne(int id);
    void delete(int id);
}
