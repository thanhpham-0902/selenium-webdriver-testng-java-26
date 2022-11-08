package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Web_Element {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	//By chưa đi tìm element ngay
	By emailTextboxBy = By.id("Email");
	By passwordTextboxBy = By.id("Pass");
	
// Change 
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_() {
		WebElement element = driver.findElement(By.className(""));
		
		//Dùng cho các textbox. textarea/ dropdown (Editable)
		//Xóa dữ liệu đi trước khi nhập text
		element.clear();
		
		//Dùng cho các textbox. textarea/ dropdown (Editable)
		//Nhập liệu
		element.sendKeys("");
		
		//Click vào các button/ link/ checkbox/ radio/ image/...
		element.click();
		
		
		String searchAttribute = element.getAttribute("placeholder");
		String emailTextboxAttribute = element.getAttribute("value");
		//Search store
		
		//GUI: Font/ Size/ Color/ Location/ Position...
		element.getCssValue("background-color");
		// => #4ab2f1
		
		//Vị trí của element so với web (bên ngoài)
		Point point = element.getLocation();
		point.x = 123;
		point.y = 321;
		
		//Kích thước (chiều cao, chiều rộng) của element (bên trong)
		Dimension di = element.getSize();
		di.getHeight();
		di.getWidth();
		
		System.out.println(di.height);
		System.out.println(di.width);
		
		//Location + size
		element.getRect();
		
		//Chụp hình bị lỗi khi test case fail
		element.getScreenshotAs(OutputType.FILE);
		element.getScreenshotAs(OutputType.BYTES);
		element.getScreenshotAs(OutputType.BASE64);
		
		//Khi cần lấy ra tên thẻ HTML của element đó
		//Phù hợp với locator name, id, css -> dùng để truyền vào cho 1 locator khác
		driver.findElement(By.id("Email")).getTagName();
		driver.findElement(By.name("Email")).getTagName();
		
		String emailTextboxTagname = driver.findElement(By.cssSelector("#Email")).getTagName();
		driver.findElement(By.xpath("//" + emailTextboxTagname + "[@id='email']"));
		
		//Lấy text từ Error message/success message/ label/ header...
		element.getText();
		
		//Dùng để verify xem 1 element hiển thị hoặc không
		//Phạm vi: Tất cả các element
		Assert.assertTrue(element.isDisplayed());
		Assert.assertFalse(element.isDisplayed());
		
		//Dùng để verify xem một element có thao tác được hay không
		//Phạm vi: Tất cả các element
		Assert.assertTrue(element.isEnabled());
		Assert.assertFalse(element.isEnabled());
		
		//Dùng để verify xem 1 element được chọn hay chưa
		//Phạm vi: Checkbox/ Radio
		Assert.assertTrue(element.isSelected());
		Assert.assertFalse(element.isSelected());
		
		//Các element nằm trong thẻ form
		//Hàm này tương ứng với lệnh enter
		element.submit();
	}

	public void TC_02_Register() {
		driver.get("");
		
		driver.findElement(emailTextboxBy).sendKeys("");
		driver.findElement(passwordTextboxBy).sendKeys("");
	}
	
	public void TC_03_Login() {
		driver.get("");
		
		driver.findElement(emailTextboxBy).sendKeys("");
		driver.findElement(passwordTextboxBy).sendKeys("");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
