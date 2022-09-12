package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
// Change 
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//Mở trang Register ra 
		driver.get("https://www.demo.nopcommerce.com/register");
	}

	@Test
	public void TC_01_ID() {
		driver.findElement(By.id("Firstname")).sendKeys("Automation");
	}

	@Test
	public void TC_02_Class() {
		//Mở trang Search
		driver.get("https://www.demo.nopcommerce.com/search");
		
		//Nhập text vào Search textbox
		driver.findElement(By.className("text-box")).sendKeys("Macbook");
	}

	@Test
	public void TC_03_Name() {
		//Click vào checkbox
		driver.findElement(By.name("advs")).click();
	}
	
	@Test
	public void TC_04_TagName() {
		//Tìm ra số lượng thẻ input trên màn hình hiện tại
		System.out.println(driver.findElements(By.tagName("input")).size());
	}
	
	@Test
	public void TC_05_LinkText() {
		//Click vào đường link Addresses (nhập vào text và lấy tuyệt đối)
		driver.findElement(By.linkText("Addresses")).click();
	}
	
	@Test
	public void TC_06_PartialLinkText() {
		//Click vào đường link Apply for vendor account (tương đối)
		driver.findElement(By.partialLinkText("vendor account")).click();
	}
	
	@Test
	public void TC_07_Css() {
		driver.get("https://www.demo.nopcommerce.com/register");
		
		//1.
		driver.findElement(By.cssSelector("input#Firstname")).sendKeys("Selenium");
		
		//2.
		driver.findElement(By.cssSelector("input[id='LastName']")).sendKeys("Locator");
		
		//3.
		driver.findElement(By.cssSelector("input[name='Email']")).sendKeys("automation@gmail.com");
	}
	
	@Test
	public void TC_08_XPath() {
		driver.get("https://www.demo.nopcommerce.com/register");
		
		//1.
		driver.findElement(By.xpath("//input[@data-val-required='First name is required.']")).sendKeys("Selenium");
		
		//2.
		driver.findElement(By.xpath("input[id='LastName']")).sendKeys("Locator");
		
		//3.
		driver.findElement(By.xpath("input[name='Email']")).sendKeys("automation@gmail.com");
		
	}
	

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

}
