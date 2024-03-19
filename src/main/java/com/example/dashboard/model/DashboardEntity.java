package com.example.dashboard.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder(toBuilder = true)
@Entity
@Table(name="dashboards")
@NoArgsConstructor
@AllArgsConstructor
public class DashboardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "createdAt", insertable = false, updatable = false) //we can use the defaults on the table
    private Timestamp createdAt;
    @Column(name = "updatedAt", insertable = false, updatable = false)
    private Timestamp updatedAt;
}
