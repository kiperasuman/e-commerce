package com.deneme.e_commerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoCartItem {

    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;
    private Long productId;
    private Long cartId;

}
