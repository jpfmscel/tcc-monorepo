package com.jp.tcc.adapter.sge.dto.request;

import com.jp.tcc.adapter.sge.dto.GeoLocation;
import com.jp.tcc.adapter.sge.enums.EnumEntregaStatus;

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
