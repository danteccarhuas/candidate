package com.seek.candidates_microservice.infrasctructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.seek.candidates_microservice.application.services.CandidateService;
import com.seek.candidates_microservice.application.usescases.CreateCandidateUseCaseImpl;
import com.seek.candidates_microservice.application.usescases.DeleteCandidateUseCaseImpl;
import com.seek.candidates_microservice.application.usescases.GetCandidateUseCaseImpl;
import com.seek.candidates_microservice.application.usescases.UpdateCandidateUseCaseImpl;
import com.seek.candidates_microservice.domain.ports.output.CandidateRepositoryPort;
import com.seek.candidates_microservice.infrasctructure.repositories.JpaCandidateRepositoryAdapter;

@Configuration
public class ApplicationConfig {

	@Bean
	public CandidateService candidateService(CandidateRepositoryPort candidateRepositoryPort) {
		return new CandidateService(new CreateCandidateUseCaseImpl(candidateRepositoryPort),
				new DeleteCandidateUseCaseImpl(candidateRepositoryPort),
				new GetCandidateUseCaseImpl(candidateRepositoryPort),
				new UpdateCandidateUseCaseImpl(candidateRepositoryPort));
	}

	@Bean
	public CandidateRepositoryPort candidateRepositoryPort(
			JpaCandidateRepositoryAdapter jpaCandidateRepositoryAdapter) {
		return jpaCandidateRepositoryAdapter;
	}
}