package com.jp.tcc.mercadoriaservice.cqrs.query;

public interface IQuery<S extends IQueryRequest, T extends IQueryResponse> {

	T execute(S request);

}
