import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*To traverse from one sibling to another sibling, use xpath: //1st-sibling-xpath/following-sibling::tagName[1] for next, ..::tagName[2] f
 * or next to next and so on..
 *To traverse back from child div to parent div, use xpath: //child-div-xpath/parent::parent-tagName
 */
/**
 * SCENARIO
 * In HTML:
 * <div class=<dynamic>>
 * <ul class = <dynamic>>
 * 	<li id='lii'>List1</li>
 * 	<li>List2</li>
 * 	<li>List3</li>
 * </ul>
 * </div>
 * <div class=<dynamic>>
 * <ul class = <dynamic>>
 * 	<li id='liii'>List1</li>
 * 	<li>List2</li>
 * 	<li>List3</li>
 * </ul>
 * </div>
 * 
 * TEST CASE
 * 1. Locate List1, List2 and List3 element from the fist div in our test script
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
		
		/*SYNTAX*/
		driver.findElement(By.xpath("//div[@class='ParentClass']"));
		driver.findElement(By.xpath("//div[@class='ParentClass']/ul/li[@class='ChildClass']")); //first sibling
		driver.findElement(By.xpath("//div[@class='ParentClass']/ul/li[@class='ChildClass']/following-sibling::li[1]")); //second sibling
		driver.findElement(By.xpath("//div[@class='ParentClass']/ul/li[@class='ChildClass']/following-sibling::li[2]")); //third sibling
		driver.findElement(By.xpath("//div[@class='ParentClass']/ul/li[@class='ChildClass']/parent::ul")); //back to the parent class
	}
	
	
}