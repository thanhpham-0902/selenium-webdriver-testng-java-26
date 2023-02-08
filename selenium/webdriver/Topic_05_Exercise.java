package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Exercise {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	By emailTextbox = By.id("mail");
	By AgeUnder18 = By.id("under_18");
	By EducationTextArea = By.id("edu");
	By Name_user5 = By.xpath("//div[@class='figcaption']/h5[text()='Name: User5']");
	By JobRole1 = By.id("job1");
	By JobRole2 = By.id("job2");
	By JobRole3 = By.id("job3");
	By devcheckbox = By.id("development");
	By Slider1 = By.id("slider-1");
	By Password = By.id("disable_password");
	By RadioButton = By.id("radio-disabled");
	By Biography = By.id("bio");
	By Checkbox = By.id("check-disbaled");
	By Slider2 = By.id("slider-2");
	By Java = By.id("java");
	
// Change 
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	//@Test
	public void TC_01_Url() {
		//Truy cập vào đường link
		driver.get("http://live.techpanda.org/");
		
		//Bấm button MY ACCOUNT
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(1);
		
		//Verify url của Login Page
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
		
		//Bấm button CREATE AN ACCOUNT
		driver.findElement(By.cssSelector("a.button")).click();
		sleepInSecond(1);
		
		//Verify url của Register Page
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
	}

	//@Test
	public void TC_02_getTitle() {
		//Truy cập vào đường link
		driver.get("http://live.techpanda.org/");
		
		//Bấm button MY ACCOUNT
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(1);
		
		//Verify title của Login Page
		Assert.assertEquals(driver.getTitle(), "Customer Login");
		
		//Bấm button CREATE AN ACCOUNT
		driver.findElement(By.cssSelector("a.button")).click();
		sleepInSecond(1);
		
		//Verify title của Register Page
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
	}

	//@Test
	public void TC_03_Navigation() {
		//Truy cập vào đường link
		driver.get("http://live.techpanda.org/");
		
		//Bấm button MY ACCOUNT
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(1);
		
		//Bấm button CREATE AN ACCOUNT
		driver.findElement(By.cssSelector("a.button")).click();
		sleepInSecond(1);
		
		//Verify url của Register Page
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
		
		//Back lại trang Login
		driver.navigate().back();
		sleepInSecond(1);
		
		//Verify url của Login Page
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
		
		//Forward tới trang Register Page
		driver.navigate().forward();
		sleepInSecond(1);
		
		//Verify title của Register Page
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
	}
	
	//@Test
	public void TC_04_getPageSource() {
		//Truy cập vào đường link
		driver.get("http://live.techpanda.org/");
		
		//Bấm button MY ACCOUNT
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(1);
		
		//Verify Login Page chứa text Login or Create an Account
		Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
		
		//Bấm button CREATE AN ACCOUNT
		driver.findElement(By.cssSelector("a.button")).click();
		sleepInSecond(1);
		
		//Verify Register Page chứa text Create an Account
		Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
	}

	public void sleepInSecond(long timeInSecond) {
		// tại sao * 1000 vì hàm nhận đơn vị ms nên mình phải đổi từ s → ms, 1000 ms = 1 s (chuyển về ms)
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//@Test
	public void TC_01_isDisplayed() {
		//Truy cập đường link
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		//Kiểm tra phần tử email hiển thị
		if (driver.findElement(emailTextbox).isDisplayed()) {
			driver.findElement(emailTextbox).sendKeys("Automation Testing");
			System.out.println("Email is displayed");
		} else {
			System.out.println("Email is not displayed");
		}
		
		//Kiểm tra phần tử Age (Under 18) hiển thị
		if (driver.findElement(AgeUnder18).isDisplayed()) {
			driver.findElement(AgeUnder18).click();
			System.out.println("Age (Under 18) is displayed");
		} else {
			System.out.println("Age (Under 18) is not displayed");
		}
		
		//Kiểm tra phần tử Education hiển thị
		if (driver.findElement(EducationTextArea).isDisplayed()) {
			driver.findElement(EducationTextArea).sendKeys("Automation Testing");
			System.out.println("Education is displayed");
		} else {
			System.out.println("Education is not displayed");
		}
		
		//Kiểm tra phần tử Name: User5 không hiển thị
		if (driver.findElement(Name_user5).isDisplayed()) {
			System.out.println("Name: User5 is displayed");
		} else {
			System.out.println("Name: User5 is not displayed");
		}
	}

	//@Test
	public void TC_02_isEnabled() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		//Kiểm tra phần tử email enable trên trang
		if (driver.findElement(emailTextbox).isEnabled()) {
			System.out.println("Email is enabled");
		} else {
			System.out.println("Email is disabled");
		}
		
		//Kiểm tra phần tử Age (Under 18) enable trên trang
		if (driver.findElement(AgeUnder18).isEnabled()) {
			System.out.println("Age is enabled");
		} else {
			System.out.println("Age is disabled");
		}
		
		//Kiểm tra Education enable trên trang
		if (driver.findElement(EducationTextArea).isEnabled()) {
			System.out.println("Education is enabled");
		} else {
			System.out.println("Education is disabled");
		}
		
		//Kiểm tra Job Role 01 enable trên trang
		if (driver.findElement(JobRole1).isEnabled()) {
			System.out.println("Job Role 1 is enabled");
		} else {
			System.out.println("Job Role 1 is disabled");
		}
		
		//Kiểm tra Job Role 02 enable trên trang
		if (driver.findElement(JobRole2).isEnabled()) {
			System.out.println("Job Role 2 is enabled");
		} else {
			System.out.println("Job Role 2 is disabled");
		}
		
		//Kiểm tra Password disable trên trang
		if (driver.findElement(Password).isEnabled()) {
			System.out.println("Password is enabled");
		} else {
			System.out.println("Password is disabled");
		}
		
		//Kiểm tra Age (Radiobutton is disabled) disable trên trang
		if (driver.findElement(RadioButton).isEnabled()) {
			System.out.println("Age (Radiobutton is disabled) is enabled");
		} else {
			System.out.println("Age (Radiobutton is disabled) is disabled");
		}
		
		//Kiểm tra Biography disable trên trang
		if (driver.findElement(Biography).isEnabled()) {
			System.out.println("Biography is enabled");
		} else {
			System.out.println("Biography is disabled");
		}
		
		//Kiểm tra Job Role 03 disable trên trang
		if (driver.findElement(JobRole3).isEnabled()) {
			System.out.println("Job Role 03 is enabled");
		} else {
			System.out.println("Job Role 03 is disabled");
		}	
		
		//Kiểm tra Interests (Checkbox is disabled) disable trên trang
		if (driver.findElement(Checkbox).isEnabled()) {
			System.out.println("Interests (Checkbox is disabled) is enabled");
		} else {
			System.out.println("Interests (Checkbox is disabled) is disabled");
		}	
		
		//Kiểm tra Slider 02 (Disabled) disable trên trang
		if (driver.findElement(Slider2).isEnabled()) {
			System.out.println("Slider 02 (Disabled) is enabled");
		} else {
			System.out.println("Slider 02 (Disabled) is disabled");
		}	
	}

	//@Test
	public void TC_03_isSelected() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		//Click chọn Age (Under 18) radio button và "Languagues: Java" checkbox
		driver.findElement(AgeUnder18).click();
		driver.findElement(By.id("java")).click();
		
		//Kiểm tra phần tử Age (Under 18) đã được chọn
		if (driver.findElement(AgeUnder18).isSelected()) {
			System.out.println("Age (Under 18) is selected");
		} else {
			System.out.println("Age (Under 18) is de-selected");
		}
		
		//Kiểm tra phần tử "Languagues: Java" checkbox đã được chọn
		if (driver.findElement(Java).isSelected()) {
			System.out.println("\"Languagues: Java\" checkbox is selected");
		} else {
			System.out.println("\"Languagues: Java\" checkbox is de-selected");
		}
		
		//Click để bỏ chọn "Languagues: Java" checkbox
		driver.findElement(By.id("java")).click();
		
		//Kiểm tra phần tử "Languagues: Java" checkbox đã được bỏ chọn
		if (driver.findElement(Java).isSelected()) {
			System.out.println("\"Languagues: Java\" checkbox is selected");
		} else {
			System.out.println("\"Languagues: Java\" checkbox is de-selected");
		}
	}

	//@Test
	public void TC_04_MailChimp() {
		driver.get("https://login.mailchimp.com/signup/");
		By txt_password = By.id("new_password");
		By btn_Signup = By.id("create-account-enabled");
		
		//Nhập trường email
		driver.findElement(By.id("email")).sendKeys("johnwick2022@gmail.com");
		
		//Nhập trường password
		driver.findElement(txt_password).sendKeys("abc");
		sleepInSecond(2);
		
		//Verify lowercase
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(txt_password).clear();
		driver.findElement(txt_password).sendKeys("ABC");
		sleepInSecond(2);
		
		//Verify uppercase
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(txt_password).clear();
		driver.findElement(txt_password).sendKeys("123");
		sleepInSecond(2);
		
		//Verify number
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(txt_password).clear();
		driver.findElement(txt_password).sendKeys("!@#");
		sleepInSecond(2);
		
		//Verify special character
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		driver.findElement(txt_password).clear();
		driver.findElement(txt_password).sendKeys("ABCXYZGHM");
		sleepInSecond(2);
		
		//Verify >= 8 char
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		
		driver.findElement(txt_password).clear();
		driver.findElement(txt_password).sendKeys("abc123ABC!@#");
		sleepInSecond(2);
		
		//Verify full data
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
	}

	//@Test
	public void TC_01_Login() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(2);
		driver.findElement(By.xpath("//button[@class='button']")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field.");
		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(), "This is a required field.");
	}

	//@Test
	public void TC_02_Login() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(2);
		driver.findElement(By.id("email")).sendKeys("123456@123456.123");
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@class='button']")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
	}
	
	//@Test
	public void TC_03_Login() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(2);
		driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123");
		driver.findElement(By.xpath("//button[@class='button']")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
	}

	//@Test
	public void TC_04_Login() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(2);
		driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123123123");
		driver.findElement(By.xpath("//button[@class='button']")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']")).getText(), "Invalid login or password.");
	}

	//@Test
	public void TC_05_Login() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(2);
		driver.findElement(By.cssSelector("div.buttons-set a.button")).click();
		sleepInSecond(2);
		driver.findElement(By.id("firstname")).sendKeys("Nguyen");
		driver.findElement(By.id("middlename")).sendKeys("Van");
		driver.findElement(By.id("lastname")).sendKeys("An");
		driver.findElement(By.id("email_address")).sendKeys("annguyen5x@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("confirmation")).sendKeys("123456");
		driver.findElement(By.xpath("//div[@class='buttons-set']//button[@class='button']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Thank you for registering with Main Website Store.']")).getText(), "Thank you for registering with Main Website Store.");
		driver.findElement(By.xpath("//a[@class='skip-link skip-account']//span[@class='label']")).click();
		driver.findElement(By.xpath("//li[@class=' last']//a[@title='Log Out']")).click();
		sleepInSecond(15);
		Assert.assertEquals(driver.getTitle(), "Home page");
	}

	@Test
	public void TC_06_Login() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		sleepInSecond(2);
		driver.findElement(By.id("email")).sendKeys("annguyen5x@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@class='button']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='box-content']//p[contains(text(),'Nguyen Van An')]")).getText(), "Nguyen Van An");
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
