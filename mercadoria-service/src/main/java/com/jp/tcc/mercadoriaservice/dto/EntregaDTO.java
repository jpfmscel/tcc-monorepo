package com.jp.tcc.mercadoriaservice.dto;

import java.time.LocalDateTime;

import com.jp.tcc.mercadoriaservice.enums.EnumEntregaStatus;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class EntregaDTO {

	@NonNull
	String entregaId;
	
//	@NonNull
	GeoLocation geolocation;
	
//	@NonNull
	LocalDateTime lastUpdate;
	
	@NonNull
	EnumEntregaStatus status;
	
}
