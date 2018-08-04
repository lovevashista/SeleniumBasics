import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*To traverse from one sibling to another sibling, use xpath: //1st-sibling-xpath/following-sibling::tagName[1] for next, ..::tagName[2] f
 * or next to next and so on..
 *To traverse back from child div to parent div, use xpath: //child-div-xpath/parent::parent-tagName
 */
public class Xpath_Text_ParentChildTraversing{
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver", "/Users/Love/Documents/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/");
		driver.findElement(By.xpath("//div[@class='container']/nav/ul/li[4]")).click();
		driver.findElement(By.xpath("//div[@class='interview-question']/div/div/ul/li[@id = 'tablist1-tab1']")).click();
		System.out.println("Appium clicked successfully");
		driver.findElement(By.xpath("//div[@class='interview-question']/div/div/ul/li[@id = 'tablist1-tab1']/following-sibling::li[1]")).click();
		System.out.println("Selenium clicked successfully");
		driver.findElement(By.xpath("//div[@class='interview-question']/div/div/ul/li[@id = 'tablist1-tab1']/following-sibling::li[2]")).click();
		System.out.println("SoapUI clicked successfully");
		driver.findElement(By.xpath("//div[@class='interview-question']/div/div/ul/li[@id = 'tablist1-tab1']/following-sibling::li[3]")).click();
		System.out.println("Testing clicked successfully");
		System.out.print("Parent's text is: ");
		System.out.println(driver.findElement(By.xpath("//div[@class='interview-question']/div/div/ul/li[@id = 'tablist1-tab1']/parent::ul")).getText());
		System.out.println("Script executed successfully");
		
//		driver.findElement(By.xpath("dynamic parent xpath")).click(); //parent dynamic child click
//		driver.findElement(By.xpath("dynamicParent/dynamicChild")).click(); //1st dynamic child click
//		driver.findElement(By.xpath("dynamicParent/dynamicChild/following-sibling::childtagName[1]")).click(); //2nd dynamic child click
//		driver.findElement(By.xpath("dynamicParent/dynamicChild/following-sibling::childtagName[2]")).click(); //3rd dynamic child click
	}
}