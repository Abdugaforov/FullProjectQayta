package com.example.beckend.security.filter;

import com.example.beckend.entity.User;
import com.example.beckend.repo.UserRepo;
import com.example.beckend.security.servise.JwtServise;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
@Configuration
@RequiredArgsConstructor
public class Filter extends OncePerRequestFilter{
    private final JwtServise jwtServise;
    private final UserRepo repo;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        System.out.println(authorization);
        if(authorization!=null ){
            Jws<Claims>  claimsJws = jwtServise.extractJwt(authorization);
            Claims user = claimsJws.getPayload();
            String id = user.getSubject();
            User user1 = repo.findById(Long.parseLong(id)).get();
            UsernamePasswordAuthenticationToken usn = new UsernamePasswordAuthenticationToken(
                    user1.getEmail(),
                    user1.getPassword(),
                    user1.getAuthorities()
            );
            SecurityContextHolder.getContext().setAuthentication(usn);
        }
        filterChain.doFilter(request,response);
    }
}
