package com.deneme.e_commerce.controller;

import com.deneme.e_commerce.dto.DtoCategory;
import com.deneme.e_commerce.dto.DtoProduct;
import com.deneme.e_commerce.model.Product;

import java.util.List;

public interface IProductController {

    DtoProduct saveProduct(Product product);
    List<DtoProduct> findAll();
    List<DtoProduct> findByCategoryId(Long categoryId);
}
