package com.seek.candidates_microservice.domain.ports.output;

import java.util.List;
import java.util.Optional;

import com.seek.candidates_microservice.domain.model.Candidate;

public interface CandidateRepositoryPort {
	Candidate save(Candidate candidate);

	Optional<Candidate> findById(Long id);

	List<Candidate> findAll();

	Optional<Candidate> update(Candidate candidate);

	boolean deleteById(Long id);
}