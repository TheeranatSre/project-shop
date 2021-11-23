package com.project.shop.projectshop.model.healthcheck.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HealthcheckResponse {

	private String status;

	private String version;

}

