package Button_Radio_Checkbox_Alert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.security.Credentials;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC06_Prompt_Alert {
	WebDriver driver;
	String testLink = "https://automationfc.github.io/basic-form/index.html";
	String inputString = "You entered:";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		// driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.get(testLink);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC06_Prompt_Alert() {
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.sendKeys("trung");
		Assert.assertEquals(alertText, "I am a JS prompt");
		alert.accept();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(), "You entered: trung");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
