package ua.com.furniture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.furniture.dto.SubcategoryDto;
import ua.com.furniture.dto.SubcategoryDtoForSaveAndUpdate;
import ua.com.furniture.entity.Subcategory;
import ua.com.furniture.service.SubcategoryService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(SubcategoryController.URL)
public class SubcategoryController {
    static final String URL = "/api/subcategory";

    @Autowired
    private SubcategoryService subcategoryService;

    @GetMapping
    public List<SubcategoryDto> get(){
        return subcategoryService.findAll();
    }

    @PostMapping
    public Subcategory create(@RequestBody SubcategoryDtoForSaveAndUpdate subcategoryDtoForSaveAndUpdate) {
        return subcategoryService.save(subcategoryDtoForSaveAndUpdate);
    }

    @PutMapping
    public Subcategory update(@RequestBody SubcategoryDtoForSaveAndUpdate subcategoryDtoForSaveAndUpdate) {
        return subcategoryService.save(subcategoryDtoForSaveAndUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        subcategoryService.delete(id);
    }
}
