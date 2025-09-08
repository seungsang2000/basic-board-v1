package com.example.basicboardv1.user.domain;


import lombok.Getter;

@Getter
public enum Role {
    ACADEMY_MANAGER("학원 관리자"),
    DRIVER("기사"),
    PARENT("학부모"),
    STUDENT("학생");

    private final String description;

    Role(String description) {
        this.description = description;
    }
}