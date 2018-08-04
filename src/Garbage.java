import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.Color;

public class Garbage {
	public static void main(String [] args) {
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		ChromeOptions co = new ChromeOptions();
		co.merge(dc);
		
		WebDriver driver = new ChromeDriver();
		driver.findElement(By.id("")).sendKeys(Keys.SHIFT,"Hello");
	}
}
