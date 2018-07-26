import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;


public class Dummy {
	public static void main(String[] args){
		WebDriver driver = new SafariDriver();
		driver.get("http://www.echoecho.com/htmlforms10.htm");
		int count = driver.findElements(By.xpath("//input[@name='group1']")).size();
		for(int i=0; i<count; i++){
			String text = driver.findElements(By.xpath("//input[@name='group1']")).get(i).getAttribute("value");
			if(text.equals("Cheese")){
				driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();
			}
		}
		System.out.println("S E S.");
	}
}
