package com.jp.tcc.sgeadapter.pubsub;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Message {

	private String key;
	private Object value;

}
