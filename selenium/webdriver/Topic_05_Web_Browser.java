package webdriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Topic_05_Web_Browser {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
// Change 
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void TC_01_() {
		// >=2: Đóng tab/ window mà nó đang đứng
		// =1: Đóng browser
		driver.close();
		
		// Không quan tâm bao nhiêu tab/window -> Browser
		driver.quit();
		
		//Có thể lưu vào 1 biến để sử dụng cho các step sau -> dùng lại nhiều lần
		//Clean code
		//Tìm 1 element
		WebElement emailTextbox = driver.findElement(By.xpath("//input[@id='email']"));
		emailTextbox.clear();
		emailTextbox.sendKeys("");
		
		//Bad code
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("");
		
		//Tìm nhiều elements
		List<WebElement> checkboxes = driver.findElements(By.xpath(""));
		  
		//Mở ra 1 Url nào đó
		driver.get("https://www.facebook.com/");
		
		//Trả về URL của page hiện tại
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");
		
		//Trả về Source code HTML của page hiện tại
		//Verify tương đối
		Assert.assertTrue(driver.getPageSource().contains("trong cuộc sống của bạn."));
		
		//Trả về title của page hiện tại
		Assert.assertEquals(driver.getTitle(), "Facebook - Đăng nhập hoặc đăng ký");
		
		//Lấy ra được ID của Window/ Tab mà driver đang đứng (active)
		String loginWindowID = driver.getWindowHandle();
		
		//Lấy ra ID của tất cả các Window/ Tab
		Set<String> allIDs = driver.getWindowHandles();
		
		//Cookie/ Cache
		Options opt = driver.manage();
		
		//Login thành công -> Lưu lại
		opt.getCookies();
		
		opt.logs();
		
		Timeouts time = opt.timeouts();
		//Khoảng thời gian chờ element xuất hiện trong vòng x giây 
		time.implicitlyWait(5, TimeUnit.SECONDS);
		time.implicitlyWait(5000, TimeUnit.MILLISECONDS);
		time.implicitlyWait(5000000, TimeUnit.MICROSECONDS);
		
		//Khoảng thời gian chờ page load xong trong vòng x giây
		time.pageLoadTimeout(5, TimeUnit.SECONDS);
		
		//Khoảng thời gian chờ script được thực thi xong trong vòng x giây
		time.setScriptTimeout(5, TimeUnit.SECONDS);
		
		Window win = opt.window();
		win.fullscreen();
		win.maximize();
		
		//Test GUI: Font/ Size/ Color/ Position/ Location/...
		win.getPosition();
		win.getSize();
		
		Navigation nav = driver.navigate();
		nav.back();
		nav.refresh();
		nav.forward();
		
		nav.to("https://www.facebook.com/");
		
		TargetLocator tar = driver.switchTo();
		//WebDriver API - Alert/ Authentication Alert (Alert library)
		tar.alert();
		
		//WebDriver API - Frame/ Iframe
		tar.frame("");
		
		//WebDriver API - Windows/Tabs
		tar.window("");
	}
 }
