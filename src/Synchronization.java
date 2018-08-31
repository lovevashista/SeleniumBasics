import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

/*Synchronization refers to a process of synchronizing the selenium script with the actual website automated execution. For eg. on clicking "search" button, 
 * suppose we would like to click on the first searched element. In that case, if synchronization is not provided then, there are 99% chances that the script
 * will fail. So to handle such scenarios, synchronization is required.
 * In Selenium, synchronization can be achieved using the following:
 * 			- Implicit Wait
 * 			- Explicit Wait
 * 			- Thread.sleep
 * 			- Fluent Wait 
 * 
 * Implicit Wait: Refers to a wait, which, when provided, tells the script to wait for n number of seconds in its each step before you throw any exception.
 * If the result is obtained before the mentioned number of seconds, the script will not wait for n number of seconds. Rather, the script immediately 
 * executes.
 * Explicit Wait: Refers to a wait that is applied for a specific element on the page. In other words, this wait tells the script to wait for a specific 
 * element to get loaded on the page and once that element is loaded, continue with the execution. In case the specific element is not loaded on the page
 * for a time that is specified in the explicit wait call, then throw the exception.
 * 
 * The main difference between implicit and explicit wait is that, implicit wait applies for the entire script whereas explicit wait is applied only for 
 * a specific element on the page, ie. only for a single script step.*/
public class Synchronization {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/Love/Documents/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		/*IMPLICIT WAIT -- commenting out to demonstrate explicit wait, but it should be noted that implicit wait can be applied alongside explicit wait
		 * and explicit wait is always given priority over implicit wait if applied to a particular web element on the page.
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);*/
		
		driver.get("https://alaskatrips.poweredbygps.com/g/pt/hotels?MDPCID=ALASKA-US.TPS.BRAND.hotels.HOTEL");
		driver.findElement(By.id("H-destination")).sendKeys("nyc");
		driver.findElement(By.id("H-destination")).sendKeys(Keys.ENTER);
		
		/*EXPLICIT WAIT*/
		WebDriverWait d = new WebDriverWait(driver,20);
		d.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='988765']/div[2]/div/a")));
		
		/*SLEEP METHOD -- NOT RECOMMENDED HENCE COMMENTED OUT*/
		//Thread.sleep(20000L);
		
		driver.findElement(By.xpath("//*[@id='988765']/div[2]/div/a")).click();
		System.out.println("SES");
	}

}









