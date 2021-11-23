package com.project.shop.projectshop.repository.healthcheck;

import com.project.shop.projectshop.model.healthcheck.HealthcheckEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthCheckRepository extends JpaRepository<HealthcheckEntity, Integer> {
}
