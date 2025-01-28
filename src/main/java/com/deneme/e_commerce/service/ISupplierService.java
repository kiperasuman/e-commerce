package com.deneme.e_commerce.service;

import com.deneme.e_commerce.dto.DtoSupplier;
import com.deneme.e_commerce.model.Supplier;

import java.util.List;

public interface ISupplierService {
    DtoSupplier saveSupplier(Supplier supplier);
    List<DtoSupplier> findAll();
}
