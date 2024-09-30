package com.seek.candidates_microservice.application.usescases;

import java.util.Optional;

import com.seek.candidates_microservice.domain.model.Candidate;
import com.seek.candidates_microservice.domain.ports.input.UpdateCandidateUseCase;
import com.seek.candidates_microservice.domain.ports.output.CandidateRepositoryPort;

public class UpdateCandidateUseCaseImpl implements UpdateCandidateUseCase {
	private final CandidateRepositoryPort candidateRepositoryPort;

	public UpdateCandidateUseCaseImpl(CandidateRepositoryPort candidateRepositoryPort) {
		this.candidateRepositoryPort = candidateRepositoryPort;
	}

	@Override
	public Optional<Candidate> updateCandidate(Candidate candidate) {
		return this.candidateRepositoryPort.update(candidate);
	}
}