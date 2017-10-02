package springmvc.spring.web.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ErrorHandler {

	public String handleDatabaseException(DataAccessException e) {
		
		return "error";
	}
public String handleAccessDeniedException(AccessDeniedException e) {
		
		return "denied";
	}
}
