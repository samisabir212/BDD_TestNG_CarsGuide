package com.Steps;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.SeleniumDriver.SeleniumDriver;
import com.SeleniumDriver.SeleniumDriver_zeus;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Actions.CarsGuidePageActions;
import pages.Actions.CarsSearchPageActions;

public class SearchCarsSteps {
	
	CarsGuidePageActions carsGuidePageActions = new CarsGuidePageActions();
	CarsSearchPageActions carsSearchPageActions = new CarsSearchPageActions();
	WebDriver driver = SeleniumDriver_zeus.getDriver();

@Given("^I am on the Home Page \"([^\"]*)\" of CarsGuide Website$")
public void i_am_on_the_Home_Page_of_CarsGuide_Website(String url) throws Throwable {
   
	SeleniumDriver_zeus.openPage(url);
	
}

@When("^I move to Car For Sale Menu$")
public void i_move_to_Car_For_Sale_Menu(List<String> list) throws Throwable {
    
	String menu = list.get(1);
	System.out.println("Menu selected is "+ menu);
	carsGuidePageActions.moveToCarForSaleMenu();
	
	
}

@And("^click on \"([^\"]*)\" link$")
public void click_on_link(String searchCars) throws Throwable {
    carsGuidePageActions.clickSearchCarsLink();
}

@And("^select carbrand as \"([^\"]*)\" from AnyMake dropdown$")
public void select_carbrand_as_from_AnyMake_dropdown(String carMake) throws Throwable {
   
	carsSearchPageActions.selectCarMaker(carMake);
	
}

@And("^select \"([^\"]*)\" as car model$")
public void select_as_car_model(String carModel) throws Throwable {

	carsSearchPageActions.selectCarModel(carModel);
	
}

@And("^select location as \"([^\"]*)\" from SelectLocation dropdown$")
public void select_location_as_from_SelectLocation_dropdown(String location) throws Throwable {
  
	carsSearchPageActions.selectLocation(location);
	
}

@And("^select \"([^\"]*)\" as price$")
public void select_as_price(String price) throws Throwable {
   carsSearchPageActions.selectPrice(price);
}

@And("^click on Find_My_Next_Car button$")
public void click_on_Find_My_Next_Car_button() throws Throwable {
    
	carsSearchPageActions.clickOnFindMyNextCarButton();
}

@Then("^I should see list of searched cars$")
public void i_should_see_list_of_searched_cars() throws Throwable {
   
//	List<WebElement> imgs = driver.findElements(By.xpath("//img"));
//	
//	for(WebElement i : imgs) {
//		System.out.println(i.getSize());
//	}
	System.out.println("list view");
	
}

@Then("^the page title should be \"([^\"]*)\"$")
public void the_page_title_should_be(String expectedTitle) throws Throwable {
    
	String actualTitle=SeleniumDriver_zeus.getDriver().getTitle();
	System.out.println(actualTitle);
	SoftAssert sa = new SoftAssert();
	sa.assertEquals(actualTitle, expectedTitle, "Assertion failed");
	System.out.println("after assertion");
	//Assert.assertEquals(actualTitle, expectedTitle);
}


}
