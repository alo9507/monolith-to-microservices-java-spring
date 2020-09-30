package com.example.questionparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class QuestionParserApplication {
	public static void main(String[] args) {
		SpringApplication.run(QuestionParserApplication.class, args);
	}
}
