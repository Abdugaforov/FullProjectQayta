package com.example.beckend.servise;

import com.example.beckend.dto.LoginDto;
import com.example.beckend.dto.RegisterDto;
import com.example.beckend.entity.User;
import com.example.beckend.project.UserProject;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserServise {
    Optional<User> register(RegisterDto dto);
    Map<String, String> login(LoginDto dto);
    Optional<User> findUserById(Long id);
    String refreshToken(String jwt);

    List<UserProject> allUsers();
    void patchUser(Long id);

    void deleteUserById(long id);
}
