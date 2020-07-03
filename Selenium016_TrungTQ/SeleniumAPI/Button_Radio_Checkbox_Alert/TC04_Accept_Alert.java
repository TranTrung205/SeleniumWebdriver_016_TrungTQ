package Button_Radio_Checkbox_Alert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.security.Credentials;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC04_Accept_Alert {
	WebDriver driver;
	String testLink = "https://automationfc.github.io/basic-form/index.html";

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
	public void TC04_Accept_Alert() {
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String alertText = alert.getText();
		Assert.assertEquals(alertText, "I am a JS Alert");
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='result']")).getText(),
				"You clicked an alert successfully");

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
