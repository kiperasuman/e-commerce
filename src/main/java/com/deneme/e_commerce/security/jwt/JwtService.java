package com.deneme.e_commerce.security.jwt;

import com.deneme.e_commerce.utils.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService {

    @Value("${jwt_secret}")
    private String jwtSecret;

    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        claims.put("role",Role.ROLE_ADMIN);
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .addClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*2))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }
    public Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }
    public <T> T exportToken(String token, Function<Claims,T> claims){
        Claims body = Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.apply(body);
    }
    public String getUserNameFromJwtToken(String token){
        return exportToken(token,Claims::getSubject);
    }
    public boolean isTokenExpired(String token){
        return new Date().before(exportToken(token,Claims::getExpiration));
    }

}
