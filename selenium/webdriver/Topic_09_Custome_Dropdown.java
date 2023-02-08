package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_Custome_Dropdown {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	WebDriverWait explicitWait;
// Change 
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_JQuery() {
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		
		// Click vào 1 thẻ bất kì làm sao cho nó xổ ra hết câc item của dropdownlist
		driver.findElement(By.cssSelector("span#speed-button")).click();
		
		// Chờ cho tất cả các item được load ra thành công
		// Locator phải đại diện cho tất cả các item
		// Lấy đến thẻ chứa text
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@role='option']")));
		
		// Đưa hết tất cả item trong dropdown vào 1 list
		List<WebElement> speedDropDownList = driver.findElements(By.xpath("//div[@role='option']"));
		
		// Tìm item xem đúng cái đang cần hay không (dùng vòng lặp duyệt qua)
		for (WebElement temItem : speedDropDownList) {
			String itemText = temItem.getText();
			System.out.println(itemText);
			
			if(itemText.equals("Fast"))
			{
				System.out.println("Click vào item");
				temItem.click();
				break;
			}
			else
			{
				System.out.println("Không click vào item");
			}
		}
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
