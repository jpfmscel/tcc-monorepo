package com.jp.tcc.entregaservice.cqrs.query.entrega.getEntregaById;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jp.tcc.entregaservice.cqrs.query.IQuery;
import com.jp.tcc.entregaservice.dto.Problem;
import com.jp.tcc.entregaservice.dto.sge.EntregaSGEDTO;
import com.jp.tcc.entregaservice.exception.BadRequestException;
import com.jp.tcc.entregaservice.facade.SGEFacade;

@Component
public class GetEntregaByIdQuery implements IQuery<GetEntregaByIdQueryRequest, GetEntregaByIdQueryResponse> {

	@Autowired
	private SGEFacade sgeFacade;
	
	@Override
	public GetEntregaByIdQueryResponse execute(GetEntregaByIdQueryRequest request) {

		List<Problem> problems = request.validate();
		if (!problems.isEmpty()) {
			throw new BadRequestException(problems.stream().map(Problem::getSummary).collect(Collectors.toList()));
		}

		EntregaSGEDTO buscarEntrega = sgeFacade.buscarEntrega(request.getEntregaId());
		
		return	GetEntregaByIdQueryResponse.builder()
					.destinatario(buscarEntrega.getDestinatario())
					.entregaId(request.getEntregaId())
					.pesoEmKg(buscarEntrega.getPesoEmKg())
					.remetente(buscarEntrega.getRemetente())
					.status(buscarEntrega.getStatus())
					.titulo(buscarEntrega.getTitulo())
				.build();
		
	}

}
