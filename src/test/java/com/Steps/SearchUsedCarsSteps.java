package com.Steps;

import java.util.List;

import org.testng.Assert;

import com.SeleniumDriver.SeleniumDriver;
import com.SeleniumDriver.SeleniumDriver_zeus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Actions.CarsGuidePageActions;
import pages.Actions.UsedCarsSearchPageActions;

public class SearchUsedCarsSteps {
	
	/*
	 * this class only calls the page actions classes
	 * to use the actions to include in to each step
	 * do not show the web element locators in this class
	 * remember locators are always abstract and encapsulated
	 * 
	 */


	CarsGuidePageActions carsGuidePageActions = new CarsGuidePageActions();
	UsedCarsSearchPageActions usedCarsSearchPageActions= new UsedCarsSearchPageActions();
	
	
	@Given("^I navigate to the  Home Page \"([^\"]*)\" of CarsGuide Website$")
	public void i_navigate_to_the_Home_Page_of_CarsGuide_Website(String url)  {
	   SeleniumDriver_zeus.openPage(url);
	}

	@When("^I move to Car-For-Sale Menu$")
	public void i_move_to_Car_For_Sale_Menu() throws InterruptedException  {
		carsGuidePageActions.moveToCarForSaleMenu();	    
	}

	@When("^click on submenu Used Cars Search link$")
	public void click_on_submenu_Used_Cars_Search_link()  {
		carsGuidePageActions.clickOnUsedSearchCarsMenu();
	}

	@When("^select carMaker from AnyMake dropdown$")
	public void select_carMaker_from_AnyMake_dropdown(List<String> carMaker)  {
	    
	    usedCarsSearchPageActions.selectCarMaker(carMaker.get(1));
	}

	@When("^select  car model$")
	public void select_car_model(List<String> list)  {
		System.out.println("carModel-->"+list.get(1));
		String carModel=list.get(1);
		usedCarsSearchPageActions.selectCarModel(carModel);
	    
	}

	@When("^select location  from SelectLocation dropdown$")
	public void select_location_from_SelectLocation_dropdown(List<String> location)  {
	   usedCarsSearchPageActions.selectLocation(location.get(1));
	}

	@When("^select price$")
	public void select_price(List<String> price)  {
		System.out.println("price-->"+price.get(1));
	    usedCarsSearchPageActions.selectPrice(price.get(1));
	    
	}

	@When("^click on Find_My_Car button$")
	public void click_on_Find_My_Car_button()  {
	    usedCarsSearchPageActions.clickOnFindMyNextCarButton();
	}

	@Then("^I should see list of Used cars$")
	public void i_should_see_list_of_Used_cars()  {
	   System.out.println("Used car list populated");
	}

	@SuppressWarnings("deprecation")
	@Then("^the page title should match expected title  \"([^\"]*)\"$")
	public void the_page_title_should_match_expected_title(String expectedPageTitle)  {
		
		String ActualPageTitle= SeleniumDriver_zeus.getDriver().getTitle();
		Assert.assertEquals(ActualPageTitle, expectedPageTitle);
	    System.out.println("Actual page title-->"+ActualPageTitle);
	    System.out.println("Expected page title-->"+expectedPageTitle);

		 
	}
	

}
