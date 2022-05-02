package com.jp.tcc.mercadoriaservice.cqrs.comando.entrega.atualizarEntrega;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jp.tcc.mercadoriaservice.cqrs.comando.IComando;
import com.jp.tcc.mercadoriaservice.dto.Problem;
import com.jp.tcc.mercadoriaservice.exception.BadRequestException;
import com.jp.tcc.mercadoriaservice.pubsub.IMessagePublisher;
import com.jp.tcc.mercadoriaservice.pubsub.Message;
import com.jp.tcc.mercadoriaservice.pubsub.messagesDTO.AtualizarEntregaByIdMessage;

@Component
public class AtualizarEntregaByIdComando implements IComando<AtualizarEntregaByIdComandoRequest> {

	@Autowired
	private IMessagePublisher messagePublisher;
	
	@Override	
	public void execute(AtualizarEntregaByIdComandoRequest request) {

		List<Problem> problems = request.validateInput();
		if (!problems.isEmpty()) {
			throw new BadRequestException(problems.stream().map(Problem::getSummary).collect(Collectors.toList()));
		}
		
		var payload = AtualizarEntregaByIdMessage.builder().entregaId(request.getEntregaId()).geolocation(request.getGeolocation())
				.lastUpdate(LocalDateTime.now()).status(request.getStatus()).build();

		var message = Message.builder().key(request.getEntregaId()).value(payload).build();
		
		messagePublisher.publish(message);
	}

}
