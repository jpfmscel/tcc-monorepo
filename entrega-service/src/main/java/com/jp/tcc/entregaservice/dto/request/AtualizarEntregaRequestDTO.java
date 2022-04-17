package com.jp.tcc.entregaservice.dto.request;

import com.jp.tcc.entregaservice.dto.GeoLocation;
import com.jp.tcc.entregaservice.enums.EnumEntregaStatus;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class AtualizarEntregaRequestDTO {

	@NonNull
	GeoLocation geolocation;
	
	@NonNull
	EnumEntregaStatus status;
}
