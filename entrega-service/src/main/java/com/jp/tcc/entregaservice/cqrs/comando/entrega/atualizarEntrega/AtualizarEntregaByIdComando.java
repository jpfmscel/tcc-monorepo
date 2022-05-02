package com.jp.tcc.entregaservice.cqrs.comando.entrega.atualizarEntrega;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jp.tcc.entregaservice.cqrs.comando.IComando;
import com.jp.tcc.entregaservice.dto.EntregaDTO;
import com.jp.tcc.entregaservice.dto.Problem;
import com.jp.tcc.entregaservice.dto.sge.EntregaSGEDTO;
import com.jp.tcc.entregaservice.exception.BadRequestException;
import com.jp.tcc.entregaservice.facade.SGEFacade;
import com.jp.tcc.entregaservice.pubsub.Message;

@Component
public class AtualizarEntregaByIdComando implements IComando<AtualizarEntregaByIdComandoRequest> {

	@Override
	public void execute(AtualizarEntregaByIdComandoRequest request) {

		List<Problem> problems = request.validate();
		if (!problems.isEmpty()) {
			throw new BadRequestException(problems.stream().map(Problem::getSummary).collect(Collectors.toList()));
		}

		var entrega = EntregaDTO.builder().entregaId(entregaId).geolocation(entregaRequest.getGeolocation())
				.lastUpdate(LocalDateTime.now()).status(entregaRequest.getStatus()).build();

		var message = Message.builder().key(entregaId).value(entrega).build();
		
		messagePublisher.publish(message);
		
	}

}
