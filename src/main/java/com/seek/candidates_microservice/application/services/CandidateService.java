package com.seek.candidates_microservice.application.services;

import java.util.List;
import java.util.Optional;

import com.seek.candidates_microservice.domain.model.Candidate;
import com.seek.candidates_microservice.domain.ports.input.CreateCandidateUseCase;
import com.seek.candidates_microservice.domain.ports.input.DeleteCandidateUseCase;
import com.seek.candidates_microservice.domain.ports.input.GetCandidateUseCase;
import com.seek.candidates_microservice.domain.ports.input.UpdateCandidateUseCase;

public class CandidateService
		implements CreateCandidateUseCase, DeleteCandidateUseCase, GetCandidateUseCase, UpdateCandidateUseCase {

	private final CreateCandidateUseCase createCandidateUseCase;
	private final DeleteCandidateUseCase deleteCandidateUseCase;
	private final GetCandidateUseCase getCandidateUseCase;
	private final UpdateCandidateUseCase updateCandidateUseCase;

	public CandidateService(CreateCandidateUseCase createCandidateUseCase,
			DeleteCandidateUseCase deleteCandidateUseCase, GetCandidateUseCase getCandidateUseCase,
			UpdateCandidateUseCase updateCandidateUseCase) {
		this.createCandidateUseCase = createCandidateUseCase;
		this.deleteCandidateUseCase = deleteCandidateUseCase;
		this.getCandidateUseCase = getCandidateUseCase;
		this.updateCandidateUseCase = updateCandidateUseCase;
	}

	@Override
	public Optional<Candidate> updateCandidate(Candidate candidate) {
		return this.updateCandidateUseCase.updateCandidate(candidate);
	}

	@Override
	public Optional<Candidate> getCandidateById(Long id) {
		return this.getCandidateUseCase.getCandidateById(id);
	}

	@Override
	public List<Candidate> getAllCandidates() {
		return getCandidateUseCase.getAllCandidates();
	}

	@Override
	public boolean deleteCandidate(Long id) {
		return this.deleteCandidateUseCase.deleteCandidate(id);
	}

	@Override
	public Candidate createCandidate(Candidate candidate) {
		return this.createCandidateUseCase.createCandidate(candidate);
	}

}
