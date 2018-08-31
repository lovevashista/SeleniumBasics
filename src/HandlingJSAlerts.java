import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

/*Web alerts refer to those alert boxes in Java which are handled as a part of java code. The main difference between the java alerts and normal alerts
 * is that the when we try to inspect any element on the java alert, the html code will not be displayed in console. However, if the alert is not rlated
 * to java code then on inspecting element on the alert box, we will be able to see the html code.*/
public class HandlingJSAlerts {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.gecko.driver", "/Users/Love/Documents/Drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");
		driver.findElement(By.xpath("//input[@value = 'Confirmation Alert']")).click();
		Thread.sleep(1000L);
		System.out.println(driver.switchTo().alert().getText());
//		driver.switchTo().alert().sendKeys("This method is used to enter text in the alert box");
//		driver.switchTo().alert().dismiss(); //This method is used to click on the "cancel" button
		driver.switchTo().alert().accept(); //This method is used to click the "OK" button on the alert box
		System.out.println("SES");
		
		/*
		 * Now let's say we have to handle geo location java script alert as soon as we land on the site.
		 * To do this in chrome:
		 */
		ChromeOptions co = new ChromeOptions();
		co.addArguments("disable-geolocation");
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setCapability(ChromeOptions.CAPABILITY, co);
		dc.merge(co);
		
		/*
		 * In Firefox:
		 */
		FirefoxProfile fp = new FirefoxProfile();
		fp.setPreference("geo.enabled", false);
		dc = DesiredCapabilities.firefox();
		dc.setCapability(FirefoxDriver.PROFILE, fp);
		driver = new FirefoxDriver();
		
		/*
		 * Rest refer https://stackoverflow.com/questions/38767551/how-can-i-handle-geo-location-popup-in-browser-using-selenium-webdriver
		 * for complete explanation
		 */
	}
}
