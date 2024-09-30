package com.seek.candidates_microservice.application.usescases;

import com.seek.candidates_microservice.domain.model.Candidate;
import com.seek.candidates_microservice.domain.ports.input.CreateCandidateUseCase;
import com.seek.candidates_microservice.domain.ports.output.CandidateRepositoryPort;

public class CreateCandidateUseCaseImpl implements CreateCandidateUseCase {

	private final CandidateRepositoryPort candidateRepositoryPort;

	public CreateCandidateUseCaseImpl(CandidateRepositoryPort candidateRepositoryPort) {
		this.candidateRepositoryPort = candidateRepositoryPort;
	}

	@Override
	public Candidate createCandidate(Candidate candidate) {
		return this.candidateRepositoryPort.save(candidate);
	}
}