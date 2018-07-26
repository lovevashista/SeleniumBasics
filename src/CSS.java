import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class CSS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "/Users/Love/Documents/Drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys("Hello");
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys("Pass1234");
		driver.findElement(By.cssSelector("input[id*='Log']")).click();
		//SYNTAX for CSS: tagname[attribute='value']
	}

}
