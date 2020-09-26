package com.wolfram.alphaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.apache.kafka.clients.producer.KafkaProducer;
import java.util.Properties;

@SpringBootApplication
@EnableEurekaClient
public class AlphaServiceApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		// Set a 3 second timeout to prevent blocked threads from building up in the case of a slow microservice
		clientHttpRequestFactory.setConnectTimeout(3000);
		return new RestTemplate(clientHttpRequestFactory);
	}

	@Bean
	KafkaProducer kafkaProducer() {
		Properties props = new Properties();
		props.put("bootstrap.servers","localhost:9092");
		props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
		props.put("max.block.ms","1000");

		return new KafkaProducer<String, String>(props);
	}

	public static void main(String[] args) {
		SpringApplication.run(AlphaServiceApplication.class, args);
	}
}
