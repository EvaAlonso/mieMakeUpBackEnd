package com.OnceFactoriaF5.miemakeup.services;

import com.OnceFactoriaF5.miemakeup.dtos.category.CategoryDTORequest;
import com.OnceFactoriaF5.miemakeup.dtos.category.CategoryDTOResponse;
import com.OnceFactoriaF5.miemakeup.dtos.category.CategoryMapper;
import com.OnceFactoriaF5.miemakeup.dtos.category.DeleteCategoryDTOResponse;
import com.OnceFactoriaF5.miemakeup.exceptions.EmptyException;
import com.OnceFactoriaF5.miemakeup.models.Category;
import com.OnceFactoriaF5.miemakeup.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDTOResponse saveCategory(CategoryDTORequest categoryDTORequest){
        Category newCategory = CategoryMapper.dtoToEntity(categoryDTORequest);
        Category savedCategory = categoryRepository.save(newCategory);
        return CategoryMapper.entityToDto(savedCategory);
    }

    public List<CategoryDTOResponse> getCategories(){
        List<Category> categoryList = categoryRepository.findAll();
        if (categoryList.isEmpty()) throw new EmptyException("Not found Categories");
        return categoryList.stream().map(CategoryMapper::entityToDto).toList();
    }

    public CategoryDTOResponse getCategoryById(int id){
        Category category = categoryRepository.findById(id).orElseThrow(()->new EmptyException("Category with id " + id + "not found"));
        return CategoryMapper.entityToDto(category);
    }

    public CategoryDTOResponse updateCategory(int id, CategoryDTORequest categoryDTORequest){
        Category existingCategory = categoryRepository.findById(id).orElseThrow(()->new EmptyException("Category with id " + id + "not found"));

        existingCategory.setName(categoryDTORequest.name());

        Category updatedCategory = categoryRepository.save(existingCategory);
        return CategoryMapper.entityToDto(updatedCategory);
    }

    public DeleteCategoryDTOResponse deleteCategoryDTOResponse(int id){
        Category existingCategory = categoryRepository.findById(id).orElseThrow(()->new EmptyException("Category with id " + id + "not found"));
        CategoryDTOResponse categoryDTOResponse = CategoryMapper.entityToDto(existingCategory);
        categoryRepository.delete(existingCategory);
        String message = "Category " + existingCategory.getName() + " has been successfully deleted.";
        return new DeleteCategoryDTOResponse(categoryDTOResponse, message);
    }
}
