package com.jp.tcc.entregaservice.controller.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jp.tcc.entregaservice.dto.GenericResponse;
import com.jp.tcc.entregaservice.exception.BadRequestException;
import com.jp.tcc.entregaservice.util.GenericResponseUtils;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<GenericResponse> handleEntityNotFoundException(BadRequestException e, WebRequest request) {
		return ResponseEntity.badRequest().body(GenericResponseUtils.buildGenericResponseError("Bad Request", e.getErrorMessages()));
	}

}