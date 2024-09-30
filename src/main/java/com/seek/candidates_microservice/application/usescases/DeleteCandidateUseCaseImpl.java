package com.seek.candidates_microservice.application.usescases;

import com.seek.candidates_microservice.domain.ports.input.DeleteCandidateUseCase;
import com.seek.candidates_microservice.domain.ports.output.CandidateRepositoryPort;

public class DeleteCandidateUseCaseImpl implements DeleteCandidateUseCase {

	private final CandidateRepositoryPort candidateRepositoryPort;

	public DeleteCandidateUseCaseImpl(CandidateRepositoryPort candidateRepositoryPort) {
		this.candidateRepositoryPort = candidateRepositoryPort;
	}

	@Override
	public boolean deleteCandidate(Long id) {
		return this.candidateRepositoryPort.deleteById(id);
	}

}