import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class HandlingFrames {
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver", "/Users/Love/Documents/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/droppable/");
		/*Switching to frame using WebElement*/
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class = 'demo-frame']")));
		
		/*Switching back to the main web page*/
		driver.switchTo().defaultContent();
		
		/*Switching back to frame using Index*/
		//Finding the total number of frames on the web page
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		//Based on the size, finding the index
		driver.switchTo().frame(0);
		
		//Performing drag and drop action on the elements present on the frame
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.cssSelector("div#draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();
		System.out.println("Success");
		
		//driver.switchTo.frame(index / webelement)
		//to get the total number of frames in dom - driver.findelements(By.tagName("iframe OR frameset"))
		
	}
}
