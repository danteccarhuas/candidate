package com.seek.candidates_microservice.domain.ports.input;

import java.util.Optional;

import com.seek.candidates_microservice.domain.model.Candidate;

public interface UpdateCandidateUseCase {
	Optional<Candidate> updateCandidate(Candidate candidate);
}