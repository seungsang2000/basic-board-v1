package com.example.basicboardv1.user.domain;

import com.example.basicboardv1.academy.domain.ManagerAcademy;
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
    
    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    private List<ManagerAcademy> managerAcademies; // 관리자-학원 관계 목록
    
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "manager_permissions", joinColumns = @JoinColumn(name = "manager_id"))
    @Column(name = "permission")
    private List<String> permissions; // 관리자 권한 목록 (후에 권한 테이블로 분리 고려)
}
