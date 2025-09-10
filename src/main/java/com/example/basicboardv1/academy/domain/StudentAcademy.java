package com.example.basicboardv1.academy.domain;

import com.example.basicboardv1.user.domain.Student;
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
@Table(name = "student_academy")
public class StudentAcademy {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academy_id", nullable = false)
    private Academy academy;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "attendance_status", nullable = false)
    private AttendanceStatus attendanceStatus;
    
    @Column(name = "notes")
    private String notes;
    
    public enum AttendanceStatus {
        PRESENT,        // 출석
        ABSENT,         // 결석
        ON_THE_WAY,     // 등교중
        PICKUP_WAITING, // 하교 대기중
        NOT_SCHEDULED   // 오늘 수업 없음
    }
    
    @PrePersist
    protected void onCreate() {
        this.attendanceStatus = AttendanceStatus.NOT_SCHEDULED;
    }
}