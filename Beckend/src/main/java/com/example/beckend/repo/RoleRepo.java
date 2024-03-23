package com.example.beckend.repo;

import com.example.beckend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface RoleRepo extends JpaRepository<Role,Long> {
    Optional<Role> findByName(String roleUser);


}
