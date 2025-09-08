package com.example.basicboardv1.user.domain;

import com.example.basicboardv1.academy.domain.Academy;
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
@Table(name = "drivers")
public class Driver extends Users {
    
    @Column(name = "license_number", unique = true)
    private String licenseNumber; // 운전면허번호
    
    @Column(name = "emergency_contact")
    private String emergencyContact; // 비상시 연락처
    
    @Enumerated(EnumType.STRING)
    @Column(name = "driver_status")
    private DriverStatus driverStatus; // 근무 상태
    
    @Column(name = "hire_date")
    private LocalDate hireDate; // 입사일
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "driver_academy",
        joinColumns = @JoinColumn(name = "driver_id"),
        inverseJoinColumns = @JoinColumn(name = "academy_id")
    )
    private List<Academy> academies; // 소속 학원 정보 (다대다 관계)
    
    // TODO: assignedVehicles 담당 차량 목록 (일대다 관계) - Vehicle 엔티티 생성 후 추가 예정

}
