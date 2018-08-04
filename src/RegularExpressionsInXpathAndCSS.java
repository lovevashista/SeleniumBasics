import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class RegularExpressionsInXpathAndCSS {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/Love/Documents/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.rediff.com");
		driver.findElement(By.cssSelector("a[title*='Sign in']")).click();
		driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("Hello");
		driver.findElement(By.xpath("//input[contains(@id,'pas')]")).sendKeys("Pass123");
	}

}
