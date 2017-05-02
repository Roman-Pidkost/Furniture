package ua.com.furniture.service;

import ua.com.furniture.dto.CategoryDto;
import ua.com.furniture.entity.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);
    List<CategoryDto> findAll();
    Category findOne(int id);
    void delete(int id);
}
