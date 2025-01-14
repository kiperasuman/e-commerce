package com.deneme.e_commerce.service.impl;

import com.deneme.e_commerce.dto.DtoUser;
import com.deneme.e_commerce.model.User;
import com.deneme.e_commerce.repository.UserRepository;
import com.deneme.e_commerce.security.config.AppConfig;
import com.deneme.e_commerce.security.jwt.AuthRequest;
import com.deneme.e_commerce.security.jwt.AuthResponse;
import com.deneme.e_commerce.security.jwt.JwtService;
import com.deneme.e_commerce.service.IAuthService;
import com.deneme.e_commerce.utils.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private JwtService jwtService;


    @Override
    public DtoUser register(AuthRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setUserRole(Role.ROLE_USER);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        User saved = userRepository.save(user);
        DtoUser dtoUser = new DtoUser();
        dtoUser.setEmail(saved.getEmail());
        dtoUser.setUsername(saved.getUsername());
        dtoUser.setPassword(saved.getPassword());
        return dtoUser;
    }

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
            authenticationProvider.authenticate(authenticationToken);
            Optional<User> username = userRepository.findByUsername(authRequest.getUsername());
            return new AuthResponse(jwtService.generateToken(username.get()));
        } catch (Exception e) {
            System.out.println("Username or password incorrect "+ e.getMessage());
        }
        return null;
    }
}
