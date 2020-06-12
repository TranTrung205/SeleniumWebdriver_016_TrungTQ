package Dropdownlist;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class BT03 {
	WebDriver driver;
	String testLink = "https://demo.nopcommerce.com/register";
	By Register = By.xpath("//a[text()='Register']");
	By male = By.id("gender-male");
	By female = By.id("gender-female");
	By firstname = By.name("FirstName");
	By lastname = By.name("LastName");
	By Day = By.name("DateOfBirthDay");
	By Month = By.name("DateOfBirthMonth");
	By Year = By.name("DateOfBirthYear");
	By email = By.name("Email");
	By password = By.name("Password");
	By confirmpassword = By.name("ConfirmPassword");
	By registerButton = By.name("register-button");
	By myAccount = By.xpath("//a[text()='My account']");
	By logout = By.xpath("//a[text()='Log out']");
	By successMessage = By.className("result");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(testLink);

	}

	@Test
	public void TC03() {
		// Click vao Register trên Header
		driver.findElement(Register).click();
		// Chọn gender
		driver.findElement(male).click();
		// Điền First name, Last name
		driver.findElement(firstname).clear();
		driver.findElement(firstname).sendKeys("Cristiano");
		driver.findElement(lastname).clear();
		driver.findElement(lastname).sendKeys("Ronaldo");
		// Chon ngay 1, kiem tra so luong ngay
		Select dateOfBirthDay = new Select(driver.findElement(Day));
		Select monthOfBirthDay = new Select(driver.findElement(Month));
		Select yearOfBirthDay = new Select(driver.findElement(Year));

		Assert.assertEquals(32, dateOfBirthDay.getOptions().size());
		Assert.assertEquals(13, monthOfBirthDay.getOptions().size());
		Assert.assertEquals(112, yearOfBirthDay.getOptions().size());

		dateOfBirthDay.selectByValue("20");
		monthOfBirthDay.selectByValue("5");
		yearOfBirthDay.selectByValue("1990");
		// Điền email
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys("abc123@gmail.com");
		// Điền password
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys("123456");
		driver.findElement(confirmpassword).clear();
		driver.findElement(confirmpassword).sendKeys("123456");
		// Click Register button
		driver.findElement(registerButton).click();

		Assert.assertTrue(driver.findElement(myAccount).isDisplayed());
		Assert.assertTrue(driver.findElement(logout).isDisplayed());
		Assert.assertEquals("Your registration completed", driver.findElement(successMessage).getText());
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
