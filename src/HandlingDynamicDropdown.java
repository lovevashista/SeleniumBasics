import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HandlingDynamicDropdown {
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver", "/Users/Love/Documents/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.spicejet.com");
		driver.findElement(By.xpath("//input[contains(@id,'ctl00_mainContent_ddl_originStation1_CTXT')]")).click();
		driver.findElement(By.cssSelector("a[value*='OI']")).click();
		//driver.findElement(By.xpath("(//a[contains(@value,'DEL')])[2]")).click();
		//The above statement works fine with css also as shown below
		driver.findElement(By.cssSelector("(a[text*='Delhi'])[2]")).click();
		System.out.println("Script Executed Successfully");
	}
}


// Dynamic Dropdowns refer to those dropdowns that cannot be handled via "select" class in selenium. To handle the dynamic dropdowns, similar to other 
// web elements, locators (id, linktext, name, classname, xpath and css) should be used.
// Sometimes, in very rare cases, only one web element is used at multiple places in the code. In such cases, the problem can be solved using xpath
// locator only.
// For eg: In a flight reservation website, the same dropdown is used for selecting both the source and destination. To handle such cases, for the second
// instance of the same element occured in destination, the xpath should be wrapped in brackets () and an index should be appended after the brackets like
// [2]. This denotes that the selenium script will understand that the destination should be selected from the second instance of the same dropdown rather
// than the first instance. 
// NOTE that this instance happens in very rare cases and this one of those few instances in selenium which comes under tricky part.