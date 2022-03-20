package com.project.shop.projectshop.handler;

import javax.servlet.http.HttpServletRequest;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import com.project.shop.projectshop.model.common.ApiError;
import com.project.shop.projectshop.model.exception.ApiException;
import com.project.shop.projectshop.model.exception.ShopException;
import com.project.shop.projectshop.model.exception.ValidateException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {
    @ExceptionHandler({ Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)

	@ResponseBody
    public ApiError databaseError(HttpServletRequest req, Exception ex) {
		String errorCode = getErrorCode(HttpStatus.INTERNAL_SERVER_ERROR);
		ApiError error = null;
		String statusCode = getStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
		error = new ApiError(statusCode, errorCode, "System cannot process");

		StringWriter errors = new StringWriter();
		ex.printStackTrace(new PrintWriter(errors));
		log.error(errors.toString());
		return error;
	}

  @ExceptionHandler({ ApiException.class, ValidateException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ApiError handleApiException(HttpServletRequest req, Exception ex) {
		String statusCode = getStatusCode(HttpStatus.BAD_REQUEST);
		ShopException apiException = null;
		if (ex instanceof ApiException) {
			apiException = (ApiException) ex;
		} else if (ex instanceof ValidateException) {
			apiException = (ValidateException) ex;
		} else {
			apiException = new ApiException(statusCode, "System cannot process");
		}
		StringWriter errors = new StringWriter();
		ex.printStackTrace(new PrintWriter(errors));
		log.error(errors.toString());
		return new ApiError(statusCode, apiException.getErrorCode(), apiException.getErrorMessage());
	}

	@ExceptionHandler({ ServletRequestBindingException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ApiError handleServletRequestBindingException(HttpServletRequest req, Exception ex) {
		String statusCode = getStatusCode(HttpStatus.BAD_REQUEST);
		String errorCode = getErrorCode(HttpStatus.BAD_REQUEST);
		ServletRequestBindingException requestException = (ServletRequestBindingException) ex;

		return new ApiError(statusCode, errorCode, requestException.getMessage());
	}

	@ExceptionHandler({ MethodArgumentNotValidException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ApiError handleMethodArgumentNotValidException(HttpServletRequest req, Exception ex) {
		String statusCode = getStatusCode(HttpStatus.BAD_REQUEST);
		String errorCode = getErrorCode(HttpStatus.BAD_REQUEST);
		Errors errors = ((MethodArgumentNotValidException) ex).getBindingResult();
		List<ApiError> errorList = new ArrayList<>();
		for (ObjectError item : errors.getAllErrors()) {
			errorList.add(new ApiError(statusCode, errorCode, item.getDefaultMessage()));

		}

		return errorList.get(0);
	}

	@ExceptionHandler({ HttpMessageNotReadableException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ApiError emptyRequestError(HttpServletRequest req, Exception ex) {
		String statusCode = getStatusCode(HttpStatus.BAD_REQUEST);
		String errorCode = getErrorCode(HttpStatus.BAD_REQUEST);
		return new ApiError(statusCode, errorCode, "Please insert request body");
	}

    private String getErrorCode(HttpStatus httpStatus) {
		return String.valueOf(httpStatus.value());
	}

    private String getStatusCode(HttpStatus httpStatus) {
		return String.valueOf(httpStatus.getReasonPhrase());
	}
}
