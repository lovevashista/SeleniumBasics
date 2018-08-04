import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;

public class HandlingScreenshotsAndKillingProcesses {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/Love/Documents/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		/*TAKING SCREENSHOT*/
		
		//In ordet to take screenshot, you have to convert your webdriver object into screenshot object
		//driver object knows how to automate your browser, but now you want to change this object behavior to capture screenshot
		
		//so to change that behavior 
		//i. cast driver to "TakeScreenshot" class
		//ii. call "getScreenshotAs" method of "TakesScreenshot" class to take the screen shot
		//iii. Pass a file as a parameter using "OutputType.FILE" to get the output as a file format so that we can view the screenshot
		//iv. Store the screenshot in the "src" object
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//NOw our object "src" has to bring the screenshot to the desktop
		//For that, we will invoke "FileUtils" method to invoke the file from the "src" object to our local machine
		FileUtils.copyFile(src, new File("/Users/Love/Desktop/screenshot.png"));
		
		//In general, we take the screenshots when the scripts are failed. How to do that? We will see when we see end to end creation of a framework.
		
		
		
		
		/*KILLING PROCESS USING SELENIUM*/
		
		//Any window process can be killed from the selenium web driver code (eg. closing an excel or a notepad window after taking data from it)
		// So to kill any process
		WindowsUtils.killByName("excel.app"); //excel.exe for windows
	}
}
