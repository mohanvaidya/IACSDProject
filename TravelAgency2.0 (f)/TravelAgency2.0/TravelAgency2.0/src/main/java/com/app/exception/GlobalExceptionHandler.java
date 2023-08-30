package com.app.exception;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.apiresponse.ApiResponse;



// how to tell SC following class is a spring bean containing common advice to all rest controller,
//regarding centralized excp handling 
@RestControllerAdvice // mandatory anno
public class GlobalExceptionHandler {
// this class can contain single/multiple excp handling methods
// how to tell SC following method is excp handling method 
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
// converting List <
		Map<String, String> map = e.getFieldErrors().stream()
				.collect(Collectors.toMap(f-> f.getField(), f -> f.getDefaultMessage()));
	
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
// list<FieldError> getFieldError()
		// API of Field class: getField:field name with err
		// get default message

	}
  @ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<?> handleResourceNotFoundException( ResourceNotFoundException e){
     System.out.println("handle Resource Not Found "+e);
	  
    		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), false));
   
}
}