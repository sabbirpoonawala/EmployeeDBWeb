package com.virtusa.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.virtusa.validation.EmployeesModelValidator;

class TestRegisterEmployeesModelValidator {

	private EmployeesModelValidator validator=null;
	@BeforeEach
	void setUp() throws Exception {
		validator=new EmployeesModelValidator();
	}

	@AfterEach
	void tearDown() throws Exception {
		validator=null;
	}

	@Test
	void testValidString_positive() {
		
		boolean actual=validator.validString("sabbir");
		assertEquals(true,actual);
    	}
	@Test
	void testValidString_negative() {
		
		boolean actual=validator.validString("sabbir111");
		assertEquals(false,actual);
    	}

	@Test
	void testValidNumber_positive() {
		boolean actual=validator.validNumber(12000);
		assertEquals(true,actual);
	}
	
	

	@Test
	void testValidSalary_positive() {
		boolean actual=validator.validSalary(34000);
		assertEquals(true,actual);
	}
	@Test
	void testValidSalary_negative() {
		boolean actual=validator.validSalary(340000);
		assertEquals(false,actual);
	}
	@Test
	void testValidSalary_zero() {
		boolean actual=validator.validSalary(0);
		assertEquals(false,actual);
	}

}
