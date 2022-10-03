package com.accenture.bean;

class EmployeeNotFoundException extends RuntimeException {

	  EmployeeNotFoundException(Long id) {
	    super("Could not find employee " + id);
	  }
	}