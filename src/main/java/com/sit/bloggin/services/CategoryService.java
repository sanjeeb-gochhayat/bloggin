package com.sit.bloggin.services;

import com.sit.bloggin.payloads.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO createCategory(CategoryDTO categoryDTO);
    //update
    CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId);
    //delete
    void deleteCategory(Integer categoryId);
    //get
    CategoryDTO getCategoryById(Integer categoryId);
    //getAll
    List<CategoryDTO> getAllCategory();
}
