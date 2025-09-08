package com.example.basicboardv1.user.service;

import com.example.basicboardv1.academy.repository.AcademyRepository;
import com.example.basicboardv1.common.exception.CustomException;
import com.example.basicboardv1.common.exception.ErrorCode;
import com.example.basicboardv1.user.domain.Users;
import com.example.basicboardv1.user.dto.LoginRequest;
import com.example.basicboardv1.user.dto.LoginResponse;
import com.example.basicboardv1.user.dto.SignUpRequest;
import com.example.basicboardv1.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    
    private final UserRepository userRepository;
    private final AcademyRepository academyRepository;
    
    @Transactional
    public Long signUp(SignUpRequest request) {
        // 이메일 중복 체크
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new CustomException(ErrorCode.DUPLICATE_EMAIL);
        }
        
        // Users 엔티티 생성
        Users user = new Users();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // 실제로는 암호화 필요
        user.setPhoneNumber(request.getPhoneNumber());
        user.setGender(request.getGender());
        user.setAddress(request.getAddress());
        user.setRole(request.getRole());
        
        Users savedUser = userRepository.save(user);
        return savedUser.getId();
    }
    
    public LoginResponse login(LoginRequest request) {
        Users user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
        
        // 비밀번호 검증 (실제로는 암호화된 비밀번호와 비교. 여기서는 단순 비교)
        if (!user.getPassword().equals(request.getPassword())) {
            throw new CustomException(ErrorCode.INVALID_PASSWORD);
        }
        
        return new LoginResponse(
            user.getId(),
            user.getEmail(),
            user.getRole(),
            "로그인 성공"
        );
    }
    
    public Users findById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
    }
}
