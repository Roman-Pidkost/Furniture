package ua.com.furniture.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.furniture.dto.CategoryDto;
import ua.com.furniture.dtoConverter.CategoryConverter;
import ua.com.furniture.entity.Category;
import ua.com.furniture.repository.CategoryRepository;
import ua.com.furniture.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryConverter categoryConverter;

    public Category save(Category category) {
        return categoryRepository.saveAndFlush(category);
    }

    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(e -> categoryConverter.convertEntityToDto(e)).collect(Collectors.toList());
    }

    public Category findOne(int id) {
        return categoryRepository.findOne(id);
    }

    public void delete(int id) {
        categoryRepository.delete(id);
    }
}
