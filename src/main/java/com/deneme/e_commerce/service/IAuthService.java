package com.deneme.e_commerce.service;

import com.deneme.e_commerce.dto.DtoUser;
import com.deneme.e_commerce.security.jwt.AuthRequest;
import com.deneme.e_commerce.security.jwt.AuthResponse;

public interface IAuthService {
    DtoUser register(AuthRequest request);
    AuthResponse authenticate(AuthRequest authRequest);
}
