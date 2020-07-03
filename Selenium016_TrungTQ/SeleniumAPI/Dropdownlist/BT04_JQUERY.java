package Dropdownlist;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class BT04_JQUERY {
	WebDriver driver;
	JavascriptExecutor javascriptExecutor;
	String jQueryLink = "https://jqueryui.com/resources/demos/selectmenu/default.html";
	By menuNumber = By.name("number");
	By numberButton = By.id("number-button");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	@Test
	public void TC04_Jquey() {
		driver.get(jQueryLink);

		WebElement numberDropdowlist = driver.findElement(numberButton);
		numberDropdowlist.click();

		Select number = new Select(driver.findElement(menuNumber));
		System.out.println("size: " + number.getOptions().size());
		List<WebElement> allitems = driver.findElements(menuNumber);
		for (WebElement targetItem : allitems) {
			System.out.println("item: " + targetItem.getText());
		}
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
