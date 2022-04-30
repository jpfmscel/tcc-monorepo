package com.jp.tcc.entregaservice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.jp.tcc.entregaservice.cqrs.query.IQuery;
import com.jp.tcc.entregaservice.cqrs.query.IQueryRequest;
import com.jp.tcc.entregaservice.cqrs.query.IQueryResponse;

@Component
public class AutowiredHelper {

	@Autowired
	private ApplicationContext appContext;
	
	public IQuery<IQueryRequest, IQueryResponse> getQuery(Class<? extends IQuery> clazz) {
		return (IQuery) appContext.getBean(clazz);
	} 
}
