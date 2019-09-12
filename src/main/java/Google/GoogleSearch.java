package Google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearch {
	WebDriver driver;
	
	@Test(priority=1)
	public void LaunchURL() {
	System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Selenium Setup Files\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("https://www.google.com/");
	driver.manage().window().maximize();
	
	}
	@Test(priority=2)
	public void TitleTest() {
		String Title=driver.getTitle();
		Assert.assertEquals(Title, "Google");
	}
	@Test(priority=3)
	public void TitleTest2() {
		String Title=driver.getTitle();
		Assert.assertEquals(Title, "Google");
		driver.close();
		
	}
}
