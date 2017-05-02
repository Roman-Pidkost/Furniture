package ua.com.furniture.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.com.furniture.entity.Category;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubcategoryDto {

    private int id;

    private String name;

    private Category category;
}
