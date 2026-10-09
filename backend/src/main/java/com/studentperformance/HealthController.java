package com.studentperformance;

import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.Map;

@RestController
public class HealthController {
    @GetMapping("/health")
    public Map<String, Object> health() {
        return Map.of("status", "API running", "service", "student-performance-api", "timestamp", Instant.now().toString());
    }
    @GetMapping("/")
    public Map<String, String> root() {
        return Map.of("message", "Student Performance Analysis System API", "health", "/health");
    }
}