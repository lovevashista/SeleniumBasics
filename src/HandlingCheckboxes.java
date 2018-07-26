import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class HandlingCheckboxes {
	public static void main(String[] args){
		System.setProperty("webdriver.gecko.driver", "/Users/Love/Documents/Drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.spicejet.com");
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		System.out.println("Script Execued Successfully");
	}
}
