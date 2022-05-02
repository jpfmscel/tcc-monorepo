package com.jp.tcc.mercadoriaservice.dto.request;

import com.jp.tcc.mercadoriaservice.dto.GeoLocation;
import com.jp.tcc.mercadoriaservice.enums.EnumEntregaStatus;

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
