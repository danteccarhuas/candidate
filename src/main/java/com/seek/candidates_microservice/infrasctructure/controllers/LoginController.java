package com.seek.candidates_microservice.infrasctructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seek.candidates_microservice.domain.model.Candidate;
import com.seek.candidates_microservice.infrasctructure.dto.User;
import com.seek.candidates_microservice.infrasctructure.security.JWTAuthtenticationConfig;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Login", description = "Login management APIs")
public class LoginController {

	@Autowired
	JWTAuthtenticationConfig jwtAuthtenticationConfig;

	@Operation(summary = "Create Token", description = "The response is a token generated to be used in the Candidate API.")
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Candidate.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PostMapping("login")
	public User login(@RequestParam("user") String username, @RequestParam("encryptedPass") String encryptedPass) {

		/**
		 * En el ejemplo no se realiza la correcta validación del usuario
		 */

		String token = jwtAuthtenticationConfig.getJWTToken(username);
		return new User(username, encryptedPass, token);

	}
}