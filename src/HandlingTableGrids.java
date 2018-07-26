import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingTableGrids {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/Love/Documents/Drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.cricbuzz.com/live-cricket-scorecard/20179/aus-vs-pak-final-australia-and-pakistan-in-zimbabwe-t20i-tri-series-2018");
		
		//Give parent of the table
		WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		// we are not using driver.findElements, since we want our scope to be limited to the table element
		
		//i. Grab the count of rows in the table
		int rowcount = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']")).size();  //13
		
		//ii. Grab the third child of the row (ie 3rd Column) in the CSS. OR //ii. Grab the total number of cells in the 3rd column from the table
		int count = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size(); //Column containing the runs
		//div:nth-child(3) is used to go to the 3rd in the row
		
		int sum = 0;
		for(int i=0; i<count-2; i++) { //"count-2": getting rid of last two rows values, since we need only players' runs
			String str = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
			
			int str_int_value = Integer.parseInt(str); // To convert the string runs value into integer so that it cna be used to add to sum
			
			//sum all the values up
			sum = sum + str_int_value;
		}
		
		//Grab the last two values having different styling from the above ten rows
		//i. Grab the xpath of "Extras" and ii. Go to its sibling to get the value of the second column
		String str_extras_val = table.findElement(By.xpath("//div[text() = 'Extras']/following-sibling::div")).getText();
		
		int str_extras_int_value = Integer.parseInt(str_extras_val);
		
		//sum up the extras values too
		sum = sum + str_extras_int_value;
		
		//i. Grab the xpath of "Total" and ii. Go to its sibling to get the value of the second column
		String str_total_val = table.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
		
		int str_total_int_value = Integer.parseInt(str_total_val);
		
		//check whether sum of all the values is equal to the total value or not
		if(str_total_int_value == sum) {
			System.out.println("Equal");
		}else {
			System.out.println("Not Equal");
		}
	}
}
