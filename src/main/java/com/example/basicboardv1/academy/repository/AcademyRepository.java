package com.example.basicboardv1.academy.repository;

import com.example.basicboardv1.academy.domain.Academy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademyRepository extends JpaRepository<Academy, Long> {
}