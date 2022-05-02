package com.jp.tcc.mercadoriaservice.cqrs.query;

import java.util.List;

import com.jp.tcc.mercadoriaservice.dto.Problem;

public interface IQueryRequest {

	List<Problem> validate();
}
