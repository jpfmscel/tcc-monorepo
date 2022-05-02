package com.jp.tcc.mercadoriaservice.cqrs.comando.entrega.atualizarEntrega;

import java.util.ArrayList;
import java.util.List;

import com.jp.tcc.mercadoriaservice.cqrs.comando.IComandoRequest;
import com.jp.tcc.mercadoriaservice.dto.GeoLocation;
import com.jp.tcc.mercadoriaservice.dto.Problem;
import com.jp.tcc.mercadoriaservice.enums.EnumEntregaStatus;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class AtualizarEntregaByIdComandoRequest implements IComandoRequest{

	@NonNull
	private final String entregaId;

	@NonNull
	private final GeoLocation geolocation;
	
	@NonNull
	private final EnumEntregaStatus status;
	
	@Override
	public List<Problem> validateInput() {
		List<Problem> problems = new ArrayList<>();
		
		if(entregaId==null || entregaId.isBlank()) {
			problems.add(new Problem("ID da entrega eh invalido"));
		}
		
		if(!geolocation.isValid()) {
			problems.add(new Problem("Geolocalizacao eh invalida"));
		}
		
		return problems;
	}
	
}
