package com.example.basicboardv1.user.domain;

import com.example.basicboardv1.academy.domain.DriverAcademy;
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
@Table(name = "drivers")
public class Driver extends Users {
    
    @Column(name = "license_number", unique = true)
    private String licenseNumber; // 운전면허번호
    
    @Column(name = "emergency_contact")
    private String emergencyContact; // 비상시 연락처
    
    @OneToMany(mappedBy = "driver", fetch = FetchType.LAZY)
    private List<DriverAcademy> driverAcademies; // 운전기사-학원 관계 목록
    
    // TODO: assignedVehicles 담당 차량 목록 (일대다 관계) - Vehicle 엔티티 생성 후 추가 예정

}
