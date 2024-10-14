package com.grizer.grizerinventory.kafka;

import com.grizer.base.dto.OrderEventDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
	Logger LOGGER = LoggerFactory.getLogger(OrderEventDto.class);

	@KafkaListener(topics = "${spring.kafka.template.default-topic}",groupId = "spring.kafka.consumer.group-id}")
	public void consumer(OrderEventDto orderEventDto){
		LOGGER.info("receiving order event from the topic : {}",orderEventDto.toString());
	}

}
