package com.example.basicboardv1.map.dto;

import lombok.Data;

@Data
public class RouteRequest {
    private String originX;
    private String originY;
    private String destinationX;
    private String destinationY;
    private String originName;
    private String destinationName;
}