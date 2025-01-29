package com.deneme.e_commerce.service;

import com.deneme.e_commerce.dto.DtoProduct;
import com.deneme.e_commerce.model.Product;

public interface IProductService {
    DtoProduct saveProduct(Product request);
}
