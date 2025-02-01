package com.deneme.e_commerce.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

public class DtoOrderItem {

    private Long id;
    private DtoOrder order;
    private DtoProduct product;
    private Integer quantity;

}
