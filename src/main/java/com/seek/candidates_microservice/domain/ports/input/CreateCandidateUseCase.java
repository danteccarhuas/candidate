package com.seek.candidates_microservice.domain.ports.input;

import com.seek.candidates_microservice.domain.model.Candidate;

public interface CreateCandidateUseCase {
	Candidate createCandidate(Candidate candidate);
}