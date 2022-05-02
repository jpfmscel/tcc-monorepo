package com.jp.tcc.entregaservice.cqrs.comando.entrega.atualizarEntrega;

import java.util.ArrayList;
import java.util.List;

import com.jp.tcc.entregaservice.cqrs.comando.IComandoRequest;
import com.jp.tcc.entregaservice.dto.GeoLocation;
import com.jp.tcc.entregaservice.dto.Problem;
import com.jp.tcc.entregaservice.enums.EnumEntregaStatus;

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
	public List<Problem> validate() {
		List<Problem> problems = new ArrayList<>();
		
		if(entregaId==null || entregaId.isBlank()) {
			problems.add(new Problem("ID da entrega eh invalido"));
		}
		
		if(geolocation.isValid()) {
			problems.add(new Problem("Geolocalizacao eh invalida"));
		}
		
		return problems;
	}
	
}
