package TextBox_TextArea;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BT01 {
	// https://docs.google.com/document/d/1QRI6jdKoCiMB3K7s16f3jEtAVHICdROpw_t30RD8gac/edit#
	WebDriver driver;
	String username = "mngr265312";
	String password = "epamEzU";
	String testGuruV4 = "http://demo.guru99.com/v4/";
	By loginBTN = By.name("btnLogin");
	By name = By.name("name");
	By dob = By.name("dob");
	By address = By.name("addr");
	By city = By.name("city");
	By state = By.name("state");
	By pin = By.name("pinno");
	By mobileNo = By.name("telephoneno");
	By email = By.name("emailid");
	By pwd = By.name("password");
	By submitBtn = By.name("sub");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(testGuruV4);
		// Login
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(loginBTN).click();
	}

	@Test
	public void BT01() {
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		// Customer name
		driver.findElement(name).clear();
		driver.findElement(name).sendKeys("Selenium BT Mot");
		// Radio button: male & female
		WebElement maleRadioButton = driver.findElement(By.xpath("//input[@value='m']"));
		WebElement femaleRadioButton = driver.findElement(By.xpath("//input[@value='f']"));
		if (!femaleRadioButton.isSelected()) {
			femaleRadioButton.click();
		}
		// DOB
		driver.findElement(dob).clear();
		driver.findElement(dob).sendKeys("01/01/2000");
		// ADDRESS
		driver.findElement(address).clear();
		driver.findElement(address).sendKeys("abc 123");
		// CITY
		driver.findElement(city).clear();
		driver.findElement(city).sendKeys("HCMC");
		// STATE
		driver.findElement(state).clear();
		driver.findElement(state).sendKeys("HCMC STATE");
		// PIN
		driver.findElement(pin).clear();
		driver.findElement(pin).sendKeys("123456");
		// MOBILE NO
		driver.findElement(mobileNo).clear();
		driver.findElement(mobileNo).sendKeys("0909123456");
		// EMAIL
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys("abc" + getRandomNumberUsingNextInt(1, 999) + "@gmail.com");
		// PASSWORD
		driver.findElement(pwd).clear();
		driver.findElement(pwd).sendKeys("abc123");
		// Click Submit button
		driver.findElement(submitBtn).click();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

	public int getRandomNumberUsingNextInt(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}

}
