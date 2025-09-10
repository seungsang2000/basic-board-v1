package com.example.basicboardv1.academy.domain;

import com.example.basicboardv1.user.domain.AcademyManager;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "manager_academy")
public class ManagerAcademy {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", nullable = false)
    private AcademyManager manager;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academy_id", nullable = false)
    private Academy academy;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private ManagementRole role;
    
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
    
    @Column(name = "notes")
    private String notes;
    
    public enum ManagementRole {
        PRINCIPAL,      // 원장
        VICE_PRINCIPAL, // 부원장
        ADMIN_STAFF,    // 행정직원
        DEPARTMENT_HEAD // 부서장
    }
    
    @PrePersist
    protected void onCreate() {
        this.isActive = true;
    }
}