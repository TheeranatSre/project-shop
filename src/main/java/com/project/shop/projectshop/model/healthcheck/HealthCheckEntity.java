package com.project.shop.projectshop.model.healthcheck;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "project_shop", name = "health_check")
public class HealthCheckEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "status")
    private String status;
}
