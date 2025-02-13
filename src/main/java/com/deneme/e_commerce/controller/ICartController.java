package com.deneme.e_commerce.controller;

import com.deneme.e_commerce.dto.AddToCartRequest;
import com.deneme.e_commerce.dto.DtoCart;
import com.deneme.e_commerce.dto.DtoCartItem;
import com.deneme.e_commerce.model.Cart;
import com.deneme.e_commerce.model.CartItem;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICartController {
    DtoCart createCart();
    DtoCartItem addItemsToCart(AddToCartRequest cartRequest);
    List<DtoCartItem> findAllCartItems();
    DtoCartItem updateCartItem(AddToCartRequest cartRequest);
    ResponseEntity<String> removeCartItem(Long productId);
}
