import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class JSE_HandlingElementHighlight {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/Love/Documents/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS); //wait max of 50 seconds for the page load, otherwise terminate the script.
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //implicit wait
		
		driver.get("https://www.freecrm.com");
		driver.findElement(By.name("username")).sendKeys("user");
		driver.findElement(By.name("password")).sendKeys("Pass123");
		
		WebElement loginBtn = driver.findElement(By.xpath("//input[contains(@type,'submit')]"));
		Thread.sleep(1000); //Exceptional case, when we have a splash page and our processor is very fast, so sometimes the element, even after being located is not clickable, as we have a splash page in front of the
		flash(loginBtn, driver);
		loginBtn.click();

	}
	
	//IN our case we simply want to highlight the Login button and not clicking it for this we use JSE.
	public static void flash(WebElement element, WebDriver driver) {
		String bgColor = element.getCssValue("backgroundColor"); // To get the back ground color of that particular element.
		//creating a for loop for executing the block 10 times because 10 times i want to highlight that element
		for(int i =0; i<30; i++) {
			//call a method changeColor defined below
			changeColor("rgb(0,200,0)", element, driver);
			changeColor(bgColor, element, driver);
		}
	}
	
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver); //Typecase driver to JavascriptExecutor and point a reference "js" to the javascriptexecutor object (typecasted driver)
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element); //here "arguments[0].style.backgroundColor = '"+color+"'", element" is the javascript instruction we are executing.
		
		try {
			Thread.sleep(20);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
