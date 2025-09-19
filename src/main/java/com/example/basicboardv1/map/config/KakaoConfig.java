package com.example.basicboardv1.map.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "kakao.map")
@Getter
@Setter
public class KakaoConfig {
    private String javascriptKey;
    private String restApiKey;
}