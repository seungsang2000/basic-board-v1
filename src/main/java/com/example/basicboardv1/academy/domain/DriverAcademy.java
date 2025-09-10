package com.example.basicboardv1.academy.domain;

import com.example.basicboardv1.user.domain.Driver;
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
@Table(name = "driver_academy")
public class
DriverAcademy {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academy_id", nullable = false)
    private Academy academy;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "work_status", nullable = false)
    private WorkStatus workStatus;
    
    @Column(name = "notes")
    private String notes;
    
    public enum WorkStatus {
        ON_DUTY,        // 출근
        OFF_DUTY,       // 퇴근
        ON_ROUTE,       // 운행중
        ON_BREAK,       // 휴게시간
        ON_VACATION,    // 휴가중
        SICK_LEAVE      // 병가
    }
    
    @PrePersist
    protected void onCreate() {
        this.workStatus = WorkStatus.OFF_DUTY;
    }
}