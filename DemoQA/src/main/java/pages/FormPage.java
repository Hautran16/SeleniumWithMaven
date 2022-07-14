package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage extends Page {
	By practiveFormMenu = By.xpath("//span[text()='Practice Form']");

	public FormPage(WebDriver dr) {
		super(dr);
		this.driverWeb = dr;
	}

	public AutomationPracticeFormPage clickOnFormItem() {
		driverWeb.findElement(practiveFormMenu).click();
		return new AutomationPracticeFormPage(driverWeb);
	}

}
