package com.seek.candidates_microservice.infrasctructure.entities;

import com.seek.candidates_microservice.domain.model.Candidate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CANDIDATES")
public class CandidateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String gender;
	private double salaryExpected;
	private String currency;
	private String profession;
	private String nativeLanguage;

	public static CandidateEntity fromDomainModel(Candidate candidate) {
		return new CandidateEntity(candidate.getId(), candidate.getName(), candidate.getEmail(), candidate.getGender(),
				candidate.getSalaryExpected(), candidate.getCurrency(), candidate.getProfession(),
				candidate.getNativeLanguage());
	}

	public Candidate toDomainModel() {
		return new Candidate(id, name, email, gender, salaryExpected, currency, profession, nativeLanguage);
	}
}