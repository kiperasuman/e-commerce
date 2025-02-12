package com.deneme.e_commerce.controller.impl;

import com.deneme.e_commerce.controller.ICategoryController;
import com.deneme.e_commerce.dto.DtoCategory;
import com.deneme.e_commerce.model.Category;
import com.deneme.e_commerce.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/api/category")
public class CategoryControllerImpl implements ICategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list/{id}")
    @Override
    public DtoCategory findCategoryById(@PathVariable("id") Long id) {
        return categoryService.findCategoryById(id);
    }

    @GetMapping("/list")
    @Override
    public List<DtoCategory> findAllCategories() {
        return categoryService.findAllCategories();
    }
    @PostMapping("/save")
    @Override
    public DtoCategory saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }
    @PutMapping("/update/{id}")
    @Override
    public DtoCategory updateCategory(@PathVariable(name = "id", required = true) Long id, @RequestBody Category category) {
        return categoryService.updateCategory(id,category);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public boolean deleteCategory(@PathVariable(name = "id",required = true) Long id) {
        return categoryService.deleteCategory(id);
    }

}
