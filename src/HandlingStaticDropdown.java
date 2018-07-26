import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class HandlingStaticDropdown {
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver", "/Users/Love/Documents/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.silvertouch.com/MagentoExtensions/mega-menu-with-drop-down-and-static-block.html");
		Select s = new Select(driver.findElement(By.xpath("//select[@name='version_name']")));
		s.selectByIndex(3);
		s.selectByValue("656");
		s.selectByVisibleText("1.5.X");
		System.out.println("Script Executed Successfully");
	}
}
