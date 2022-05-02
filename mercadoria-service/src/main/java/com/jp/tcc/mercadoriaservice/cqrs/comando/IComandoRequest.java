package com.jp.tcc.mercadoriaservice.cqrs.comando;

import java.util.List;

import com.jp.tcc.mercadoriaservice.dto.Problem;

public interface IComandoRequest {

	List<Problem> validateInput();
}
