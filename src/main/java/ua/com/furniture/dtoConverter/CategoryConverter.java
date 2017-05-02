package ua.com.furniture.dtoConverter;

import org.springframework.stereotype.Component;
import ua.com.furniture.dto.CategoryDto;
import ua.com.furniture.entity.Category;
import ua.com.furniture.entity.Subcategory;

import java.util.List;

@Component
public class CategoryConverter {

    public CategoryDto convertEntityToDto(Category category) {
        int id = category.getId();
        String name = category.getName();
        List<Subcategory> subcategories = category.getSubcategories();
        return new CategoryDto(id, name, subcategories);
    }
}
