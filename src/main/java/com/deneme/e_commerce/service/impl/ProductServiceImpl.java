package com.deneme.e_commerce.service.impl;

import com.deneme.e_commerce.dto.DtoCategory;
import com.deneme.e_commerce.dto.DtoProduct;
import com.deneme.e_commerce.dto.DtoSupplier;
import com.deneme.e_commerce.model.Category;
import com.deneme.e_commerce.model.Product;
import com.deneme.e_commerce.model.Supplier;
import com.deneme.e_commerce.repository.CategoryRepository;
import com.deneme.e_commerce.repository.ProductRepository;
import com.deneme.e_commerce.repository.SupplierRepository;
import com.deneme.e_commerce.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              SupplierRepository supplierRepository,
                              CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public DtoProduct saveProduct(Product request) {

        Product product = new Product();
        BeanUtils.copyProperties(request,product,"id");

        Optional<Category> optionalCategory = categoryRepository.findById(request.getCategory().getId());
        if (optionalCategory.isPresent()){
            product.setCategory(optionalCategory.get());
        }else {
            throw new RuntimeException("Kategori Bulunamadı!");
        }

        List<Supplier> suppliers = product.getSupplier().stream()
                .map(supplier -> supplierRepository.findById(supplier.getId())
                        .orElseThrow(() -> new RuntimeException("Tedarikçi Bulunamadı!")))
                .collect(Collectors.toList());

        product.setSupplier(suppliers);

        Product saved = productRepository.save(product);

        DtoProduct dtoProduct = new DtoProduct();
        BeanUtils.copyProperties(saved,dtoProduct);

        List<DtoSupplier> dtoSuppliers = saved.getSupplier().stream()
                .map(supplier -> {
                    DtoSupplier dtoSupplier = new DtoSupplier();
                    BeanUtils.copyProperties(supplier,dtoSupplier);
                    return dtoSupplier;
                }).collect(Collectors.toList());

        dtoProduct.setSupplier(dtoSuppliers);

        DtoCategory dtoCategory = new DtoCategory();
        BeanUtils.copyProperties(saved.getCategory(),dtoCategory);
        dtoProduct.setCategory(dtoCategory);

        dtoProduct.setName(product.getName());

        return dtoProduct;
    }
}
