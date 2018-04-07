package page.Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarSearchPageLocators {
	

	@FindBy(xpath=".//*[@id='makes']")
	public WebElement carMakerDropDown;
	
	@FindBy(xpath=".//*[@id='models']")
	public WebElement selectModelDropDown;
	
	@FindBy(xpath=".//*[@id='locations']")
	public WebElement selectLocation;
	
	@FindBy(xpath=".//*[@id='price-max']")
	public WebElement priceList;
	
	@FindBy(xpath=".//*[@id='search-submit']")
	public WebElement findMyNextCarButton;
	

}
