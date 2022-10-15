package com.abc_telecom_Ltd.exceptions;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

import org.hibernate.PropertyValueException;
import org.hibernate.id.IdentifierGenerationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionalHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ComplaintNotPresentException.class)
	public ErrorMessage complaintNotPresent(Exception exception, Model model, WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST, "Complaint does not exist for this id");
		model.addAttribute("errormessage", message);
		return message;
	}

	@ExceptionHandler(EngineerNotPresentException.class)
	public ErrorMessage engineerNotPresent(Exception exception, Model model, WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST, "Engineer does not exist for this id");
		model.addAttribute("errormessage", message);
		return message;
	}

	@ExceptionHandler(NullPointerException.class)
	public ErrorMessage nullPointerException(Exception exception, Model model, WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
		model.addAttribute("errormessage", message);
		return message;
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ErrorMessage noSuchElementException(Exception exception, Model model, WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
		model.addAttribute("errormessage", message);
		return message;
	}

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public String sQLIntegrityConstraintViolationException(Exception exception, Model model, WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST, "First, referance should be deleted");
		model.addAttribute("errormessage", message);
		return "First, referance should be deleted";
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ErrorMessage emptyResultDataAccessException(Exception exception, Model model, WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
		model.addAttribute("errormessage", message);
		return message;
	}

	@ExceptionHandler(PropertyValueException.class)
	public ErrorMessage propertyValueException(Exception exception, Model model, WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST, "All Fields Are required");
		model.addAttribute("errormessage", message);
		return message;
	}

	@ExceptionHandler(IdentifierGenerationException.class)
	public ErrorMessage identifierGenerationException(Exception exception, Model model, WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
		model.addAttribute("errormessage", message);
		return message;
	}
	@ExceptionHandler(SQLException.class)
	public ErrorMessage sQLException(Exception exception, Model model, WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
		model.addAttribute("errormessage", message);
		return message;
	}

}
