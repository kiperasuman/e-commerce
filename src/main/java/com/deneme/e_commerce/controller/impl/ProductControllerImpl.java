package com.deneme.e_commerce.controller.impl;

import com.deneme.e_commerce.controller.IProductController;
import com.deneme.e_commerce.dto.DtoProduct;
import com.deneme.e_commerce.model.Product;
import com.deneme.e_commerce.service.IProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/products")
public class ProductControllerImpl implements IProductController {

   private IProductService productService;
   public ProductControllerImpl(IProductService productService){this.productService = productService;}

    @PostMapping("/save")
    @Override
    public DtoProduct saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
}
