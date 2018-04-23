package com.gustavofranzolin.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gustavofranzolin.cursomc.services.exceptions.ObjectNotFoundException;


// Manipulador de erros - classe auxiliar para interceptação dos erros
// e ela é implementada seguindo o padrão do ControllerAdvice

@ControllerAdvice
public class ResourceExceptionHandler {

// anotação pra indicar que é um tratador de exceção do tipo ObjectNotFoundException.class
	@ExceptionHandler(ObjectNotFoundException.class)
public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
	
	
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());

		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}


}
