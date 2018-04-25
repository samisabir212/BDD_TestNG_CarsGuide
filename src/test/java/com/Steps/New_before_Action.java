package com.Steps;

import java.io.IOException;

import com.SeleniumDriver.SeleniumDriver_zeus;

import com.Utilities.Log;
import cucumber.api.java.Before;

public class New_before_Action {
	
	
	/*this is*/
	@Before
	public static void setUp() throws IOException {


		SeleniumDriver_zeus.setUpDriver();
		Log.info("WebDriver Started");
	}

}
