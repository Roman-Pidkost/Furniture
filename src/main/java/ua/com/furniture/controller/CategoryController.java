package ua.com.furniture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.furniture.dto.CategoryDto;
import ua.com.furniture.entity.Category;
import ua.com.furniture.service.CategoryService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = CategoryController.URL)
public class CategoryController {
    static final String URL = "/api/category";

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> get() {
        return categoryService.findAll();
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @PutMapping
    public Category update(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        categoryService.delete(id);
    }
}

