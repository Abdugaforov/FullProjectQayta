package com.example.beckend.loaders;

import com.example.beckend.entity.*;
import com.example.beckend.repo.RoleRepo;
import com.example.beckend.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class Loader implements CommandLineRunner {
    private final RoleRepo repo;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepo userRepo;



    @Override
    public void run(String... args) throws Exception {
        List<Role> all = repo.findAll();

        if (all.isEmpty()) {
            List<Role>   roles = repo.saveAll(List.of(
                     Role.builder()
                             .name("ROLE_ADMIN").build()
                    ,
                    Role.builder()
                            .name("ROLE_SUPER_ADMIN").build()
                    ,
                    Role.builder()
                            .name("ROLE_USER").build()
            ));
            User user = new User( "abdugafforov ozodbek","admin", passwordEncoder.encode("123"), 12,roles, true);
              userRepo.save(user);



        }


    }
}
