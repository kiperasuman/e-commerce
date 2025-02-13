package com.deneme.e_commerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoProduct {

    private Long id;
    private String name;
    private List<DtoSupplier> supplier;
    private DtoCategory category;

}
