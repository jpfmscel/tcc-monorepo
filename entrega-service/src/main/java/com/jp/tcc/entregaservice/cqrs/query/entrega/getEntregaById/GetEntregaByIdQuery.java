package com.jp.tcc.entregaservice.cqrs.query.entrega.getEntregaById;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.jp.tcc.entregaservice.cqrs.query.IQuery;
import com.jp.tcc.entregaservice.dto.Problem;
import com.jp.tcc.entregaservice.enums.EnumEntregaStatus;
import com.jp.tcc.entregaservice.exception.BadRequestException;
import com.jp.tcc.entregaservice.repository.EntregaRepository;

@Component
public class GetEntregaByIdQuery implements IQuery<GetEntregaByIdQueryRequest, GetEntregaByIdQueryResponse> {

	private EntregaRepository entregaRepository;
	
	@Override
	public GetEntregaByIdQueryResponse execute(GetEntregaByIdQueryRequest request) {

		List<Problem> problems = request.validate();
		if (!problems.isEmpty()) {
			throw new BadRequestException(problems.stream().map(Problem::getSummary).collect(Collectors.toList()));
		}

		GetEntregaByIdQueryResponse response = GetEntregaByIdQueryResponse.builder()
				.destinatario("Destinatario " + Instant.now().getEpochSecond())
				.entregaId(String.valueOf(Instant.now().getNano()))
				.pesoEmKg(Float.valueOf(String.valueOf(Math.random())))
				.remetente("Remetente " + Instant.now().getEpochSecond())
				.status(EnumEntregaStatus.EM_PREPARO)
				.titulo("Entrega " + String.valueOf(Math.random()))
				.build();
		
		return	response;
	}

}
