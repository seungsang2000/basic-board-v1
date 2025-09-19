package com.example.basicboardv1.map.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SimpleRouteResponse {
    private String originName;
    private String destinationName;
    private int totalDistance;
    private int totalDuration;
    private String formattedDistance;
    private String formattedDuration;
    private int taxiFare;
    private int tollFare;
}