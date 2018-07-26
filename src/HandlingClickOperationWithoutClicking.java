import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class HandlingClickOperationWithoutClicking {
	
	@Test
	public void performClickWithoutClick() {
		System.setProperty("webdriver.chrome.driver", "/Users/Love/Documents/Drivers/chromedriver");
		WebDriver driver = new SafariDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://login.yahoo.com/config/login?.src=fpctx&.intl=in&.lang=en-IN&.done=https%3A%2F%2Fin.yahoo.com");
		driver.findElement(By.id("login-username")).sendKeys("qatest");
		driver.findElement(By.id("login-username")).submit();
	}
}
