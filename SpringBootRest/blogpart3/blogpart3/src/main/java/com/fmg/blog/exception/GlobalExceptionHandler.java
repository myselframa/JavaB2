package com.fmg.blog.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fmg.blog.payloads.CustomExceptionResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(exception = ResourceNotFoundException.class)
	public ResponseEntity<CustomExceptionResponse> resourceNotFOundException
	(ResourceNotFoundException rne,WebRequest we){
		
		CustomExceptionResponse response=new CustomExceptionResponse();
		response.setDetails(we.getDescription(false));
		response.setDate(new Date());
		response.setMessage(rne.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
    @ExceptionHandler(BlogAPIException.class)
    public ResponseEntity<CustomExceptionResponse> handleBlogAPIException(BlogAPIException exception,
                                                                        WebRequest webRequest){
        CustomExceptionResponse errorDetails = new CustomExceptionResponse();
        errorDetails.setDetails(webRequest.getDescription(false));
        errorDetails.setDate(new Date());
        errorDetails.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    
    // global exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomExceptionResponse> handleGlobalException(Exception exception,
                                                               WebRequest webRequest){
    	CustomExceptionResponse errorDetails = new CustomExceptionResponse();
    	errorDetails.setDate(new Date());
    	errorDetails.setMessage( exception.getMessage());
    	errorDetails.setDetails( webRequest.getDescription(false));     
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<CustomExceptionResponse> handleAccessDeniedException(AccessDeniedException exception,
                                                                        WebRequest webRequest){
    	CustomExceptionResponse errorDetails = new CustomExceptionResponse();
    			errorDetails.setDate(new Date());
    			errorDetails.setMessage( exception.getMessage());
    			errorDetails.setDetails( webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {
    			Map<String, String> errors = new HashMap<>();
    			ex.getBindingResult().getAllErrors().forEach((error) ->{
    				String fieldName = ((FieldError)error).getField();
    				String message = error.getDefaultMessage();
    				errors.put(fieldName, message);
    	});

    	return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


}
