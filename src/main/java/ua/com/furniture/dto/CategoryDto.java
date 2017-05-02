package ua.com.furniture.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.com.furniture.entity.Subcategory;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private int id;

    private String name;

    private List<Subcategory> subcategories;
}
