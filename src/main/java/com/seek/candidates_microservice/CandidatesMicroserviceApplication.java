package com.seek.candidates_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CandidatesMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandidatesMicroserviceApplication.class, args);
	}

}
