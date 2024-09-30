package com.seek.candidates_microservice.infrasctructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seek.candidates_microservice.infrasctructure.entities.CandidateEntity;

@Repository
public interface JpaCandidateRepository extends JpaRepository<CandidateEntity, Long> {

}