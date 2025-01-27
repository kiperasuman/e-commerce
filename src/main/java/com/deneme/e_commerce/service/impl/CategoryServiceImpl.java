package com.deneme.e_commerce.service.impl;

import com.deneme.e_commerce.model.Category;
import com.deneme.e_commerce.repository.CategoryRepository;
import com.deneme.e_commerce.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category findCategoryById(Long id) {
        Optional<Category> optional = categoryRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        } else {
            return optional.get();
        }

    }
}
