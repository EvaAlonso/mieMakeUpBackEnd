package com.OnceFactoriaF5.miemakeup.dtos.category;

import com.OnceFactoriaF5.miemakeup.models.Category;

public class CategoryMapper {
    public static Category dtoToEntity(CategoryDTORequest categoryDTORequest){
        return new Category(categoryDTORequest.name());
    }
    public static CategoryDTOResponse entityToDto(Category category){
        return new CategoryDTOResponse(category.getId(), category.getName(), category.getProducts());
    }
}
