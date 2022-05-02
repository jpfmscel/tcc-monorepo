package com.jp.tcc.mercadoriaservice.cqrs.query.entrega.getEntregaById;

import com.jp.tcc.mercadoriaservice.cqrs.query.IQueryResponse;
import com.jp.tcc.mercadoriaservice.enums.EnumEntregaStatus;

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
