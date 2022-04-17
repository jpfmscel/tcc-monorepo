package com.jp.tcc.entregaservice.pubsub;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Message {

	private String key;
	private Object value;

}
