package com.jp.tcc.entregaservice.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.ImmutableMap;
import com.jp.tcc.entregaservice.cqrs.comando.IComando;
import com.jp.tcc.entregaservice.cqrs.comando.entrega.atualizarEntrega.AtualizarEntregaByIdComando;
import com.jp.tcc.entregaservice.cqrs.query.IQuery;
import com.jp.tcc.entregaservice.cqrs.query.entrega.getEntregaById.GetEntregaByIdQuery;

@Configuration
public class AutowiredCQRSHelper {

	@Autowired
	private ApplicationContext appContext;
	
	/**
	 * Every new IQuery implementation must be added in this map in order to be used in application scope
	 * @return @Map of query implementation objects by their respective class types
	 */
	@SuppressWarnings("rawtypes")
	@Bean
	public Map<Class<? extends IQuery>, ? extends IQuery> queryMap(){
		return ImmutableMap.<Class<? extends IQuery>, IQuery>builder()
				.put(GetEntregaByIdQuery.class, (GetEntregaByIdQuery) appContext.getBean(GetEntregaByIdQuery.class))
		.build();
	}
	
	/**
	 * Every new IComando implementation must be added in this map in order to be used in application scope
	 * @return @Map of comando implementation objects by their respective class types
	 */
	@SuppressWarnings("rawtypes")
	@Bean
	public Map<Class<? extends IComando>, ? extends IComando> comandoMap(){
		return ImmutableMap.<Class<? extends IComando>, IComando>builder()
				.put(AtualizarEntregaByIdComando.class, (AtualizarEntregaByIdComando) appContext.getBean(AtualizarEntregaByIdComando.class))
		.build();
	}
	
}
