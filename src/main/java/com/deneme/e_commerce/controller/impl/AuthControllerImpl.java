package com.deneme.e_commerce.controller.impl;

import com.deneme.e_commerce.controller.IAuthController;
import com.deneme.e_commerce.dto.DtoUser;
import com.deneme.e_commerce.security.jwt.AuthRequest;
import com.deneme.e_commerce.security.jwt.AuthResponse;
import com.deneme.e_commerce.service.IAuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthControllerImpl implements IAuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/register")
    @Override
    public DtoUser register(@RequestBody @Valid AuthRequest authRequest) {
        return authService.register(authRequest);
    }

    @PostMapping("/authenticate")
    @Override
    public AuthResponse authenticate(@RequestBody @Valid AuthRequest authRequest) {
        return authService.authenticate(authRequest);
    }
}
