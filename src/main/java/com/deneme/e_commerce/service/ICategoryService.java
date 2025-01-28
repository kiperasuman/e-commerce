package com.deneme.e_commerce.service;

import com.deneme.e_commerce.dto.DtoCategory;
import com.deneme.e_commerce.model.Category;

import java.util.List;

public interface ICategoryService {
    DtoCategory findCategoryById(Long id);
    List<DtoCategory> findAllCategories();
    DtoCategory saveCategory(Category category);
    DtoCategory updateCategory(Long id,Category category);
    boolean deleteCategory(Long id);
}
