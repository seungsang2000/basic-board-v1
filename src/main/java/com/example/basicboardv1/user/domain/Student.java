package com.example.basicboardv1.user.domain;

import com.example.basicboardv1.academy.domain.StudentAcademy;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student extends Users {
    
    @Column(name = "grade")
    private Integer grade; // 학년
    
    @Column(name = "school")
    private String school; // 학교명
    
    @Column(name = "birth_date")
    private LocalDate birthDate; // 생년월일
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Parent parent; // 학부모 정보 (다대일 관계)
    
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<StudentAcademy> studentAcademies; // 학생-학원 관계 목록
    
    // TODO: assignedRoutes 배정된 노선 정보 (다대다 관계) - Route 엔티티 생성 후 추가 예정

    // TODO: assignedStops 배정된 정류장 정보 (다대다 관계) - Stop 엔티티 생성 후 추가 예정
    
    @Column(name = "emergency_contact")
    private String emergencyContact; // 비상 연락처
}
