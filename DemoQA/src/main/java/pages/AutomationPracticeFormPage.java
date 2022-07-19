package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class AutomationPracticeFormPage extends Page {

	By txtFirstName = By.id("firstName");
	By txtLastName = By.id("lastName");
	By txtUserEmail = By.id("userEmail");
	By radioGenderRadioMale = By.xpath("//*[@for='gender-radio-1']");
	By radioGenderRadioFemale = By.xpath("//*[@for='gender-radio-2']");
	By radioGenderRadioOther = By.xpath("//*[@for='gender-radio-3']");
	By txtMobile = By.id("userNumber");
	By btnDateOfBirth = By.id("dateOfBirthInput");
	By btnSubjects = By.id("subjectsContainer");
	By inputSubjects = By.id("subjectsInput");
	By checkboxSports = By.xpath("//label[contains(text(),'Sports')]");
	By checkboxReading = By.xpath("//label[contains(text(),'Reading')]");
	By checkboxMusic = By.xpath("//label[contains(text(),'Music')]");
	By ddYear = By.className("react-datepicker__year-select");
	By ddMonth = By.className("react-datepicker__month-select");
	By btnDay = By.xpath("//div[contains(text(),'16')]");
	By btnUploadImg = By.id("uploadPicture");
	By ddState = By.id("state");
	By inputState = By.id("react-select-3-input");
	By ddCity = By.id("city");
	By inputCity = By.id("react-select-4-input");
	By btnSubmit = By.id("submit");

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

	public By getGenderXpath(String gender) {
		By result = null;
		if (gender.equalsIgnoreCase("Male")) {
			result = radioGenderRadioMale;
		} else if (gender.equalsIgnoreCase("Female")) {
			result = radioGenderRadioFemale;
		} else {
			result = radioGenderRadioOther;
		}
		return result;
	}

	public void inputGender(String gender) {
		driverWeb.findElement(getGenderXpath(gender)).click();
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

	public void inputDateOfBirth(String inputDate) {
		inputDate = inputDate.replace(",", " ");
		String[] arrayDate = inputDate.split(" ");
		String day = new String(arrayDate[0]);
		String month = new String(arrayDate[1]);
		String year = new String(arrayDate[2]);
		driverWeb.findElement(btnDateOfBirth).click();
		selectElemetFromDropdown(ddYear, year);
		selectElemetFromDropdown(ddMonth, month);
		String dayXpath = String.format("//div[contains(text(),'%s')]", day);
		driverWeb.findElement(By.xpath(dayXpath)).click();
	}
	
	public By getBtnUploadImg() {
		return btnUploadImg;
	} 
	
	public void inputSubjects(String subjects) {
		driverWeb.findElement(btnSubjects).click();
		driverWeb.findElement(inputSubjects).sendKeys(subjects);
		driverWeb.findElement(inputSubjects).sendKeys(Keys.ENTER);
	}
	
	public By getHobbiesXpath(String hobbie) {
		By result = null;
		if (hobbie.equalsIgnoreCase("Sports")) {
			result = checkboxSports;
		} else if (hobbie.equalsIgnoreCase("Reading")) {
			result = checkboxReading;
		} else if (hobbie.equalsIgnoreCase("Music")) {
			result = checkboxMusic;
		}
		return result;
	}

	public void inputHobbies(String hobbie) {
		driverWeb.findElement(getHobbiesXpath(hobbie)).click();
	}

	public void inputState(String state) {
		driverWeb.findElement(ddState).click();
		driverWeb.findElement(inputState).sendKeys(state);
		driverWeb.findElement(inputState).sendKeys(Keys.ENTER);
	}

	public void inputCity(String city) {
		driverWeb.findElement(ddCity).click();
		driverWeb.findElement(inputCity).sendKeys(city);
		driverWeb.findElement(inputCity).sendKeys(Keys.ENTER);
	}

	public By getDdState() {
		return ddState;
	}

	public By getBtnSubmit() {
		return btnSubmit;
	}

	public ThanksForSubmittingPage clickSubmit() {
		driverWeb.findElement(btnSubmit).click();
		return new ThanksForSubmittingPage(driverWeb);
	}

}
