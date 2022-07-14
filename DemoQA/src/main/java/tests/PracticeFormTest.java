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
	String inputMobile = "0977987544";
	
	TestBasic testBasic = new TestBasic();
	
	//Contains all test cases which are test for Practice Form
	//TC01: [PracticeForm] Submit data successfully
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
		automationPracticeFormPage.clickGenderRadioMale();
		String textGenderRadioMale = automationPracticeFormPage.getTextGenderRadioMale();
		automationPracticeFormPage.inputMobile(inputMobile);
		automationPracticeFormPage.uploadImg(automationPracticeFormPage.getElementuploadImgBtn(),"D:\\AutomationTest\\04Img\\landscape-photography_1645-t.jpg");
		automationPracticeFormPage.selectDateOfBirth();
		String dateOfBirth = automationPracticeFormPage.selectDateOfBirth();
		testBasic.setSizebrowser(); 
		testBasic.srollToElement(automationPracticeFormPage.getStateBtn());
		automationPracticeFormPage.selectState();
		String state = automationPracticeFormPage.selectState();
		automationPracticeFormPage.selectCity();
		String city = automationPracticeFormPage.selectCity();
		String stateAndCity = state + " " + city;
		testBasic.srollToElement(automationPracticeFormPage.getElementSubmitBtn());
		ThanksForSubmittingPage thanksForSubmittingPage = automationPracticeFormPage.clickSubmit();
		automationPracticeFormPage.verifyTextPresent(thanksForSubmittingPage.getTextStudentName(), inputFirstName + " " + inputLastName);
		automationPracticeFormPage.verifyTextPresent(thanksForSubmittingPage.getTextStudentEmail(), inputUserEmail);
		automationPracticeFormPage.verifyTextPresent(thanksForSubmittingPage.getTextStudentGender(), textGenderRadioMale);
		automationPracticeFormPage.verifyTextPresent(thanksForSubmittingPage.getTextMobile(), inputMobile);
		automationPracticeFormPage.verifyTextPresent(thanksForSubmittingPage.getTextDateOfBirth(), dateOfBirth );
		automationPracticeFormPage.verifyTextPresent(thanksForSubmittingPage.getTextStateAndCity(), stateAndCity );
	} 

}
