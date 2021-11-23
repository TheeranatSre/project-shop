package com.project.shop.projectshop.controller;

import com.project.shop.projectshop.model.healthcheck.HealthcheckEntity;
import com.project.shop.projectshop.model.healthcheck.response.HealthcheckResponse;
import com.project.shop.projectshop.repository.healthcheck.HealthCheckRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HealthcheckController {
    @Value("${api.version}")
    private String apiVersion;

    private @Autowired HealthCheckRepository healthCheckRepository;

    @GetMapping("/healthcheck")
    @ResponseBody
    public HealthcheckResponse getHealthcheck() {
        HealthcheckEntity healthcheck = healthCheckRepository.getOne(1);

        return new HealthcheckResponse(healthcheck.getStatus(), apiVersion);
    }
}
