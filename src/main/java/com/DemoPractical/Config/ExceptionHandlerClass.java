package com.DemoPractical.Config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.DemoPractical.Model.WebJSONBo;

@ControllerAdvice
public class ExceptionHandlerClass {

	/**
	 * AUTHOR::ANITA PRAJAPATI
	 * DATE::29-OCT-2023
	 * PURPOSE:: GLOBAL EXCEPTION HANDLING
	 * */
	@ExceptionHandler({Exception.class})
	public ResponseEntity<WebJSONBo> allException(Exception exception){
		WebJSONBo bo = new WebJSONBo();
		bo.setStatus("ERROR");
		
		if(exception instanceof MethodArgumentNotValidException) {
			Map<String, String> errors = new HashMap<>();
			((BindException) exception).getBindingResult().getAllErrors().forEach((error) -> {
		        String fieldName = ((FieldError) error).getField();
		        String errorMessage = error.getDefaultMessage();
		        errors.put(fieldName, errorMessage);
		    });
			bo.setResponseData(errors);
			bo.setReturn_message("Please check all the field/ Validate the fields.");
		} else {
			if(exception.getCause() != null) {
					
				if(exception.getCause().getCause() != null) {
					bo.setReturn_message(exception.getCause().getCause().toString());
				}
				else {
					bo.setReturn_message(exception.getCause().toString());
				}
			}
			else {
				bo.setReturn_message(exception.toString());
			}
		}
		exception.printStackTrace();
		return ResponseEntity.ok(bo);
	}
}
