package com.deneme.e_commerce.controller.impl;

import com.deneme.e_commerce.controller.ISupplierController;
import com.deneme.e_commerce.dto.DtoSupplier;
import com.deneme.e_commerce.model.Supplier;
import com.deneme.e_commerce.service.ISupplierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/api/suppliers")
public class SupplierControllerImpl implements ISupplierController {

    private ISupplierService supplierService;
    public SupplierControllerImpl(ISupplierService supplierService){
        this.supplierService = supplierService;
    }
    @PostMapping("/save")
    @Override
    public DtoSupplier saveSupplier(@RequestBody Supplier supplier) {

        return supplierService.saveSupplier(supplier);
    }

    @GetMapping("/all")
    @Override
    public List<DtoSupplier> findAll() {
        return supplierService.findAll();
    }
}
