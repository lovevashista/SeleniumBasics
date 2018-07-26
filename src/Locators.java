import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Locators {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/Love/Documents/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver(); //open chrome browser
		driver.get("http://www.facebook.com"); //open facebook site on the browser
//		driver.findElement(By.id("email")).sendKeys("Enter email id"); //find "Email" box and put cursor on it to enter the email id
//		driver.findElement(By.name("pass")).sendKeys("Password"); //find "Password" box by name attribute in the html code and enter "password" stirng in it
//		driver.findElement(By.linkText("Forgotten account?")).click(); //find "Forgotten account?" link on the page and click on the corresponding link based on the link text itself, ie, "Forgotten account?"
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("Enter email..");
		driver.findElement(By.cssSelector("#pass")).sendKeys("Pass1234");
		driver.findElement(By.xpath("//*[@id='u_0_8']")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id='globalContainer']/div[3]/div/div/div")).getText());
	
	}

}
