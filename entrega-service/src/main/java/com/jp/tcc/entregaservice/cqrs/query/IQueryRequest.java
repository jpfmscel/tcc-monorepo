package com.jp.tcc.entregaservice.cqrs.query;

import java.util.List;

import com.jp.tcc.entregaservice.dto.Problem;

public interface IQueryRequest {

	List<Problem> validate();
}
