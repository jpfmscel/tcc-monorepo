package com.jp.tcc.sgeadapter.dto;

import java.time.LocalDateTime;

import com.jp.tcc.sgeadapter.enums.EnumEntregaStatus;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class EntregaDTO {

	@NonNull
	String entregaId;
	
	@NonNull
	GeoLocation geolocation;
	
	@NonNull
	LocalDateTime lastUpdate;
	
	@NonNull
	EnumEntregaStatus status;
	
}
