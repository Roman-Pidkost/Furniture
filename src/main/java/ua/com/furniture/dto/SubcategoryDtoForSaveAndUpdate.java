package ua.com.furniture.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SubcategoryDtoForSaveAndUpdate {

    private int id;

    private String name;

    @JsonProperty("category")
    private int categoryId;
}
