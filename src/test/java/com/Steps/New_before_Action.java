package com.Steps;

import java.io.IOException;

import com.SeleniumDriver.SeleniumDriver_zeus;

import cucumber.api.java.Before;

public class New_before_Action {
	
	
	@Before
	public static void setUp() throws IOException {
		
		SeleniumDriver_zeus.setUpDriver();
		
	}

}
