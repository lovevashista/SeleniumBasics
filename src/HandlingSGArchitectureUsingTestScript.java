import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/*Before writing this test script, please node that your node and hub should be completely configured with java and the SG architecture
 * should be set up first. That's very important, otherwise your test script will not run. Refer lectures 103 to 105 for setting up the 
 * SG architecture on HUB and NODE*/

/*Under the "Referenced Libraries" make sure the "selenium-standalone-server.jar" should be imported so that the SG code can be understood
 * by java*/


/*REMOTE TEST*/

public class HandlingSGArchitectureUsingTestScript {
	public static void main(String [] args) throws MalformedURLException {
		//When you run your test on the NODE, ie, different machine, you have to let java know on which browser and which machine you would 
		//be executing the script. For that, we will make your of "DesiredCapabilities" object as shown below:
		DesiredCapabilities dc = new DesiredCapabilities();
		//If you want to run this test script in Chrome
		dc.setBrowserName("chrome"); //make sure you give every thing in small letters since SG understands only the browser name in small cases
		//If you want to run this test script in Windows OS
		dc.setPlatform(Platform.WINDOWS);
		
		//If you run the test locally, we will give the command like this;
		//WebDriver driver = new ChromeDriver("webdriver.chrome.driver", "<Chrome Driver File Path>");
		
		//But if you want to run your test remotely on another machine using Chrome browser, then;
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc); 
		//In the above statement, the "RemoteWebDriver" takes following 2 arguments
		//i. You have to specify the HUB server IP address where the SG is sitting. At the last you have to append "/wd/hub"
		//ii. What properties of your test (properties means I want to run it on chrome and on windows platform as set above using DesiredCapabilities object
		
		driver.get("http://www.google.com");
	}
}
