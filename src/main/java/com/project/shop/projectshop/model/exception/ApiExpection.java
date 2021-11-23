package com.project.shop.projectshop.model.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApiExpection extends Exception implements ShopException {
    private static final long serialVersionUID = 1L;

    private final String errorCode;
    private final String errorMessage;

    public ApiExpection(String code, String message) {
        super(message);
        this.errorCode = code;
		this.errorMessage = message;
    }
}
