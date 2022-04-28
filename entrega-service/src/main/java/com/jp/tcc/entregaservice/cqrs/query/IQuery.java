package com.jp.tcc.entregaservice.cqrs.query;

public interface IQuery<S extends IQueryRequest, T extends IQueryResponse> {

	T execute(S request);

}
