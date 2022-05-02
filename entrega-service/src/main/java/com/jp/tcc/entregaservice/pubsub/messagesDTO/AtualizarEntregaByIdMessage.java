package com.jp.tcc.entregaservice.pubsub.messagesDTO;

import java.time.LocalDateTime;

import com.jp.tcc.entregaservice.dto.GeoLocation;
import com.jp.tcc.entregaservice.enums.EnumEntregaStatus;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class AtualizarEntregaByIdMessage {

	@NonNull
	String entregaId;
	
	@NonNull
	GeoLocation geolocation;
	
	@NonNull
	LocalDateTime lastUpdate;
	
	@NonNull
	EnumEntregaStatus status;
}
