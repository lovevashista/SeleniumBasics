import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HandlingSSLCertificates {
	public static void main(String [] args) {
		//SSL Certification
		
		//What are capabilities? So DesiredCapabilities is a class which help you to customize your chrome browser.
		//You have to customize your chrome browser using DesiredCapabilities knowledge to your browser and then pass the object of the capabilities to 
		//to your ChromeOptions.
		
		//DesiredCapabilities are general that you want to apply on the chrome browser
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		//Creating a chrome browser profile to accept insecure  certificates
		dc.acceptInsecureCerts();
		
		//Now another way of accepting either the insecure or ssl certificates specifically
		//So in this case dont provide "ch.acceptInsecureCerts();"
		//Instead use the following:
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true); // for Insecure Certificates
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); // for SSL certificates
		
		//Creating a ChromeOptions object to access the inbuilt chrome options
		ChromeOptions co = new ChromeOptions();
		co.merge(dc); //merging the profile you have created to the chorme browser options.
		
		System.setProperty("webdriver.chrome.driver", "/Users/Love/Documents/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		//Now you can access an https site using a proxy in the company and simply surpass the SSL certificate and continue testing
		driver.get("Any Https website URL with proxy server");	
	}
}	
