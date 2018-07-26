import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class HandlingCalanderUI {
	public static void main(String[] args){
		System.setProperty("webdriver.gecko.driver", "/Users/Love/Documents/Drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.path2usa.com/travel-companions/");
		driver.findElement(By.xpath("//input[@id='travel_date']")).click();
		
		/*Click on Date June 24, 2019*/
		//Month traversal from current month
		while(!driver.findElement(By.cssSelector("div.datepicker-days th.datepicker-switch")).getText().contains("June")){
			driver.findElement(By.cssSelector("div.datepicker-days th.next")).click();
		}
		
		
		//Day traversal from the current day
		//Grab the common attribute //Put it to list and iterate 
		int count = driver.findElements(By.className("day")).size();
		for(int i=0; i<count; i++){
			String text = driver.findElements(By.className("day")).get(i).getText();
			if(text.equals("24")){
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}
		
		System.out.println("Success");
	}
}
