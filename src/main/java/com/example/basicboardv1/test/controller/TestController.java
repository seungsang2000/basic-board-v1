package com.example.basicboardv1.test.controller;


import com.example.basicboardv1.test.dto.MessageDto;
import com.example.basicboardv1.test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping("Testing")
    public ResponseEntity<MessageDto> test() {
        String message = testService.getTestMessage();
        return ResponseEntity.ok(new MessageDto(message));
    }
}
