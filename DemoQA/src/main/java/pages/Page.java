package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
 