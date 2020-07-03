package Button_Radio_Checkbox_Alert;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TC03_CustomerCheckbox_RadioButton {
	WebDriver driver;
	String testLink = "https://material.angular.io/components/radio/examples";
	String testLink2 = "https://material.angular.io/components/checkbox/examples";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		driver.get(testLink);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC03_CustomerCheckbox_RadioButton() {
		WebElement summerRadioBtn = driver.findElement(By.id("mat-radio-4-input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", summerRadioBtn);
		Assert.assertTrue(summerRadioBtn.isSelected());
		driver.navigate().to(testLink2);
		WebElement checkedBox = driver.findElement(By.id("mat-checkbox-1-input"));
		WebElement indeterminateCheckBox = driver.findElement(By.id("mat-checkbox-2-input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkedBox);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", indeterminateCheckBox);
		Assert.assertTrue(checkedBox.isSelected());
		Assert.assertTrue(indeterminateCheckBox.isSelected());
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkedBox);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", indeterminateCheckBox);
		Assert.assertTrue(checkedBox.isSelected() == false);
		Assert.assertTrue(indeterminateCheckBox.isSelected() == false);
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
