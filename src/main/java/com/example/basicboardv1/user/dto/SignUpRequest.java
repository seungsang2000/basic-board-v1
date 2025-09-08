package com.example.basicboardv1.user.dto;

import com.example.basicboardv1.user.domain.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SignUpRequest {
    
    @NotBlank(message = "이메일은 필수입니다")
    @Email(message = "올바른 이메일 형식이 아닙니다")
    private String email;
    
    @NotBlank(message = "비밀번호는 필수입니다")
    private String password;
    
    @NotBlank(message = "전화번호는 필수입니다")
    private String phoneNumber;
    
    @NotNull(message = "성별은 필수입니다")
    private Integer gender;
    
    private String address;
    
    @NotNull(message = "역할은 필수입니다")
    private Role role;
    
    private List<Long> academyIds;
}