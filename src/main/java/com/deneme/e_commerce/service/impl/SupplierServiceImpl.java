package com.deneme.e_commerce.service.impl;

import com.deneme.e_commerce.dto.DtoSupplier;
import com.deneme.e_commerce.model.Supplier;
import com.deneme.e_commerce.repository.SupplierRepository;
import com.deneme.e_commerce.service.ISupplierService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl implements ISupplierService {

    private SupplierRepository supplierRepository;
    public SupplierServiceImpl(SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }

    @Override
    public DtoSupplier saveSupplier(Supplier supplier) {
        Supplier saved = supplierRepository.save(supplier);
        DtoSupplier dto = new DtoSupplier();
        BeanUtils.copyProperties(saved,dto);
        return dto;
    }

    @Override
    public List<DtoSupplier> findAll() {
        List<Supplier> supplierList = supplierRepository.findAll();
        List<DtoSupplier> dtoSuppliers = new ArrayList<>();
        for (Supplier suppliers : supplierList){
            DtoSupplier dtoSupplier = new DtoSupplier();
            BeanUtils.copyProperties(suppliers,dtoSupplier);
            dtoSuppliers.add(dtoSupplier);
        }
        return dtoSuppliers;
    }
}
