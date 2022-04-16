package com.jp.tcc.entregaservice.controller.advice;

import javax.naming.ConfigurationException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jp.tcc.entregaservice.dto.GenericResponse;
import com.jp.tcc.entregaservice.util.GenericResponseUtils;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

//	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<GenericResponse> handleEntityNotFoundException(Exception e, WebRequest request) {
		ResponseEntity<GenericResponse> response = buildGenericResponse(e);
		return response;
	}

	private ResponseEntity<GenericResponse> buildGenericResponse(Exception e) {
		return ResponseEntity.badRequest().body(GenericResponseUtils.buildGenericResponseError(e));
	}

}