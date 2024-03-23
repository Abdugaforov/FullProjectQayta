package com.example.beckend.security.servise;

import com.example.beckend.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

import javax.crypto.SecretKey;

public interface JwtServise {
    String generateJwt(String id);
    SecretKey signWithKey();
    Jws<Claims> extractJwt(String jwt);
    String generateRefreshJwt(String id );
}
