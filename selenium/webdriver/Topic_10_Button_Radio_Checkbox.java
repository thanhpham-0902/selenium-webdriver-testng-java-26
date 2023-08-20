package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_10_Button_Radio_Checkbox {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
// Change 
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Button() {
		driver.get("https://www.fahasa.com/customer/account/create");
		
		driver.findElement(By.cssSelector("li.popup-login-tab-item")).click();
	}

	@Test
	public void TC_02_() {

	}

	@Test
	public void TC_03_() {

	}
	
	public void sleepInSecond(long timeInSecond) {
		// tại sao * 1000 vì hàm nhận đơn vị ms nên mình phải đổi từ s → ms, 1000 ms = 1 s (chuyển về ms)
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
