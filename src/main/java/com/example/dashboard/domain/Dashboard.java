package com.example.dashboard.domain;

import com.example.dashboard.model.DashboardEntity;

import java.time.Instant;

public record Dashboard(Long id,
                        String title,
                        Instant createdAt,
                        Instant updatedAt) {

    public static Dashboard fromEntity(final DashboardEntity entity) {
        return new Dashboard(
                entity.getId(),
                entity.getTitle(),
                entity.getCreatedAt().toInstant(),
                entity.getUpdatedAt() != null ? entity.getUpdatedAt().toInstant() : null
        );
    }
}
