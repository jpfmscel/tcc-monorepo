package com.jp.tcc.mercadoriaservice.cqrs.query.entrega.getEntregaById;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.jp.tcc.mercadoriaservice.cqrs.query.IQuery;
import com.jp.tcc.mercadoriaservice.dto.Problem;
import com.jp.tcc.mercadoriaservice.enums.EnumEntregaStatus;
import com.jp.tcc.mercadoriaservice.exception.BadRequestException;
import com.jp.tcc.mercadoriaservice.repository.MercadoriaRepository;

@Component
public class GetEntregaByIdQuery implements IQuery<GetEntregaByIdQueryRequest, GetEntregaByIdQueryResponse> {

	private MercadoriaRepository mercadoriaRepository;
	
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
