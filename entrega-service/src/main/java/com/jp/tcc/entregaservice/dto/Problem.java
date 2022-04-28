package com.jp.tcc.entregaservice.dto;

import lombok.Value;

@Value
public class Problem {
	String summary;
	String description;

	public Problem(String summary) {
		this.summary = summary;
		this.description = "";
	}
}
