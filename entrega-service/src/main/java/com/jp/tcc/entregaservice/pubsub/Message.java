package com.jp.tcc.entregaservice.pubsub;

public abstract class Message {

	protected String key;
	protected Object value;
	
	protected abstract String getKey();
	protected abstract String getValue();
}
