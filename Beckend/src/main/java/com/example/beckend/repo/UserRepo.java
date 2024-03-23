package com.example.beckend.repo;

import com.example.beckend.entity.User;
import com.example.beckend.project.UserProject;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String username);

    @Query(value = "select u.id  as id, u.full_name as fullName , u.email as email , u.password  as password , r.name as role  , u.is_true as isTrue  from users u inner join users_roles ur on u.id = ur.users_id inner join public.role r on r.id = ur.roles_id ",nativeQuery = true)
    List<UserProject> getAllUsers();

    @Modifying
    @Transactional
    @Query(value = "update users set is_true = not is_true where id = :id", nativeQuery = true)
    void updateUserIsTrue(Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM users WHERE id =:id ", nativeQuery = true)
    void deleteUser(Long id);

}
