package com.jp.tcc.entregaservice.facade;

import java.time.Instant;

import org.springframework.stereotype.Component;

import com.jp.tcc.entregaservice.dto.sge.EntregaSGEDTO;
import com.jp.tcc.entregaservice.enums.EnumEntregaStatus;

@Component
public class SGEFacade {

	public EntregaSGEDTO buscarEntrega(String id) {
		return EntregaSGEDTO.builder()
				.destinatario("Destinatario " + Instant.now().getEpochSecond())
				.entregaId(String.valueOf(Instant.now().getNano()))
				.pesoEmKg(Float.valueOf(String.valueOf(Math.random())))
				.remetente("Remetente " + Instant.now().getEpochSecond())
				.status(EnumEntregaStatus.EM_PREPARO)
				.titulo("Entrega " + String.valueOf(Math.random()))
				.build();
	}

}
