package com.jp.tcc.entregaservice.cqrs.query.entrega.getEntregaById;

import java.util.List;
import java.util.stream.Collectors;

import com.jp.tcc.entregaservice.cqrs.query.IQuery;
import com.jp.tcc.entregaservice.dto.Problem;
import com.jp.tcc.entregaservice.exception.BadRequestException;

public class GetEntregaByIdQuery implements IQuery<GetEntregaByIdQueryRequest, GetEntregaByIdQueryResponse> {

	
	
	@Override
	public GetEntregaByIdQueryResponse execute(GetEntregaByIdQueryRequest request) {

		List<Problem> problems = request.validate();
		if (!problems.isEmpty()) {
			throw new BadRequestException(problems.stream().map(Problem::getSummary).collect(Collectors.toList()));
		}
		
		
		return null;
	}

}
