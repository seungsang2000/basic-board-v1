package com.example.basicboardv1.user.domain;

import lombok.Getter;

@Getter
public enum DriverStatus {
    ACTIVE("활성"),
    INACTIVE("비활성"),
    ON_LEAVE("휴가중"),
    SUSPENDED("정직"),
    TERMINATED("퇴사");

    private final String description;

    DriverStatus(String description) {
        this.description = description;
    }
}