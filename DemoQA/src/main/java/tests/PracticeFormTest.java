package tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.TestBasic;
import pages.AutomationPracticeFormPage;
import pages.FormPage;
import pages.HomePage;
import pages.ThanksForSubmittingPage;

public class PracticeFormTest {

	String inputFirstName = "abc";
	String inputLastName = "abc";
	String inputUserEmail = "abc@abc.abc";
	String inputGender = "Female";
	String inputMobile = "0977987544";
	String inputDate = "16 June,1996";
	String inputSubjectsEnglish = "English";
	String inputSubjectsMath = "Maths";
	String inputHobbieSports = "Sports";
	String inputHobbieReading = "Reading";
	String inputImagePath = "D:\\AutomationTest\\04Img\\landscape-photography_1645-t.jpg";

	String inputState = "NCR";
	String inputCity = "Delhi";
	TestBasic testBasic = new TestBasic();

	// Contains all test cases which are test for Practice Form
	// TC01: [PracticeForm] Submit data successfully
	@BeforeMethod
	public void openWebsite() {
		testBasic.openWebsite("https://demoqa.com/");
	}

//	@AfterMethod
//	public void closeBrowser() {
//		testBasic.driver.quit();
//	} 
//	
	@Test
	public void submitDataSuccessfully() {
		HomePage homePage = new HomePage(testBasic.driver);
		testBasic.maximizeBrowser();
		testBasic.scrollBrowser();
		FormPage formPage = homePage.clickFormItem();
		AutomationPracticeFormPage automationPracticeFormPage = formPage.clickOnFormItem();
		automationPracticeFormPage.inputFirstName(inputFirstName);
		automationPracticeFormPage.inputLastName(inputLastName);
		automationPracticeFormPage.inputUserEmail(inputUserEmail);
		automationPracticeFormPage.inputGender(inputGender);
		automationPracticeFormPage.inputMobile(inputMobile);
		automationPracticeFormPage.uploadImg(automationPracticeFormPage.getBtnUploadImg(), inputImagePath);
		automationPracticeFormPage.inputDateOfBirth(inputDate);
		testBasic.setSizebrowser();
		testBasic.srollToElement(automationPracticeFormPage.getDdState());
		automationPracticeFormPage.inputSubjects(inputSubjectsEnglish);
		automationPracticeFormPage.inputSubjects(inputSubjectsMath);
		automationPracticeFormPage.inputHobbies(inputHobbieSports);
		automationPracticeFormPage.inputHobbies(inputHobbieReading);
		automationPracticeFormPage.inputState(inputState);
		automationPracticeFormPage.inputCity(inputCity);
		testBasic.srollToElement(automationPracticeFormPage.getBtnSubmit());
		ThanksForSubmittingPage thanksForSubmittingPage = automationPracticeFormPage.clickSubmit();
		automationPracticeFormPage.verifyTextPresent(thanksForSubmittingPage.getTextStudentName(),inputFirstName + " " + inputLastName);
		automationPracticeFormPage.verifyTextPresent(thanksForSubmittingPage.getTextStudentEmail(), inputUserEmail);
		automationPracticeFormPage.verifyTextPresent(thanksForSubmittingPage.getTextStudentGender(), inputGender);
		automationPracticeFormPage.verifyTextPresent(thanksForSubmittingPage.getTextMobile(), inputMobile);
		automationPracticeFormPage.verifyTextPresent(thanksForSubmittingPage.getTextDateOfBirth(), inputDate);
		automationPracticeFormPage.verifyTextPresent(thanksForSubmittingPage.getTextSubjects(), inputSubjectsEnglish + ", " + inputSubjectsMath);
		automationPracticeFormPage.verifyTextPresent(thanksForSubmittingPage.getTextHobbies(), inputHobbieSports + ", " + inputHobbieReading);
		automationPracticeFormPage.verifyTextPresent(thanksForSubmittingPage.getTextStateAndCity(), inputState + " " + inputCity );
	}

}
