package com.example.basicboardv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BasicBoardV1Application {

    public static void main(String[] args) {
        SpringApplication.run(BasicBoardV1Application.class, args);
    }

}
