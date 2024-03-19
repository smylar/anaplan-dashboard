package com.example.dashboard.service;

import com.example.dashboard.domain.Dashboard;
import com.example.dashboard.repository.DashboardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    private final DashboardRepository repository;

    public DashboardService(DashboardRepository repository) {
        this.repository = repository;
    }

    public List<Dashboard> getDashboards() {

        return repository.findAll()
                .stream()
                .map(Dashboard::fromEntity)
                .toList();
    }
}
