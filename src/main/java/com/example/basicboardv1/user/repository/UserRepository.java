package com.example.basicboardv1.user.repository;

import com.example.basicboardv1.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    
    Optional<Users> findByEmail(String email);
    
    boolean existsByEmail(String email);
}