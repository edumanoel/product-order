package br.com.mbds.productorder.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.mbds.productorder.services.exceptions.DatabaseException;
import br.com.mbds.productorder.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError standardError = StandardError.builder().timestamp(Instant.now()).status(status.value())
				.error(error).message(e.getMessage()).path(request.getRequestURI()).build();
		return ResponseEntity.status(status).body(standardError);
	}

	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError standardError = StandardError.builder().timestamp(Instant.now()).status(status.value())
				.error(error).message(e.getMessage()).path(request.getRequestURI()).build();
		return ResponseEntity.status(status).body(standardError);
	}

}
