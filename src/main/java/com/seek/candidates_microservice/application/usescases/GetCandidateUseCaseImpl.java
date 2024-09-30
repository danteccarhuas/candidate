package com.seek.candidates_microservice.application.usescases;

import java.util.List;
import java.util.Optional;

import com.seek.candidates_microservice.domain.model.Candidate;
import com.seek.candidates_microservice.domain.ports.input.GetCandidateUseCase;
import com.seek.candidates_microservice.domain.ports.output.CandidateRepositoryPort;

public class GetCandidateUseCaseImpl implements GetCandidateUseCase {

	private final CandidateRepositoryPort candidateRepositoryPort;

	public GetCandidateUseCaseImpl(CandidateRepositoryPort candidateRepositoryPort) {
		this.candidateRepositoryPort = candidateRepositoryPort;
	}

	@Override
	public Optional<Candidate> getCandidateById(Long id) {
		return this.candidateRepositoryPort.findById(id);
	}

	@Override
	public List<Candidate> getAllCandidates() {
		return this.candidateRepositoryPort.findAll();
	}
}