package ua.com.furniture.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.furniture.dto.SubcategoryDto;
import ua.com.furniture.dto.SubcategoryDtoForSaveAndUpdate;
import ua.com.furniture.dtoConverter.SubcategoryConverter;
import ua.com.furniture.entity.Subcategory;
import ua.com.furniture.repository.SubcategoryRepository;
import ua.com.furniture.service.SubcategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    @Autowired
    private SubcategoryConverter subcategoryConverter;

    public Subcategory save(SubcategoryDtoForSaveAndUpdate subcategoryDtoForSaveAndUpdate) {
        return subcategoryRepository.saveAndFlush(subcategoryConverter.convertDtoToEntity(subcategoryDtoForSaveAndUpdate));
    }

    public Subcategory save(Subcategory subcategory) {
        return subcategoryRepository.saveAndFlush(subcategory);
    }

    public List<SubcategoryDto> findAll() {
        return subcategoryRepository.findAll().stream().map(e -> subcategoryConverter.convertEntityToDto(e)).collect(Collectors.toList());
    }

    public Subcategory findOne(int id) {
        return subcategoryRepository.findOne(id);
    }

    public void delete(int id) {
        subcategoryRepository.delete(id);
    }
}
