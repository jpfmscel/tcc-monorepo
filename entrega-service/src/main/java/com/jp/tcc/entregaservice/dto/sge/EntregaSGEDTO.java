package com.jp.tcc.entregaservice.dto.sge;

import com.jp.tcc.entregaservice.enums.EnumEntregaStatus;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class EntregaSGEDTO {

	String entregaId;
	String titulo;
	String remetente;
	String destinatario;
	Float pesoEmKg;
	EnumEntregaStatus status;
	
}
