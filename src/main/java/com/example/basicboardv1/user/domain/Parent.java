package com.example.basicboardv1.user.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "parents")
public class Parent extends Users {

    @Column(name = "relationship")
    private String relationship; // 자녀와의 관계 (부, 모, 조부모, 보호자 등)
    
    @Column(name = "workplace_contact")
    private String workplaceContact; // 직장 연락처
    
    @Column(name = "secondary_phone_number")
    private String secondaryPhoneNumber; // 보조 연락처
    
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<Student> children; // 자녀 목록 (일대다 관계)
}