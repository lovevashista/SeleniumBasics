import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//selenium code
		
		//Create Driver Object for chrome browser
		//We will strictly implement methods for WebDriver
		//Invoke .exe file first by setting the value of web
		System.setProperty("webdriver.gecko.driver", "/Users/Love/Documents/Drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
	}

}
