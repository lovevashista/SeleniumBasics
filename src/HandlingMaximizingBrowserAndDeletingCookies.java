import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingMaximizingBrowserAndDeletingCookies {
	public static void main(String [] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/Love/Documents/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		//Maximize browser window
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com");
		
		//Suppose you want to delete all the cookies before starting off the execution, most of the time, selenium executes in a fresh start, but still..
		//There can be some scenarios where you have to come across where you have to delete cookies before executing the test script in the browser
		//so for this, do the following:
		driver.manage().deleteAllCookies();
		
		//if you don't want to delete all the cookies and if you want to delete only one cookie and start validating some scenarios and you know what is that
		//cookie name to be deleted
		driver.manage().deleteCookieNamed("asdf");
		
		//If you want to add the cookie then
		//driver.manage().addCookie(arg0);
		
		//For instance, if you delete session id  cookie, your session get logged out (could be a valid automation scenario)
		driver.manage().deleteCookieNamed("SessionKey");
		//then click on any link and you would be redirected to the login page (validate the login url)
	}
}
