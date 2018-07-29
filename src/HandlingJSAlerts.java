import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*Web alerts refer to those alert boxes in Java which are handled as a part of java code. The main difference between the java alerts and normal alerts
 * is that the when we try to inspect any element on the java alert, the html code will not be displayed in console. However, if the alert is not rlated
 * to java code then on inspecting element on the alert box, we will be able to see the html code.*/
public class HandlingWebAlerts {
	public static void main(String[] args){
		System.setProperty("webdriver.gecko.driver", "/Users/Love/Documents/Drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");
		driver.findElement(By.xpath("//input[@value = 'Confirmation Alert']")).click();
		System.out.println(driver.switchTo().alert().getText());
//		driver.switchTo().alert().sendKeys("This method is used to enter text in the alert box");
//		driver.switchTo().alert().dismiss(); //This method is used to click on the "cancel" button
		driver.switchTo().alert().accept(); //This method is used to click the "OK" button on the alert box
		System.out.println("SES");
	}
}
