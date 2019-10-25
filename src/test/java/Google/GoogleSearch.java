package Google;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Util.AllureListener;
import Util.Base;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Listeners({AllureListener.class})

public class GoogleSearch {
	WebDriver driver;
	public Base base;
	public Properties prop;
	public GooglePage googlePage;
	
	@BeforeMethod
	public void SetUp() {
	base = new Base();
	prop=base.initialize_Properties();
	
	driver=base.Initilization();	
	driver.get(prop.getProperty("url"));
	googlePage = new GooglePage();
	}
	
	@Test(priority=1, description="TitleTest")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify Title Test")
	public void TitleTest() {
		String Title=driver.getTitle();
		Assert.assertEquals(Title, "Google");
	}
	@Test(priority=2, description="TitleTest1")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify Title Test")
	public void TitleTest2() {
		String Title=driver.getTitle();
		Assert.assertEquals(Title, "Google");
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
}
