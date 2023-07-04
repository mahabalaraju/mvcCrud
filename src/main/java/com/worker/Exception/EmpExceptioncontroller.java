package com.worker.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmpExceptioncontroller {

	@ExceptionHandler(NosuchEmployeefoundException.class)
	public ResponseEntity<Object> NosuchEmployeefoundExceptionhandler(NosuchEmployeefoundException NosuchEmployeefoundException){
		EmployeeException e=new EmployeeException(
				NosuchEmployeefoundException.getCause(),
				NosuchEmployeefoundException.getMessage(),
				HttpStatus.NOT_FOUND);
		return new ResponseEntity<Object>(e,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(employeenotfoundException.class)
	public ResponseEntity<Object> NosuchEmployeefoundExceptionhandler1(employeenotfoundException NosuchEmployeefoundException){
		EmployeeException e=new EmployeeException(
				NosuchEmployeefoundException.getCause(),
				NosuchEmployeefoundException.getMessage(),
				HttpStatus.NOT_FOUND);
		return new ResponseEntity<Object>(e,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(employeeAlreadyfoundException.class)
	public ResponseEntity<Object> NosuchEmployeefoundExceptionhandler2(employeeAlreadyfoundException NosuchEmployeefoundException){
		EmployeeException e=new EmployeeException(
				NosuchEmployeefoundException.getCause(),
				NosuchEmployeefoundException.getMessage(),
				HttpStatus.NOT_FOUND);
		return new ResponseEntity<Object>(e,HttpStatus.NOT_FOUND);
	}
	
}

