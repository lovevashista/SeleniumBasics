import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;


public class HandlingRadioButtons {
	public static void main(String[] args){
		WebDriver driver = new SafariDriver();
		driver.get("http://www.echoecho.com/htmlforms10.htm");
		driver.findElement(By.xpath("//input[@value='Milk']")).click();
		System.out.println(driver.findElements(By.xpath("//input[@name='group1']")).size());
		
		
		//Now lets suppose that 'value' attribute is not present in the radio button items (that distinctly identifies each radio button item).
		//In that case, we should be handling the radio button dynamically as shown in the following code:
		int count = driver.findElements(By.xpath("//input[@name='group1']")).size();
		for(int i = 0; i<count; i++) {
			String text = driver.findElements(By.xpath("//input[@name='group1']")).get(i).getText();
			if(text.equals("Cheese")) {
				driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();
			}
		}
		System.out.println("System Executed Successfully");
	}
}
