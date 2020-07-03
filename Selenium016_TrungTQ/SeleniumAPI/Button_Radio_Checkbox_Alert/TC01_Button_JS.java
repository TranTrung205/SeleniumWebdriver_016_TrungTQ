package Button_Radio_Checkbox_Alert;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TC01_Button_JS {
	WebDriver driver;
	String testLink = "https://www.fahasa.com/customer/account/create";
	By dangNhapText = By.className("fhs_top_account_login_button");
	By dangNhapBtn = By.className("fhs-btn-login");
	By sdt = By.name("youama-email");
	By pwd = By.name("youama-password");
	By errorMessSDT = By.xpath(
			"//div[@class='fhs-input-box checked-error']//div[@class='fhs-input-alert'][contains(text(),'Thông tin này không th')]");
	By errorMessPWD = By.xpath(
			"//div[@class='fhs-input-box checked-error']//div[@class='fhs-input-alert'][contains(text(),'Thông tin này không th')]");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(testLink);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC01_Button_JS() {
		driver.findElement(dangNhapText).click();
		Assert.assertTrue(driver.findElement(dangNhapBtn).isEnabled() == false);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(sdt));
		driver.findElement(sdt).sendKeys("0799666888");
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(pwd));
		driver.findElement(pwd).sendKeys("111111");
		Assert.assertTrue(driver.findElement(dangNhapBtn).isEnabled());
		driver.navigate().refresh();
		driver.findElement(dangNhapText).click();
		((JavascriptExecutor) driver)
				.executeScript("document.querySelector('button.fhs-btn-login').removeAttribute('disabled')");
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(dangNhapBtn));
		Assert.assertEquals(driver.findElement(errorMessSDT).getText(), "Thông tin này không thể để trống");
		Assert.assertEquals(driver.findElement(errorMessPWD).getText(), "Thông tin này không thể để trống");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
