package com.project.shop.projectshop.model.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ValidateException extends Exception implements ShopException {
    private static final long serialVersionUID = 1L;

    private static final String ECODE = "00002";
    private final String errorCode;
    private final String errorMessage;

    public ValidateException(String message) {
        super(message);
        this.errorCode = ECODE;
        this.errorMessage = message;
    }
}
