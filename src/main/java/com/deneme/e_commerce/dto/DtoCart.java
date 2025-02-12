package com.deneme.e_commerce.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor

public class DtoCart {

    private Long id;
    private Long userId;
    private List<DtoCartItem> cartItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<DtoCartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<DtoCartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
