package com.deneme.e_commerce.security.config;

import com.deneme.e_commerce.security.AuthEntryPoint;
import com.deneme.e_commerce.security.jwt.AuthenticationFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    public static final String AUTHENTICATE = "/authenticate";
    public static final String SIGN_UP = "/register";
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private AuthenticationFilter authenticationFilter;

    @Autowired
    private AuthEntryPoint authEntryPoint;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
         httpSecurity.csrf().disable()
                 .authorizeHttpRequests(
                         request -> request.requestMatchers(AUTHENTICATE, SIGN_UP)
                                 .permitAll()
                                 .anyRequest()
                                 .authenticated()).exceptionHandling().authenticationEntryPoint(authEntryPoint).and()
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
                return httpSecurity.build();
    }
}
