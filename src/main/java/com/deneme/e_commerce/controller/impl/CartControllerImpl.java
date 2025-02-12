package com.deneme.e_commerce.controller.impl;

import com.deneme.e_commerce.controller.ICartController;
import com.deneme.e_commerce.dto.AddToCartRequest;
import com.deneme.e_commerce.dto.DtoCart;
import com.deneme.e_commerce.dto.DtoCartItem;
import com.deneme.e_commerce.security.jwt.JwtService;
import com.deneme.e_commerce.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rest/api/cart")
public class CartControllerImpl implements ICartController {

    protected ICartService cartService;
    @Autowired
    private JwtService jwtService;

    public CartControllerImpl(ICartService cartService) {
        this.cartService = cartService;
    }

    private String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return username;
    }

    @PostMapping()
    public DtoCart createCart() {
        return cartService.createCart(getUsername());
    }


    @PostMapping("/add-item") // sepete ekle
    public DtoCartItem addItemsToCart(@RequestBody AddToCartRequest cartRequest) {
        return cartService.addItemsToCart(cartRequest,getUsername());
    }


}
