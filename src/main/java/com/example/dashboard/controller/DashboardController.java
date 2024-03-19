package com.example.dashboard.controller;

import com.example.dashboard.domain.Dashboard;
import com.example.dashboard.service.DashboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("dashboards")
    public ResponseEntity<List<Dashboard>> getDashboards() {
        List<Dashboard> dashboards = dashboardService.getDashboards();
        if (dashboards.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(dashboards);
    }
}
