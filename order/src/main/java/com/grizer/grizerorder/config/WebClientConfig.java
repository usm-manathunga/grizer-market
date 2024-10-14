package com.grizer.grizerorder.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

	@Bean
	@LoadBalanced
	public WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}

//	@Bean
//	public WebClient inventoryWebClient(){
//		return WebClient.builder().baseUrl("http://localhost:8080/api").build();
//	}
//	@Bean
//	public WebClient inventoryWebClient(){
//		return webClientBuilder().baseUrl("http://grizer-inventory:8080/api").build();
//	}

	@Bean
	public WebClient inventoryWebClient(){
		return webClientBuilder().baseUrl("http://apigateway:8080/api").build();
	}

//	@Bean
//	public WebClient productionWebClient(){
//		return WebClient.builder().baseUrl("http://localhost:8082/api").build();
//	}

//	@Bean
//	public WebClient productionWebClient(){
//		return webClientBuilder().baseUrl("http://graizer-product:8082/api").build();
//	}

	@Bean
	public WebClient productionWebClient(){
		return webClientBuilder().baseUrl("http://apigateway:8082/api").build();
	}
}
