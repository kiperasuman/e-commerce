package com.deneme.e_commerce.controller;

import com.deneme.e_commerce.dto.AddToCartRequest;
import com.deneme.e_commerce.dto.DtoCart;
import com.deneme.e_commerce.dto.DtoCartItem;
import com.deneme.e_commerce.model.Cart;
import com.deneme.e_commerce.model.CartItem;

public interface ICartController {
    DtoCart createCart();

    DtoCartItem addItemsToCart(AddToCartRequest cartRequest);
}
