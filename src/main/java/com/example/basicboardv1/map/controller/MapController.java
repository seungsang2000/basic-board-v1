package com.example.basicboardv1.map.controller;

import com.example.basicboardv1.map.config.KakaoMapConfig;
import com.example.basicboardv1.map.dto.RouteRequest;
import com.example.basicboardv1.map.dto.SimpleRouteResponse;
import com.example.basicboardv1.map.service.KakaoRouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/map")
@RequiredArgsConstructor
public class MapController {

    private final KakaoMapConfig kakaoMapConfig;
    private final KakaoRouteService kakaoRouteService;

    @GetMapping
    public String mapPage(Model model) {
        model.addAttribute("kakaoJavascriptKey", kakaoMapConfig.getJavascriptKey());
        return "map/map";
    }

    @PostMapping("/route")
    @ResponseBody
    public ResponseEntity<SimpleRouteResponse> findRoute(@RequestBody RouteRequest request) {
        try {
            SimpleRouteResponse route = kakaoRouteService.findRoute(request);
            return ResponseEntity.ok(route);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}