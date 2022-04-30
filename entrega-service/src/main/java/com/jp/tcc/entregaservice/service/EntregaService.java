package com.jp.tcc.entregaservice.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.tcc.entregaservice.cqrs.query.entrega.getEntregaById.GetEntregaByIdQuery;
import com.jp.tcc.entregaservice.cqrs.query.entrega.getEntregaById.GetEntregaByIdQueryRequest;
import com.jp.tcc.entregaservice.cqrs.query.entrega.getEntregaById.GetEntregaByIdQueryResponse;
import com.jp.tcc.entregaservice.dto.EntregaDTO;
import com.jp.tcc.entregaservice.dto.request.AtualizarEntregaRequestDTO;
import com.jp.tcc.entregaservice.exception.BadRequestException;
import com.jp.tcc.entregaservice.pubsub.IMessagePublisher;
import com.jp.tcc.entregaservice.pubsub.Message;
import com.jp.tcc.entregaservice.util.AutowiredHelper;
import com.jp.tcc.entregaservice.validator.EntregaValidator;

@Service
public class EntregaService {

	private final IMessagePublisher messagePublisher;

	@Autowired
	private AutowiredHelper autowiredHelper;
	
	@Autowired
	public EntregaService(IMessagePublisher messagePublisher) {
		this.messagePublisher = messagePublisher;
	}

	public EntregaDTO buscarEntrega(String entregaId) {
		
		var request = GetEntregaByIdQueryRequest.builder().entregaId(entregaId).build();
		var response = ((GetEntregaByIdQueryResponse)autowiredHelper.getQuery(GetEntregaByIdQuery.class).execute(request));
		
		return EntregaDTO.builder().entregaId(entregaId).status(response.getStatus()).build();
	}

	public void atualizarEntrega(String entregaId, AtualizarEntregaRequestDTO entregaRequest) {

		var errorList = EntregaValidator.validate(entregaRequest);

		if (!errorList.isEmpty()) {
			throw new BadRequestException(errorList);
		}

		var entrega = EntregaDTO.builder().entregaId(entregaId).geolocation(entregaRequest.getGeolocation())
				.lastUpdate(LocalDateTime.now()).status(entregaRequest.getStatus()).build();

		var message = Message.builder().key(entregaId).value(entrega).build();
		
		messagePublisher.publish(message);
	}
}
