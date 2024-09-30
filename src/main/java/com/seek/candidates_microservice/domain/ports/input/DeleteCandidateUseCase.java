package com.seek.candidates_microservice.domain.ports.input;

public interface DeleteCandidateUseCase {
	boolean deleteCandidate(Long id);
}