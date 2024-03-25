package com.example.beckend.Controller;

import com.example.beckend.dto.LoginDto;
import com.example.beckend.dto.RegisterDto;
import com.example.beckend.entity.User;
import com.example.beckend.security.servise.JwtServise;
import com.example.beckend.servise.UserServise;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    private final UserServise service;
    private final JwtServise jwtServise;

    @GetMapping("/user/getId")
    public HttpEntity<?> getUserId(@RequestHeader String refreshToken){
        Long userId = Long.parseLong(jwtServise.extractJwt(refreshToken).getPayload().getSubject());
        return ResponseEntity.ok(userId);
    }

    @PostMapping("/register")
    public HttpEntity<?> register(@RequestBody RegisterDto dto){
        Optional<User> register = service.register(dto);
        register.orElseThrow();
        return ResponseEntity.status(200).body("Registered user - "+register.get());
    }

    @PostMapping("/loginA")
    public HttpEntity<?> login(@RequestBody LoginDto dto){
        return ResponseEntity.status(200).body(service.login(dto));
    }
    @PostMapping("/refresh")
    public HttpEntity<?>refresh(@RequestHeader String refreshToken){
      return ResponseEntity.ok(service.refreshToken(refreshToken));
    }

    @GetMapping("/settings")
    public HttpEntity<?>settings(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(authentication);
    }
    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
    public HttpEntity<?>getAllUser(){
        return ResponseEntity.ok(service.allUsers());
    }

    @PatchMapping("/change")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public  HttpEntity<?>patch(@RequestParam Long id){
        try {
            service.patchUser(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("success");
    }

    @DeleteMapping("/deletes")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public HttpEntity<?>deleteUser(@RequestParam long id ){
      service.deleteUserById(id);
      return ResponseEntity.ok("success");
    }

}
    