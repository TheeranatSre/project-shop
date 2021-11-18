package com.project.shop.projectshop.controller;


import com.project.shop.projectshop.model.exception.ApiException;
import com.project.shop.projectshop.model.healthcheck.HealthCheckEntity;
import com.project.shop.projectshop.model.healthcheck.response.HealthcheckResponse;
import com.project.shop.projectshop.repository.HealthCheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

	private @Autowired HealthCheckRepository healthCheckRepository;

	@Value("${api.version}")
	private String apiVersion;

	@GetMapping("/healthcheck")
	public HealthcheckResponse getHealthcheck() throws ApiException {
		HealthCheckEntity healthcheck = healthCheckRepository.findById(1)
				.orElseThrow(() -> new ApiException("404", "healthcheck object not found."));
		return new HealthcheckResponse(healthcheck.getStatus(), apiVersion);
	}

}
