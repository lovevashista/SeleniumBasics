import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class PracticeExercise {
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver", "/Users/Love/Documents/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/practice.php");
		
		/*
		 * Find the total number of links present on the page
		 */
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		
		/*
		 * Find the total number of links present on the footer only
		 */
		//Limit the scope of the driver to footer only
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		//Find the total number of links present on the footer now
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		
		/*
		 * Find the links count of the only the first section of the footer only
		 */
		//Limit the scope of the footerdriver to footer first section only
		WebElement sec1driver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(sec1driver.findElements(By.tagName("a")).size());
		
		
		/*
		 * Click on each link in the column and display the title of each opened page
		 */
		int count = sec1driver.findElements(By.tagName("a")).size();
		for(int i=1; i<count; i++){	 			//since the first link is not working on the site
			//Automate Pressing Command and Enter key on each link
			String clickToLinkTab = Keys.chord(Keys.COMMAND,Keys.RETURN);
			sec1driver.findElements(By.tagName("a")).get(i).sendKeys(clickToLinkTab);
		}
		//Switch to each of the opened tab and fetch the web titles
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it= ids.iterator();
		while(it.hasNext()){
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
		//For detailed explanation, refer section 11, lecture 75
	}
}
