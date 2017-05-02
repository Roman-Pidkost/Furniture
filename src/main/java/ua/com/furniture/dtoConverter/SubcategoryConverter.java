package ua.com.furniture.dtoConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.furniture.dto.SubcategoryDto;
import ua.com.furniture.dto.SubcategoryDtoForSaveAndUpdate;
import ua.com.furniture.entity.Category;
import ua.com.furniture.entity.Subcategory;
import ua.com.furniture.service.CategoryService;

@Component
public class SubcategoryConverter {

    @Autowired
    private CategoryService categoryService;

    public Subcategory convertDtoToEntity(SubcategoryDtoForSaveAndUpdate subcategoryDtoForSaveAndUpdate) {
        int categoryId = subcategoryDtoForSaveAndUpdate.getCategoryId();
        Category category = categoryService.findOne(categoryId);
        String name = subcategoryDtoForSaveAndUpdate.getName();
        int id = subcategoryDtoForSaveAndUpdate.getId();
        if (id == 0) {
            return new Subcategory(name, category);
        } else {
            return new Subcategory(id, name, category, null);
        }
    }

    public SubcategoryDto convertEntityToDto(Subcategory subcategory) {
        int id = subcategory.getId();
        String name = subcategory.getName();
        Category category = subcategory.getCategory();
        return new SubcategoryDto(id, name, category);
    }

}
