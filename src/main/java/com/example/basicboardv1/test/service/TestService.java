package com.example.basicboardv1.test.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String getTestMessage() {
        return "Testing from Service!";
    }

}
