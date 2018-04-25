package pages.Actions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.SeleniumDriver.SeleniumDriver_zeus;

import page.Locators.CarsGuidePageLocators;



public class CarsGuidePageActions {

	//myst initialize the object of the page class of the locators you want.
	CarsGuidePageLocators carsGuidePageLocators = null;
	
	/*
	 * initialize the object locators in a constructor 
	 * so when you call this class in the test class the element locators will get initialized
	 * supply driver and the page class containing the locators
	 */
	public CarsGuidePageActions() {
		//this will get automatically initialized when called in another class

		this.carsGuidePageLocators = new CarsGuidePageLocators();
		PageFactory.initElements(SeleniumDriver_zeus.getDriver(), carsGuidePageLocators);
		
	}
	
	public void moveToCarForSaleMenu() throws InterruptedException {

		Thread.sleep(5000);
		Actions action = new Actions(SeleniumDriver_zeus.getDriver());
		action.moveToElement(carsGuidePageLocators.carsForSaleLink).perform();

	}

	public void clickSearchCarsLink() {
		
		carsGuidePageLocators.searchCarsLink.click();

	}

	public void clickOnUsedSearchCarsMenu() {

		carsGuidePageLocators.searchCarsLink.click();

	}

	public void clickPricingAndSpecsLink() {
		
		carsGuidePageLocators.pricing_Spec_link.click();

	}
	
	

}
