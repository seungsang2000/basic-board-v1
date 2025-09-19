package com.example.basicboardv1.map.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "kakao.map")
@Data
public class KakaoMapConfig {
    private String javascriptKey;
}