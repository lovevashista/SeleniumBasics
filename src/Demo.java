import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//selenium code
		
		//Create Driver Object for chrome browser
		//We will strictly implement methods for WebDriver
		//Invoke .exe file first by setting the value of web
		System.setProperty("webdriver.chrome.driver", "/Users/Love/Documents/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver(); //open Chrome Browser
		driver.get("http://www.google.com"); //Open URL on the browser
		System.out.println(driver.getTitle()); //Get the title of the browser
		System.out.println(driver.getCurrentUrl()); //Get the URL present on the address bar of the browser. Validation purpose.
		//System.out.println(driver.getPageSource()); //Get the page source of the web page.
		driver.get("http://www.yahoo.com"); //Now open Yahoo site on the same browser
		driver.navigate().back(); //Navigate back to google site
		driver.navigate().forward(); //Navigate forward to yahoo site
		driver.close();//Close the current browser. 
		//driver.quit();//Close all the browser opened by Selenium Script.
	}

}
