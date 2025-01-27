package com.deneme.e_commerce.controller.impl;

import com.deneme.e_commerce.controller.ICategoryController;
import com.deneme.e_commerce.model.Category;
import com.deneme.e_commerce.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryControllerImpl implements ICategoryController {

    @Autowired
    private ICategoryService categoryService;
    @GetMapping("/list/{id}")
    @Override
    public Category findCategoryById(@PathVariable("id") Long id) {
        return categoryService.findCategoryById(id);
    }
}
