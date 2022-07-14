package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {
	By formItem = By.xpath("//h5[contains(text(),'Forms')]");
	
	public HomePage(WebDriver dr) {
		super(dr);
		this.driverWeb = dr;
	}
	
	public FormPage clickFormItem() {
		driverWeb.findElement(formItem).click(); 
		return new FormPage(driverWeb);
	}

}
 