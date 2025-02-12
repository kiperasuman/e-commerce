package com.deneme.e_commerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddToCartRequest {
    private Long productId;
    private int quantity;
}
