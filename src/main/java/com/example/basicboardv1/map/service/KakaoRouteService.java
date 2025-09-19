package com.example.basicboardv1.map.service;

import com.example.basicboardv1.map.config.KakaoConfig;
import com.example.basicboardv1.map.dto.RouteRequest;
import com.example.basicboardv1.map.dto.SimpleRouteResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class KakaoRouteService {

    private final KakaoConfig kakaoConfig;
    private final RestTemplate restTemplate = new RestTemplate();

    private static final String KAKAO_MOBILITY_URL = "https://apis-navi.kakaomobility.com/v1/directions";

    public SimpleRouteResponse findRoute(RouteRequest request) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "KakaoAK " + kakaoConfig.getRestApiKey());
            headers.set("Content-Type", "application/json");

            String url = UriComponentsBuilder.fromHttpUrl(KAKAO_MOBILITY_URL)
                    .queryParam("origin", request.getOriginX() + "," + request.getOriginY())
                    .queryParam("destination", request.getDestinationX() + "," + request.getDestinationY())
                    .queryParam("priority", "RECOMMEND")
                    .queryParam("car_fuel", "GASOLINE")
                    .queryParam("car_hipass", "false")
                    .queryParam("alternatives", "false")
                    .queryParam("road_details", "false")
                    .build()
                    .toUriString();

            log.info("카카오 모빌리티 API 호출: {}", url);

            HttpEntity<?> entity = new HttpEntity<>(headers);
            ResponseEntity<Map> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    Map.class
            );

            Map<String, Object> routeResponse = response.getBody();
            if (routeResponse == null || !routeResponse.containsKey("routes")) {
                throw new RuntimeException("경로를 찾을 수 없습니다.");
            }

            List<Map<String, Object>> routes = (List<Map<String, Object>>) routeResponse.get("routes");
            if (routes.isEmpty()) {
                throw new RuntimeException("경로를 찾을 수 없습니다.");
            }

            Map<String, Object> route = routes.get(0);
            Map<String, Object> summary = (Map<String, Object>) route.get("summary");

            int distance = (Integer) summary.get("distance");
            int duration = (Integer) summary.get("duration");

            Map<String, Object> fare = (Map<String, Object>) summary.get("fare");
            int taxiFare = fare != null ? (Integer) fare.get("taxi") : 0;
            int tollFare = fare != null ? (Integer) fare.get("toll") : 0;

            return SimpleRouteResponse.builder()
                    .originName(request.getOriginName())
                    .destinationName(request.getDestinationName())
                    .totalDistance(distance)
                    .totalDuration(duration)
                    .formattedDistance(formatDistance(distance))
                    .formattedDuration(formatDuration(duration))
                    .taxiFare(taxiFare)
                    .tollFare(tollFare)
                    .build();

        } catch (Exception e) {
            log.error("경로 찾기 API 호출 실패", e);
            throw new RuntimeException("경로 찾기에 실패했습니다: " + e.getMessage());
        }
    }

    private String formatDistance(int distanceInMeters) {
        if (distanceInMeters >= 1000) {
            double km = distanceInMeters / 1000.0;
            return String.format("%.1fkm", km);
        }
        return distanceInMeters + "m";
    }

    private String formatDuration(int durationInSeconds) {
        int hours = durationInSeconds / 3600;
        int minutes = (durationInSeconds % 3600) / 60;

        if (hours > 0) {
            return String.format("%d시간 %d분", hours, minutes);
        }
        return minutes + "분";
    }
}