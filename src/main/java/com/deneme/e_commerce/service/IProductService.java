package com.deneme.e_commerce.service;

import com.deneme.e_commerce.dto.DtoProduct;
import com.deneme.e_commerce.dto.DtoSupplier;
import com.deneme.e_commerce.model.Product;

import java.util.List;

public interface IProductService {
    DtoProduct saveProduct(Product request);
    List<DtoProduct> findAll();
    List<DtoProduct> findByCategoryId(Long categoryId);
}
