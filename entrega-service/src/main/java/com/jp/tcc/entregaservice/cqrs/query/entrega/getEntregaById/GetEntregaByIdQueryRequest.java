package com.jp.tcc.entregaservice.cqrs.query.entrega.getEntregaById;

import java.util.ArrayList;
import java.util.List;

import com.jp.tcc.entregaservice.cqrs.query.IQueryRequest;
import com.jp.tcc.entregaservice.dto.Problem;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetEntregaByIdQueryRequest implements IQueryRequest{

	private final String entregaId;

	@Override
	public List<Problem> validate() {
		List<Problem> problems = new ArrayList<>();
		
		if(entregaId==null || entregaId.isBlank()) {
			problems.add(new Problem("ID da entrega eh invalido"));
		}
		
		return problems;
	}
	
}
