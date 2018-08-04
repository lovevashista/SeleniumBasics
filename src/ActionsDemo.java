import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class ActionsDemo {
	public static void main(String[] args){
		System.setProperty("webdriver.gecko.driver", "/Users/Love/Documents/Drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.amazon.com");
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();
		a.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).contextClick().build().perform();
		//Another way of typing text in a TF in caps:
		//driver.findElement(By.xpath("")).sendKeys(Keys.SHIFT,"text");
		System.out.println("Success");	
	}
}
