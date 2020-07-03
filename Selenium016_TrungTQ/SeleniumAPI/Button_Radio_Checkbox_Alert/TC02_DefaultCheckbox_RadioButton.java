package Button_Radio_Checkbox_Alert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC02_DefaultCheckbox_RadioButton {
	WebDriver driver;
	String testLink = "https://demos.telerik.com/kendo-ui/checkbox";
	String testLink2 = "https://demos.telerik.com/kendo-ui/radiobutton/index";

	@BeforeClass
	public void beforeClass() {
		// System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		// driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.get(testLink);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC02_DefaultCheckbox_RadioButton() {
		WebElement DualZoneAC_checbox = driver.findElement(By.id("eq5"));
		// Click vào Checkbox: Dual-zone air conditioning
		if (!DualZoneAC_checbox.isSelected()) {
			DualZoneAC_checbox.click();
		}
		// Kiem tra checkbox đã chọn
		Assert.assertTrue(DualZoneAC_checbox.isSelected());
		// Click vào bỏ chọn checkbox: Dual-zone air conditioning
		if (DualZoneAC_checbox.isSelected()) {
			DualZoneAC_checbox.click();
		}
		// Kiem tra checkbox đã bỏ chọn
		Assert.assertTrue(DualZoneAC_checbox.isSelected() == false);

		// Chuyển qua trang web
		driver.navigate().to(testLink2);

		// Click radio button: 2.0 Petrol, 147kW
		WebElement engine3RadioBtn = driver.findElement(By.id("engine3"));
		engine3RadioBtn.click();

		// Kiem tra radio button đã bỏ chọn
		Assert.assertTrue(engine3RadioBtn.isSelected());
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
