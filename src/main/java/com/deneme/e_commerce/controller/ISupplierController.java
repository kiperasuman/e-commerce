package com.deneme.e_commerce.controller;

import com.deneme.e_commerce.dto.DtoSupplier;
import com.deneme.e_commerce.model.Supplier;

import java.util.List;

public interface ISupplierController {
    DtoSupplier saveSupplier(Supplier supplier);
    List<DtoSupplier> findAll();
}
