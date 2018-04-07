package pages.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.SeleniumDriver.SeleniumDriver_zeus;

import page.Locators.CarSearchPageLocators;

public class CarsSearchPageActions {

	CarSearchPageLocators carsSearchPageLocators = null;

	//init elements by inheritance constructor
	public CarsSearchPageActions() {
		this.carsSearchPageLocators = new CarSearchPageLocators();
		PageFactory.initElements(SeleniumDriver_zeus.getDriver(), carsSearchPageLocators);
	}

	public void selectCarMaker(String carBrand) {

		// SeleniumDriver.getDriver().findElement(By.xpath(".//*[@id='makes']")).click();
		SeleniumDriver_zeus.getDriver().findElement(By.xpath(".//*[@id='block-system-main']/div/div/div/div/div/form"))
				.click();
		Select selectCarMaker = new Select(carsSearchPageLocators.carMakerDropDown);
		selectCarMaker.selectByVisibleText("BMW");

	}

	public void selectCarModel(String carModel) {
		// SeleniumDriver.getDriver().findElement(By.xpath(".//*[@id='models']")).click();
		SeleniumDriver_zeus.getDriver().findElement(By.xpath(".//*[@id='block-system-main']/div/div/div/div/div/form"))
				.click();
		Select selectCarModel = new Select(carsSearchPageLocators.selectModelDropDown);
		selectCarModel.selectByVisibleText(carModel);
	}

	public void selectLocation(String location) {
		// SeleniumDriver.getDriver().findElement(By.xpath(".//*[@id='locations']")).click();
		SeleniumDriver_zeus.getDriver().findElement(By.xpath(".//*[@id='block-system-main']/div/div/div/div/div/form"))
				.click();
		Select selectLocation = new Select(carsSearchPageLocators.selectLocation);
		selectLocation.selectByVisibleText(location);
	}

	public void selectPrice(String price) {
		// SeleniumDriver.getDriver().findElement(By.xpath(".//*[@id='price-max']")).click();
		SeleniumDriver_zeus.getDriver().findElement(By.xpath(".//*[@id='block-system-main']/div/div/div/div/div/form"))
				.click();
		Select selectPrice = new Select(carsSearchPageLocators.priceList);
		selectPrice.selectByVisibleText(price);
	}

	public void clickOnFindMyNextCarButton() {
		SeleniumDriver_zeus.getDriver().findElement(By.xpath(".//*[@id='block-system-main']/div/div/div/div/div/form"))
				.click();
		carsSearchPageLocators.findMyNextCarButton.click();

	}

}
