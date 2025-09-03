package com.example.basicboardv1.test.repository;

import com.example.basicboardv1.test.domain.Uesrs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepostiory  extends JpaRepository<Uesrs,  Long> {

}
