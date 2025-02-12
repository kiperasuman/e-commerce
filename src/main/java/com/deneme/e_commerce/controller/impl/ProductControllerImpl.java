package com.deneme.e_commerce.controller.impl;

import com.deneme.e_commerce.controller.IProductController;
import com.deneme.e_commerce.dto.DtoProduct;
import com.deneme.e_commerce.model.Product;
import com.deneme.e_commerce.service.IProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "rest/api/products")
public class ProductControllerImpl implements IProductController {

   private IProductService productService;
   public ProductControllerImpl(IProductService productService){this.productService = productService;}

    @PostMapping("/save")
    @Override
    public DtoProduct saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/list")
    @Override
    public List<DtoProduct> findAll() {
        return productService.findAll();
    }
    @GetMapping("/list/{categoryId}")
    @Override
    public List<DtoProduct> findByCategoryId(@PathVariable Long categoryId) {
        return productService.findByCategoryId(categoryId);
    }




}
