package com.example.basicboardv1.user.domain;

import com.example.basicboardv1.academy.domain.Academy;
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
@Table(name = "academy_managers")
public class AcademyManager extends Users {
    
    @Column(name = "position")
    private String position; // 직책 (원장, 부원장, 행정직원 등)
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "manager_academy",
        joinColumns = @JoinColumn(name = "manager_id"),
        inverseJoinColumns = @JoinColumn(name = "academy_id")
    )
    private List<Academy> academies; // 관리하는 학원 목록 (다대다 관계)
    
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "manager_permissions", joinColumns = @JoinColumn(name = "manager_id"))
    @Column(name = "permission")
    private List<String> permissions; // 관리자 권한 목록 (후에 권한 테이블로 분리 고려)
}
