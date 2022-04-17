package com.jp.tcc.entregaservice.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.tcc.entregaservice.dto.EntregaDTO;
import com.jp.tcc.entregaservice.dto.request.AtualizarEntregaRequestDTO;
import com.jp.tcc.entregaservice.exception.BadRequestException;
import com.jp.tcc.entregaservice.pubsub.IMessagePublisher;
import com.jp.tcc.entregaservice.pubsub.Message;
import com.jp.tcc.entregaservice.validator.EntregaValidator;

@Service
public class EntregaService {

	private final IMessagePublisher messagePublisher;

	@Autowired
	public EntregaService(IMessagePublisher messagePublisher) {
		this.messagePublisher = messagePublisher;
	}
	
	public void atualizarEntrega(String entregaId, AtualizarEntregaRequestDTO entregaRequest) {
		
		var errorList = EntregaValidator.validate(entregaRequest);
		
		if(!errorList.isEmpty()) {
			throw new BadRequestException(errorList);
		}
		
		var entrega = EntregaDTO.builder().entregaId(entregaId).geolocation(entregaRequest.getGeolocation()).lastUpdate(LocalDateTime.now()).status(entregaRequest.getStatus()).build();
		
		var message = Message.builder().key(entregaId).value(entrega).build();
		messagePublisher.publish(message);
	}
}
