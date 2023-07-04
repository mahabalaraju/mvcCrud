package com.worker.Exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeException {

	private Throwable cause;
	
	private String message;
	
	private HttpStatus httpstatus;
	
}
