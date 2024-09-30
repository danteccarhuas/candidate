package com.seek.candidates_microservice.infrasctructure.exception;

import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ServerErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.seek.candidates_microservice.infrasctructure.dto.CustomResponse;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(ServerErrorException.class)
	public ResponseEntity<CustomResponse> internalServerErrorHandler(ServerErrorException see) {
		LOGGER.error("serverErrortHandler - message {}", see.getMessage());
		CustomResponse cr = new CustomResponse((HttpStatus.INTERNAL_SERVER_ERROR), see.getMessage());
		return new ResponseEntity<>(cr, cr.getStatus());
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<CustomResponse> badRequestHandler(BadRequestException bre) {
		LOGGER.error("badRequestHandler - message {}", bre.getMessage());
		CustomResponse cr = new CustomResponse((HttpStatus.BAD_REQUEST), bre.getMessage());
		return new ResponseEntity<>(cr, cr.getStatus());
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<CustomResponse> notFoundExceptionHandler(NotFoundException nfe) {
		LOGGER.error("notFoundExceptionHandler - message: {}", nfe.getMessage());
		CustomResponse cr = new CustomResponse((HttpStatus.NOT_FOUND), nfe.getMessage());
		return new ResponseEntity<>(cr, cr.getStatus());
	}

	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<CustomResponse> unauthorizedExceptionHandler(AuthenticationException ae) {
		LOGGER.error("unauthorizedExceptionHandler - message: {}", ae.getMessage());
		CustomResponse cr = new CustomResponse((HttpStatus.UNAUTHORIZED), ae.getMessage());
		return new ResponseEntity<>(cr, cr.getStatus());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomResponse> handleSecurityException(Exception exception) {
		CustomResponse cr = null;

		if (exception instanceof BadCredentialsException) {
			//errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(401), exception.getMessage());
			//errorDetail.setProperty("description", "The username or password is incorrect");
			cr = new CustomResponse((HttpStatus.UNAUTHORIZED), exception.getMessage());

			//return errorDetail;
		}

//		if (exception instanceof AccountStatusException) {
//			errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), exception.getMessage());
//			errorDetail.setProperty("description", "The account is locked");
//		}
//
//		if (exception instanceof AccessDeniedException) {
//			errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), exception.getMessage());
//			errorDetail.setProperty("description", "You are not authorized to access this resource");
//		}
//
//		if (exception instanceof SignatureException) {
//			errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), exception.getMessage());
//			errorDetail.setProperty("description", "The JWT signature is invalid");
//		}
//
//		if (exception instanceof ExpiredJwtException) {
//			errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(403), exception.getMessage());
//			errorDetail.setProperty("description", "The JWT token has expired");
//		}
//
//		if (errorDetail == null) {
//			errorDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(500), exception.getMessage());
//			errorDetail.setProperty("description", "Unknown internal server error.");
//		}

		return new ResponseEntity<>(cr, cr.getStatus());
	}
}