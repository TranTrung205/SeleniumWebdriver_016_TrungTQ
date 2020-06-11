package Dropdownlist;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class BT02 {

	WebDriver driver;
	String testLink = "https://automationfc.github.io/basic-form/index.html";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(testLink);
	}

	@Test
	public void BT02() {
		Select jobRole01 = new Select(driver.findElement(By.xpath("//select[@id='job1']")));
		Select jobRole02 = new Select(driver.findElement(By.xpath("//select[@id='job2']")));
		// Kiem tra dropdown Job Role 01 - Single Dropdown: khong hỗ trợ thuộc tính
		// multiple select
		Assert.assertFalse(jobRole01.isMultiple());

		// Chon gia tri Mobile Testing trong dropdown
		jobRole01.selectByVisibleText("Mobile Testing");
		Assert.assertEquals("Mobile Testing", jobRole01.getFirstSelectedOption().getText());

		// Chon gia tri Manual Testing trong dropdown
		jobRole01.selectByValue("manual");
		Assert.assertEquals("Manual Testing", jobRole01.getFirstSelectedOption().getText());

		// Chon gia tri Functional UI Testing trong dropdown
		jobRole01.selectByIndex(9);
		Assert.assertEquals("Functional UI Testing", jobRole01.getFirstSelectedOption().getText());

		// Kiem tra Job 1 dropdown có đủ 10 giá trị
		Assert.assertEquals(10, jobRole01.getOptions().size());

		// Kiem tra Job Role 2 dropdown có thuoc tinh multiple select
		Assert.assertTrue(jobRole02.isMultiple());

		// Chọn 03 giá trị Automation, Mobile, Desktop
		jobRole02.selectByIndex(0);
		jobRole02.selectByVisibleText("Mobile");
		jobRole02.selectByValue("desktop");

		int optionSelected = jobRole02.getAllSelectedOptions().size();
		System.out.println("Selected items = " + optionSelected);

		List<WebElement> optionSelectedElement = jobRole02.getAllSelectedOptions();

		for (WebElement option : optionSelectedElement) {
			System.out.println(option.getText());
		}
		// Deselect all
		jobRole02.deselectAll();
		// Kiem tra so luong selected sau khi DeselectAll
		optionSelected = jobRole02.getAllSelectedOptions().size();
		System.out.println("Selected items = " + optionSelected);
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
