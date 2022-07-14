package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ThanksForSubmittingPage extends Page {
	
	By labelStudentName = By.xpath("//tbody/tr[1]/td[2]");
	By labelStudentEmail = By.xpath("//tbody/tr[2]/td[2]");
	By labelGender = By.xpath("//tbody/tr[3]/td[2]");
	By labelMobile = By.xpath("//tbody/tr[4]/td[2]");
	By lableDateOfBirth = By.xpath("//tbody/tr[5]/td[2]");
	By lableStateAndCity = By.xpath("//tbody/tr[10]/td[2]");
	
	public ThanksForSubmittingPage(WebDriver dr) {
		super(dr);
		this.driverWeb = dr;
	}
	
	public String getTextStudentName() {
		String textStudentName = driverWeb.findElement(labelStudentName).getText();
		return textStudentName;
	}
	
	public String getTextStudentEmail() {
		String textStudentEmail = driverWeb.findElement(labelStudentEmail).getText();
		return textStudentEmail;
	}
	
	public String getTextStudentGender() {
		String textStudentGender = driverWeb.findElement(labelGender).getText();
		return textStudentGender;
	}
	
	public String getTextMobile() {
		String textMobile = driverWeb.findElement(labelMobile).getText();
		return textMobile;
	}
	
	public String getTextDateOfBirth() {
		String textDateOfBirth = driverWeb.findElement(lableDateOfBirth).getText();
		return textDateOfBirth;
	}
	
	public String getTextStateAndCity() {
		String textStateAndCity = driverWeb.findElement(lableStateAndCity).getText();
		return textStateAndCity;
	}
	
}
