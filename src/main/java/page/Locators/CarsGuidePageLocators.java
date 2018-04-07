package page.Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CarsGuidePageLocators {
	
	
	@FindBy(how=How.LINK_TEXT,using="Cars For Sale")
	public WebElement carsForSaleLink;
	
	@FindBy(how=How.LINK_TEXT,using="Sell My Car")
	public WebElement sellMyCarLink;
	
	@FindBy(how=How.LINK_TEXT,using="Car Reviews")
	public WebElement carReviewsLink;
	
	@FindBy(how=How.LINK_TEXT,using="Search Cars")
	public WebElement searchCarsLink;
	
	@FindBy(how=How.LINK_TEXT,using="Used Cars Search")
	public WebElement usedSearchCarsLink;
	
	@FindBy(linkText="Pricing & Specs")
	public WebElement pricing_Spec_link;



}
