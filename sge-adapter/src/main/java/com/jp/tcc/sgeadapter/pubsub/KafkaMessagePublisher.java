package com.jp.tcc.adapter.sge.pubsub;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Primary
@Component
public class KafkaMessagePublisher implements IMessagePublisher {

	@Override
	public void publish(Message message) {
		log.info("Message sent to kafka : " + message.getKey());
	}

}
