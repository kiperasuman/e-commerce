package com.deneme.e_commerce.service.impl;

import com.deneme.e_commerce.dto.DtoCategory;
import com.deneme.e_commerce.model.Category;
import com.deneme.e_commerce.repository.CategoryRepository;
import com.deneme.e_commerce.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public DtoCategory findCategoryById(Long id) {
        Optional<Category> optional = categoryRepository.findById(id);
        DtoCategory dto = new DtoCategory();
        if (optional.isEmpty()) {
            return null;
        } else {
            BeanUtils.copyProperties(optional.get(), dto);
            return dto;
        }

    }

    @Override
    public List<DtoCategory> findAllCategories() {
        List<Category> allCategories = categoryRepository.findAll();
        List<DtoCategory> dto = new ArrayList<>();
        for (Category category : allCategories) {
            DtoCategory dtoCategory = new DtoCategory();
            dtoCategory.setName(category.getName());
            dtoCategory.setDescription(category.getDescription());
            dto.add(dtoCategory);
        }
        return dto;
    }

    @Override
    public DtoCategory saveCategory(Category category) {
        Category savedCategory = categoryRepository.save(category);
        DtoCategory dto = new DtoCategory();
        dto.setName(savedCategory.getName());
        dto.setDescription(savedCategory.getDescription());
        return dto;
    }

    @Override
    public DtoCategory updateCategory(Long id, Category category) {
        Optional<Category> checkId = categoryRepository.findById(id);
        if (checkId.isPresent()) {
            Category newCategory = checkId.get();
            newCategory.setId(id);
            newCategory.setName(category.getName());
            newCategory.setDescription(category.getDescription());

            Category updatedCategory = categoryRepository.save(newCategory);
            DtoCategory dto = new DtoCategory();
            BeanUtils.copyProperties(updatedCategory, dto);
            return dto;
        }
        return null;
    }

    @Override
    public boolean deleteCategory(Long id) {
        Optional<Category> optionalId = categoryRepository.findById(id);
        if (optionalId.isPresent()) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
