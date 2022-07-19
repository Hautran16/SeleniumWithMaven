package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Page {
	protected WebDriver driverWeb;
	
	public Page (WebDriver dr) {
		super();
		this.driverWeb = dr;
	}
	
	public void verifyElementDisplay(By element) {
		driverWeb.findElement(element).isDisplayed();
	}

	public void verifyTextPresent(String actualResult, String expectedResult) {
		assertEquals(actualResult, expectedResult);
	}

	public void uploadImg(By element, String imageFolderPath) {
		driverWeb.findElement(element).sendKeys(imageFolderPath);
	}
	
	public void selectElemetFromDropdown(By element, String textInput) {
		Select selectOption = new Select(driverWeb.findElement(element));
		selectOption.selectByVisibleText(textInput);
	}
}
 