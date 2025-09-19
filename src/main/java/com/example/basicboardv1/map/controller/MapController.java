package com.example.basicboardv1.map.controller;

import com.example.basicboardv1.map.config.KakaoMapConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/map")
@RequiredArgsConstructor
public class MapController {

    private final KakaoMapConfig kakaoMapConfig;

    @GetMapping
    public String mapPage(Model model) {
        model.addAttribute("kakaoJavascriptKey", kakaoMapConfig.getJavascriptKey());
        return "map/map";
    }
}