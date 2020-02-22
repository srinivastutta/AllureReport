package Google;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Util.Base;

public class freeCRM extends Base {

	@BeforeClass
	public void OpenBrowser() {
		Initilization();
		driver.get(initialize_Properties().getProperty("url1"));

	}

	@Test(priority = 1)
	public void loginTest() throws InterruptedException {
		System.out.println("Login Test Started");
		driver.findElement(By.xpath("//input[@name='email']"))
		.sendKeys(initialize_Properties().getProperty("username"));
		driver.findElement(By.xpath("//input[@name='password']"))
		.sendKeys(initialize_Properties().getProperty("password"));
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();

		WebElement NameElement = driver.findElement(By.xpath("//span[@class='user-display']"));
		String LoginName = NameElement.getText();
		System.out.println(LoginName);
		Assert.assertEquals(LoginName, "srinivas tutta");
		

		driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();

		Thread.sleep(3000);

		// Method 1
		// List <WebElement> TableData=
		// driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/table[1]/tbody[1]/tr/td"));
		//
		// for (WebElement td : TableData) {
		// System.out.println(td.getText());
		//
		// Method 2
		WebElement myTable = driver
				.findElement(By.xpath("//table[@class='ui celled sortable striped table custom-grid table-scroll']"));

		List<WebElement> tds = myTable.findElements(By.tagName("td"));

		for (WebElement td : tds) {
			System.out.println(td.getText());
			if (td.getText().contains("Vedik Tutta")) {
				td.click();

			}
}}

	@AfterClass
	public void TearDown() {
		driver.close();
	}
}
