package com.example.beckend.security.servise.impl;

import com.example.beckend.security.servise.JwtServise;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtServiseImpl implements JwtServise {
    @Override
    public String generateJwt(String id) {
        String jwt = Jwts.builder()
                .expiration(new Date(System.currentTimeMillis() + 1000*60*30))
                .issuedAt(new Date())
                .signWith(signWithKey())
                .subject(id)
                .compact();
        return jwt;
    }

    @Override
    public String generateRefreshJwt(String id) {
        String jwt = Jwts.builder()
                .expiration(new Date(System.currentTimeMillis() + 1000*60*60))
                .issuedAt(new Date())
                .signWith(signWithKey())
                .subject(id)
                .compact();
        return jwt;
    }



    @Override
    public SecretKey signWithKey(){
        final String SECRET_KEY="cFojhYvboFedxSFDyY2olaEg4sp2fqU7ktF9it2KDwI";
        byte[] decode = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(decode);
    }

    @Override
    public Jws<Claims> extractJwt(String jwt) {
        return Jwts.parser()
                .verifyWith(signWithKey())
                .build()
                .parseSignedClaims(jwt);
    }
}
