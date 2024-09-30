package com.seek.candidates_microservice.domain.ports.input;

import java.util.List;
import java.util.Optional;

import com.seek.candidates_microservice.domain.model.Candidate;

public interface GetCandidateUseCase {
	Optional<Candidate> getCandidateById(Long id);

	List<Candidate> getAllCandidates();
}