package com.seek.candidates_microservice.infrasctructure.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomResponse {
	private final LocalDateTime date;

	private final HttpStatus status;

	private final String message;

	public CustomResponse(HttpStatus status, String message) {
		this.date = LocalDateTime.now();
		this.status = status;
		this.message = message;
	}
}