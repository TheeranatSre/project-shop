package com.project.shop.projectshop.repository;

import com.project.shop.projectshop.model.healthcheck.HealthCheckEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthCheckRepository extends JpaRepository<HealthCheckEntity, Integer> {
}
