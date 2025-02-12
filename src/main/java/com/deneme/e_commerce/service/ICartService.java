package com.deneme.e_commerce.service;

import com.deneme.e_commerce.dto.AddToCartRequest;
import com.deneme.e_commerce.dto.DtoCart;
import com.deneme.e_commerce.dto.DtoCartItem;
import com.deneme.e_commerce.model.Cart;

public interface ICartService {
    public DtoCart createCart(String username);
    public DtoCartItem addItemsToCart(AddToCartRequest addToCartRequest,String username);
}
