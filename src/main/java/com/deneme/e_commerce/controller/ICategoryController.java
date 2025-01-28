package com.deneme.e_commerce.controller;

import com.deneme.e_commerce.dto.DtoCategory;
import com.deneme.e_commerce.model.Category;

import java.util.List;

public interface ICategoryController {
    DtoCategory findCategoryById(Long id);
    List<DtoCategory> findAllCategories();
    DtoCategory saveCategory(Category category);
    DtoCategory updateCategory(Long id , Category category);
    boolean deleteCategory(Long id);

}
