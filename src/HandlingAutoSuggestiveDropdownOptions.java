import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingAutoSuggestiveDropdownOptions {
	public static void main(String [] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/Love/Documents/Drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("http://ksrtc.in/oprs-web/");
		
		//First find the text field where "ben" is to by typed by the script
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("BEN");
		
		//Now after present in the field with the text "ben", an auto suggestive dropdown opens. 
		//Now we will traverse the entire list using keyboard event "keys.down" till the time we find "bengaluru internation airport" in the list.
		//Once the expected text is found, our test case is passed.
//		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
//		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
		
		//System.out.println(driver.findElement(By.xpath("//input[@id='fromPlaceName']")).getText());
		
		//the problem is using getText method, we won’t be able to print the same. The reason is that the text that is present in the text field 
		//after selecting from the dropdown is in “hidden” mode and that is why getText method failed to fetch the text and display on the screen
		//So this is a disadvantage with selenium, it cannot identify the hidden text.
		//And to overcome this disadvantage, the JAVASCRIPT EXECUTOR is to be used
		//The javascript can extract the hidden elements as well. There is a concept called as “javascript HTML dom API”. -- (Hidden - Ajax Implementation)
		//Using this API you will be able to access the hidden html elements as well.
		
		/*Javascript Executor*/
		
		//First initialize the javascript executor to execute or access all javascript functions provided by Selenium
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Using js object, it can identify and execute the Javascript DOM related items.
		//Now in javascript, the js DOM is understood by all the browsers, so in order to get any element using the js DOM following command is used
		// document.getElementById("fromPlaceName") -- very much similar to Selenium commands, that is why javascript is easily understood by the 
		//Selenium guys.
		//And in order to get the value of the above element, following command is to be used:
		//document.getElementById("fromPlaceName").value;
		//The above statement (a script command in javascript) can be used to fetch the value of the element if the "getText" method of Selenium is not 
		//able to sort the problem.
		//It can be done as shown below:
		String script = "return document.getElementById(\"fromPlaceName\").value;"; 
		// i. forward slases are used to prevent the string value from being corrupted.
		// ii. "return" keyword is to be added by ourselves, otherwise nothing will be returned.
		// iii. after "value" a ";" must be present explicity.
		String value = (String)js.executeScript(script);
		//System.out.println(value);
		
		
		int i=0;
		//Now we traverse through the list to find "BENGALURU INTERNATION AIPORT" and once found, grab that option and send it to the text field.
		while(!value.equalsIgnoreCase("BENGALURU INTERNATION AIPORT")) {
			driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
			i++;
			Thread.sleep(1000);
			value = (String)js.executeScript(script);
			System.out.println(value);
			if(i>10) {
				System.out.println("Element not found");
			}else {
				System.out.println("Element found");
			}
		}
	}
}
