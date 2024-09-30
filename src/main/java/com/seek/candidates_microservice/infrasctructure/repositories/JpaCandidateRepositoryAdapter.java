package com.seek.candidates_microservice.infrasctructure.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.seek.candidates_microservice.domain.model.Candidate;
import com.seek.candidates_microservice.domain.ports.output.CandidateRepositoryPort;
import com.seek.candidates_microservice.infrasctructure.entities.CandidateEntity;

@Component
public class JpaCandidateRepositoryAdapter implements CandidateRepositoryPort {

	private final JpaCandidateRepository jpaCandidateRepository;

	public JpaCandidateRepositoryAdapter(JpaCandidateRepository jpaCandidateRepository) {
		this.jpaCandidateRepository = jpaCandidateRepository;
	}

	@Override
	public Candidate save(Candidate candidate) {
		CandidateEntity candidateEntity = CandidateEntity.fromDomainModel(candidate);
		CandidateEntity savedCandidateEntity = jpaCandidateRepository.save(candidateEntity);
		return savedCandidateEntity.toDomainModel();
	}

	@Override
	public Optional<Candidate> findById(Long id) {
		return jpaCandidateRepository.findById(id).map(CandidateEntity::toDomainModel);
	}

	@Override
	public List<Candidate> findAll() {
		return jpaCandidateRepository.findAll().stream().map(CandidateEntity::toDomainModel)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<Candidate> update(Candidate candidate) {
		if (jpaCandidateRepository.existsById(candidate.getId())) {
			CandidateEntity candidateEntity = CandidateEntity.fromDomainModel(candidate);
			CandidateEntity updatedCandidateEntity = jpaCandidateRepository.save(candidateEntity);
			return Optional.of(updatedCandidateEntity.toDomainModel());
		}
		return Optional.empty();
	}

	@Override
	public boolean deleteById(Long id) {
		if (jpaCandidateRepository.existsById(id)) {
			jpaCandidateRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
