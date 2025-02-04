package com.OnceFactoriaF5.miemakeup.controllers;

import com.OnceFactoriaF5.miemakeup.dtos.category.CategoryDTORequest;
import com.OnceFactoriaF5.miemakeup.dtos.category.CategoryDTOResponse;
import com.OnceFactoriaF5.miemakeup.dtos.category.DeleteCategoryDTOResponse;
import com.OnceFactoriaF5.miemakeup.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryDTOResponse> saveCategory(@Valid @RequestBody CategoryDTORequest categoryDTORequest){
        return new ResponseEntity<>(categoryService.saveCategory(categoryDTORequest), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTOResponse>> getCategories(){
        return new ResponseEntity<>(categoryService.getCategories(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTOResponse> getCategoryById(@PathVariable int id){
        CategoryDTOResponse categoryDTOResponse = categoryService.getCategoryById(id);
        return new ResponseEntity<>(categoryDTOResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTOResponse> updateCategory(@PathVariable int id, @Valid @RequestBody CategoryDTORequest categoryDTORequest){
        CategoryDTOResponse updatedCategory = categoryService.updateCategory(id, categoryDTORequest);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteCategoryDTOResponse> deleteCategory(@PathVariable int id){
        DeleteCategoryDTOResponse response = categoryService.deleteCategoryDTOResponse(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
