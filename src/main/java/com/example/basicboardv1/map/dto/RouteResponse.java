package com.example.basicboardv1.map.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class RouteResponse {
    private List<Route> routes;
    private TransInfo transInfo;

    @Data
    public static class Route {
        @JsonProperty("result_code")
        private int resultCode;

        @JsonProperty("result_msg")
        private String resultMsg;

        private Summary summary;
        private List<Section> sections;
    }

    @Data
    public static class TransInfo {
        private String fare;
        private String totalTime;
        private String totalDistance;
    }

    @Data
    public static class Summary {
        private Origin origin;
        private Destination destination;
        private List<Waypoint> waypoints;
        private String priority;
        private Bound bound;
        private Fare fare;
        private int distance;
        private int duration;
    }

    @Data
    public static class Origin {
        private String name;
        private double x;
        private double y;
    }

    @Data
    public static class Destination {
        private String name;
        private double x;
        private double y;
    }

    @Data
    public static class Waypoint {
        private String name;
        private double x;
        private double y;
    }

    @Data
    public static class Bound {
        @JsonProperty("min_x")
        private double minX;
        @JsonProperty("min_y")
        private double minY;
        @JsonProperty("max_x")
        private double maxX;
        @JsonProperty("max_y")
        private double maxY;
    }

    @Data
    public static class Fare {
        private int taxi;
        private int toll;
    }

    @Data
    public static class Section {
        private int distance;
        private int duration;
        private Bound bound;
        private List<Road> roads;
        private List<Guide> guides;
    }

    @Data
    public static class Road {
        private String name;
        private int distance;
        private int duration;
        @JsonProperty("traffic_speed")
        private double trafficSpeed;
        @JsonProperty("traffic_state")
        private int trafficState;
        private List<double[]> vertexes;
    }

    @Data
    public static class Guide {
        private String name;
        private double x;
        private double y;
        private int distance;
        private int duration;
        private int type;
        private String guidance;
        @JsonProperty("road_index")
        private int roadIndex;
    }
}