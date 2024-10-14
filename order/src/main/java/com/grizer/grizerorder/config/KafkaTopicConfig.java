package com.grizer.grizerorder.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.internals.Topic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
	@Value("${spring.kafka.template.default-topic}")
	private String topicName;

	@Bean
	public NewTopic createTopic(){
		return TopicBuilder.name(topicName).partitions(1).replicas(1).build();
	}
}
