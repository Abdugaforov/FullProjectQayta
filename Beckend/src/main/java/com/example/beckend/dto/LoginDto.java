package com.example.beckend.dto;

import com.example.beckend.entity.Role;

import java.util.ArrayList;
import java.util.List;

public record LoginDto(String username, String password) {
}
