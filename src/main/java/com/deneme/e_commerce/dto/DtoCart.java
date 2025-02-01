package com.deneme.e_commerce.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor

public class DtoCart {

    private Long id;
    private DtoUser user;
    private List<DtoCartItem> cartItems;

}
