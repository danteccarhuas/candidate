package com.seek.candidates_microservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Candidate {
	private Long id;
	private String name;
	private String email;
	private String gender;
	private double salaryExpected;
	private String currency;
	private String profession;
	private String nativeLanguage;
}