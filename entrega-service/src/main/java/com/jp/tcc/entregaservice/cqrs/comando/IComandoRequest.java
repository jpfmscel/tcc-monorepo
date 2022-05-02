package com.jp.tcc.entregaservice.cqrs.comando;

import java.util.List;

import com.jp.tcc.entregaservice.dto.Problem;

public interface IComandoRequest {

	List<Problem> validateInput();
}
