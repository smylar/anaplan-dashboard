package com.example.dashboard.repository;

import com.example.dashboard.model.DashboardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepository  extends JpaRepository<DashboardEntity, Long> {
}
