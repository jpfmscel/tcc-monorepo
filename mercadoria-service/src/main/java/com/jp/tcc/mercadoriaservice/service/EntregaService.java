package com.jp.tcc.mercadoriaservice.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jp.tcc.mercadoriaservice.cqrs.comando.IComando;
import com.jp.tcc.mercadoriaservice.cqrs.comando.entrega.atualizarEntrega.AtualizarEntregaByIdComando;
import com.jp.tcc.mercadoriaservice.cqrs.comando.entrega.atualizarEntrega.AtualizarEntregaByIdComandoRequest;
import com.jp.tcc.mercadoriaservice.cqrs.query.IQuery;
import com.jp.tcc.mercadoriaservice.cqrs.query.entrega.getEntregaById.GetEntregaByIdQuery;
import com.jp.tcc.mercadoriaservice.cqrs.query.entrega.getEntregaById.GetEntregaByIdQueryRequest;
import com.jp.tcc.mercadoriaservice.cqrs.query.entrega.getEntregaById.GetEntregaByIdQueryResponse;
import com.jp.tcc.mercadoriaservice.dto.request.AtualizarEntregaRequestDTO;
import com.jp.tcc.mercadoriaservice.exception.BadRequestException;
import com.jp.tcc.mercadoriaservice.validator.EntregaValidator;

@Service
@SuppressWarnings({"rawtypes", "unchecked"})
public class EntregaService {

	@Autowired
	@Qualifier("queryMap")
	private Map<Class<? extends IQuery>, ? extends IQuery> queryMap;
	
	@Autowired
	@Qualifier("comandoMap")
	private Map<Class<? extends IComando>, ? extends IComando> comandoMap;
	
	public GetEntregaByIdQueryResponse buscarEntrega(String entregaId) {
		var request = GetEntregaByIdQueryRequest.builder().entregaId(entregaId).build();
		var response = (GetEntregaByIdQueryResponse) queryMap.get(GetEntregaByIdQuery.class).execute(request);
		
		return response;
	}
	
	public void atualizarEntrega(String entregaId, AtualizarEntregaRequestDTO entregaRequest) {

		var errorList = EntregaValidator.validate(entregaRequest);

		if (!errorList.isEmpty()) {
			throw new BadRequestException(errorList);
		}

		var request = AtualizarEntregaByIdComandoRequest.builder()
			.entregaId(entregaId)
			.geolocation(entregaRequest.getGeolocation())
			.status(entregaRequest.getStatus())
		.build();
		
		comandoMap.get(AtualizarEntregaByIdComando.class).execute(request);
		
	}
}
