package com.jp.tcc.sgeadapter.dto.request;

import com.jp.tcc.sgeadapter.dto.GeoLocation;
import com.jp.tcc.sgeadapter.enums.EnumEntregaStatus;

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