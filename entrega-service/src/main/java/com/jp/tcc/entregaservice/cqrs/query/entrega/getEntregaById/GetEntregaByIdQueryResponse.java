package com.jp.tcc.entregaservice.cqrs.query.entrega.getEntregaById;

import com.jp.tcc.entregaservice.cqrs.query.IQueryResponse;
import com.jp.tcc.entregaservice.enums.EnumEntregaStatus;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GetEntregaByIdQueryResponse implements IQueryResponse {

	String entregaId;
	String titulo;
	String remetente;
	String destinatario;
	Float pesoEmKg;
	EnumEntregaStatus status;
}
