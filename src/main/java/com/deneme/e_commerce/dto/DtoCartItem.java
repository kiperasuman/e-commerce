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

    private Long cartId;
    private Long productId;
    private String productName;
    private String categoryName;
    private BigDecimal unitPrice;
    private int quantity;
    private BigDecimal totalPrice;

}
