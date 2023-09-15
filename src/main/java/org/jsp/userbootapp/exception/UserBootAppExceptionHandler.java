package org.jsp.userbootapp.exception;

import org.jsp.userbootapp.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class UserBootAppExceptionHandler extends ResponseEntityExceptionHandler {
@ExceptionHandler(IdNotFoundException.class)
public ResponseEntity<ResponseStructure<String>> handleIdNotFoundException(IdNotFoundException e){
	ResponseStructure<String> structure=new ResponseStructure<>();
	structure.setBody("User Not Found");
	structure.setMessage(e.getMessage());
	structure.setCode(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
}
@ExceptionHandler(InvalidCredentialException.class)
public ResponseEntity<ResponseStructure<String>> handleInvalidCredentialsException(InvalidCredentialException e){
	ResponseStructure<String> structure=new ResponseStructure<>();
	structure.setBody("Invalid Phone or email or password");
	structure.setCode(HttpStatus.NOT_FOUND.value());
	return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
}
}
