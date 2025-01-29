package com.deneme.e_commerce.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class DtoProduct {
    private Long id;
    private String name;
    private List<DtoSupplier> supplier;
    private DtoCategory category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DtoSupplier> getSupplier() {
        return supplier;
    }

    public void setSupplier(List<DtoSupplier> supplier) {
        this.supplier = supplier;
    }

    public DtoCategory getCategory() {
        return category;
    }

    public void setCategory(DtoCategory category) {
        this.category = category;
    }
}
