package com.seek.candidates_microservice.infrasctructure.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seek.candidates_microservice.application.services.CandidateService;
import com.seek.candidates_microservice.domain.model.Candidate;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/candidate")
@Tag(name = "Candidate", description = "Candidate management APIs")
public class CandidateController {

	private final CandidateService candidateService;

	public CandidateController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}

	@Operation(summary = "Create Candidate", description = "Creates a Candidate object. The response is a Candidate object with id, name, email, gender, expected salary, currency, profession, native language.")
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Candidate.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PostMapping
	public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate) {
		Candidate createCandidate = candidateService.createCandidate(candidate);
		return new ResponseEntity<>(createCandidate, HttpStatus.CREATED);
	}

	@Operation(summary = "Retrieve a Candidate by Id", description = "Get a Candidate object by specifying its id. The response is Candidate object with id, name, email, gender, expected salary, currency, profession, native language.")
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Candidate.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/{candidateId}")
	public ResponseEntity<Candidate> getCandidateById(@PathVariable Long candidateId) {
		return candidateService.getCandidateById(candidateId)
				.map(candidate -> new ResponseEntity<>(candidate, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@Operation(summary = "Get a list of Candidate objects", description = "Get a list of Candidate. The response is a list of Candidate objects with id, name, email, gender, expected salary, currency, profession, native language.")
	@ApiResponses({ @ApiResponse(responseCode = "200", content = {
			@Content(array = @ArraySchema(schema = @Schema(implementation = Candidate.class)), mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping
	public ResponseEntity<List<Candidate>> getAllCandidates() {
		List<Candidate> candidates = candidateService.getAllCandidates();
		return new ResponseEntity<>(candidates, HttpStatus.OK);
	}

	@Operation(summary = "Update Candidate", description = "Update a Candidate object. The response is a Candidate object with id, name, email, gender, expected salary, currency, profession, native language.")
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Candidate.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PutMapping
	public ResponseEntity<Candidate> updateCandidate(@RequestBody Candidate candidate) {
		return candidateService.updateCandidate(candidate)
				.map(cantidate -> new ResponseEntity<>(candidate, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@Operation(summary = "Delete Candidate", description = "Delete a Candidate object. The answer is successful status No content.")
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Candidate.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@DeleteMapping("/{candidateId}")
	public ResponseEntity<Void> deleteCandidateById(@PathVariable Long candidateId) {
		if (candidateService.deleteCandidate(candidateId)) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}