package common;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestBasic {
	public WebDriver driver;

	public void openWebsite(String url) {
		System.setProperty("webdriver.chrome.driver", "D:\\AutomationTest\\01Tool\\chromedriver.exe");
		driver = new ChromeDriver();

//		System.setProperty("webdriver.edge.driver", "D:\\AutomationTest\\01Tool\\msedgedriver.exe");
//		driver = new EdgeDriver();
		driver.get(url);
	}

	public void closeBrowser() {
		driver.quit();// close toàn bộ cửa sổ
	}

	public void scrollBrowser() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void setSizebrowser() {
		Dimension dm = new Dimension(700, 1000);
		// Setting the current window to that dimension
		driver.manage().window().setSize(dm);
	}

	public void srollToElement(By element) {
		WebElement iframe = driver.findElement(element);
//	        new Actions(driver)      Lệnh sroll của selenium.
//	                .moveToElement(iframe)
//	                .perform();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iframe); // Dung js
	}

	public By getLocatorString(String locatorType, String locatorValue) {
		By result = null;

		return result;

	}
}
