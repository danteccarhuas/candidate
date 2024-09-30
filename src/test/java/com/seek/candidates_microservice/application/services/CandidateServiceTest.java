package com.seek.candidates_microservice.application.services;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.seek.candidates_microservice.domain.model.Candidate;

import jakarta.persistence.EntityNotFoundException;

@ExtendWith(MockitoExtension.class)
public class CandidateServiceTest {

	@InjectMocks
	private CandidateService candidateService;

//	@Test
//	public void shouldReturnEmpty_whenCandidateIsNotFound() {
//		Candidate candidate = fakeUserBuilder().build();
//
//		Mockito.when(writeUserPort.update(candidate)).thenReturn(Optional.empty());
//
//		assertThatThrownBy(() -> candidateService.updateCandidate(candidate))
//				.isInstanceOf(EntityNotFoundException.class);
//		Mockito.verify(writeUserPort, Mockito.times(1)).update(Mockito.any());
//	}
}