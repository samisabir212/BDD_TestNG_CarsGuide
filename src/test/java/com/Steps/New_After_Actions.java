package com.Steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.SeleniumDriver.SeleniumDriver_zeus;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class New_After_Actions {
	
	
	  @After
	    public static void tearDown(Scenario scenario) {
	    	
	    	WebDriver driver=SeleniumDriver_zeus.getDriver();
	    	System.out.println(scenario.isFailed());
	    	 if (scenario.isFailed()) {
	             byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	             scenario.embed(screenshotBytes, "image/png");
	          
	         }
	    	 SeleniumDriver_zeus.tearDown();
	    }

}
