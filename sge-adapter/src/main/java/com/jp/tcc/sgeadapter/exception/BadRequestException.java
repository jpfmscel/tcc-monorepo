package com.jp.tcc.sgeadapter.exception;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private List<String> errorMessages;

}
