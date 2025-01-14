package com.deneme.e_commerce.controller;

import com.deneme.e_commerce.dto.DtoUser;
import com.deneme.e_commerce.security.jwt.AuthRequest;
import com.deneme.e_commerce.security.jwt.AuthResponse;

public interface IAuthController {
    DtoUser register(AuthRequest authRequest);
    AuthResponse authenticate(AuthRequest authRequest);
}
