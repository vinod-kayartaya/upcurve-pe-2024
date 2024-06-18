package com.abb.categoryservice.dto;

import com.abb.categoryservice.entity.Category;
import lombok.Data;

@Data
public class CategoryDTO {
    private Integer id;
    private String name;
    private String description;

    public static Category toCategory(CategoryDTO dto) {
        if (dto == null) {
            return null;
        }
        Category category = new Category();
        category.setId(dto.id);
        category.setName(dto.name);
        category.setDescription(dto.description);
        return category;
    }

    public static CategoryDTO toCategoryDTO(Category category) {
        if (category == null) {
            return null;
        }
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        return dto;
    }
}
