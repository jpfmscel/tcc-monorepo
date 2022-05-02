package com.jp.tcc.mercadoriaservice.pubsub.messagesDTO;

import java.time.LocalDateTime;

import com.jp.tcc.mercadoriaservice.dto.GeoLocation;
import com.jp.tcc.mercadoriaservice.enums.EnumEntregaStatus;

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
