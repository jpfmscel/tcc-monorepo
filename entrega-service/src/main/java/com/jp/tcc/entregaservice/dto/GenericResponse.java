package com.jp.tcc.entregaservice.dto;

import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GenericResponse {

	private String status;
	private Integer code;
	private List<String> messages;
	private Object data;
	
}