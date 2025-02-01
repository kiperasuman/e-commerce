package com.deneme.e_commerce.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor

public class DtoCartItem {

    private int quantity;
    private BigDecimal totalPrice;
    private DtoProduct product;
    private DtoCart cart;

}
