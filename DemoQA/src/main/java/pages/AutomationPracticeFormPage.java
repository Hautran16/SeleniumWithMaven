package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AutomationPracticeFormPage extends Page {

	By txtFirstName = By.id("firstName");
	By txtLastName = By.id("lastName");
	By txtUserEmail = By.id("userEmail");
	By radioGenderRadioMale = By.xpath("//*[@for='gender-radio-1']");
	By radioGenderRadioFemale = By.xpath("//*[@for='gender-radio-2']");
	By radioGenderRadioOther = By.xpath("//*[@for='gender-radio-3']");
	By btnSubmit = By.id("submit");
	By txtMobile = By.id("userNumber");
	By btnDateOfBirth = By.id("dateOfBirthInput");
	By btnUploadImg = By.id("uploadPicture");
	By btnState = By.id("state");
	By btnCity = By.id("city");

	public AutomationPracticeFormPage(WebDriver dr) {
		super(dr);
		this.driverWeb = dr;
	}

	public void inputFirstName(String firstName) {
		driverWeb.findElement(txtFirstName).sendKeys(firstName);
	}

	public void inputLastName(String lastName) {
		driverWeb.findElement(txtLastName).sendKeys(lastName);
	}

	public void inputUserEmail(String userEmail) {
		driverWeb.findElement(txtUserEmail).sendKeys(userEmail);
	}

	public void clickGenderRadioMale() {
		driverWeb.findElement(radioGenderRadioMale).click();
	}

	public String getTextGenderRadioMale() {
		String textGenderRadioMale = driverWeb.findElement(radioGenderRadioMale).getText();
		return textGenderRadioMale;
	}

	public void clickGenderRadioFemale() {
		driverWeb.findElement(radioGenderRadioFemale).click();
	}

	public void clickGenderRadioOther() {
		driverWeb.findElement(radioGenderRadioOther).click();
	}

	public void inputMobile(String mobile) {
		driverWeb.findElement(txtMobile).sendKeys(mobile);
	}

//	public void selectDateOfBirth() {
//		driverWeb.findElement(btnDateOfBirth).click();
//		By btnMonth = By.className("react-datepicker__month-select");
//		Select selectMonthBtn = new Select(driverWeb.findElement(btnMonth));
//		selectMonthBtn.selectByVisibleText("January");
//		By btnYear = By.className("react-datepicker__year-select");
//		Select selectYearBtn = new Select(driverWeb.findElement(btnYear));
//		selectYearBtn.selectByVisibleText("2014");
//		By listDate = By.className("react-datepicker__week");
//		List<WebElement> dates = driverWeb.findElements(listDate);
//		String date = dates.get(5).getText();
//		System.out.println("xcbmxzbc                  ");
//		System.out.println(date);
//		dates.get(5).click();  // Click vào phần tử thứ 5 ( Tức ngày 6 tháng...)
//			
//	}
	
	public String selectDateOfBirth() {
		driverWeb.findElement(btnDateOfBirth).click();
		Select selectYearBtn = new Select(driverWeb.findElement(By.className("react-datepicker__year-select")));
		selectYearBtn.selectByVisibleText("1996");
		Select selectMonthBtn = new Select(driverWeb.findElement(By.className("react-datepicker__month-select")));
		selectMonthBtn.selectByVisibleText("June");
		String day  = driverWeb.findElement(By.xpath("//div[contains(text(),'16')]")).getText();
		driverWeb.findElement(By.xpath("//div[contains(text(),'16')]")).click();
		String date = day + " June,1996" ;
		return date;
	}
	
	public String selectState() {
		driverWeb.findElement(btnState).click();
		driverWeb.findElement(By.xpath("//div[@id='react-select-3-option-0']")).click();
		driverWeb.findElement(By.id("currentAddress")).click();
		return driverWeb.findElement(btnState).getText();
	}
	
	public String selectCity() {
		driverWeb.findElement(btnCity).click();
		driverWeb.findElement(By.xpath("//div[@id='react-select-4-option-0']")).click();
		driverWeb.findElement(By.id("currentAddress")).click();
		return driverWeb.findElement(btnCity).getText();
	}
	
	
	public By getStateBtn() {
		return btnState;
	}

	public By getElementuploadImgBtn() {
		return btnUploadImg;
	}

	public By getElementSubmitBtn() {
		return btnSubmit;
	}

	public ThanksForSubmittingPage clickSubmit() {
		driverWeb.findElement(btnSubmit).click();
		return new ThanksForSubmittingPage(driverWeb);
	}

}
