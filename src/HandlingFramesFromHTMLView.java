import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFramesFromHTMLView {
	public static void main(String[] args) {
		
		System.getProperty("webdriver.chrome.driver", "/Users/Love/Documents/Drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://fantasycricket.dream11.com/IN/");
		
		//Click on "I'm not a robot" checkbox. And we know that this checkbox in the frame.
		
		int frameNo = findFrameNumber(driver,By.xpath(".//*[@id='recaptcha-anchor']/div[5]"));
		driver.switchTo().frame(frameNo);
		driver.findElement(By.xpath(".//*[@id='recaptcha-anchor']/div[5]")).click();
		
		//Now let's find another object to be clicked on another frame on the website using the same utility we have created.
		int framNo2 = findFrameNumber(driver, By.xpath(".//*[@id = 'recaptcha-anchor-next']/div[4"));
		driver.switchTo().frame(framNo2);
		driver.findElement(By.xpath(".//*[@id = 'recaptcha-anchor-next']/div[4")).click();
	}
	
	
	
	
	
	
	
	
	//Let's write a reusable code or we call it as a "Utility" (a function that can be used multiple times when
	//required.)
	public static int findFrameNumber(WebDriver driver, By by) { 	//"By by" parameter means that i will provide one object in the main program. Now
															//go and find where the object provided is present in
															//in which frame.
		int i;
		
		//But to know how many frames are present in the webpage, we will count how many "iframe" or "frameset"
		// (here, only iframe is used on the webpage) tags
		//are present in the html code, to do this
		
		int framecount = driver.findElements(By.tagName("iframe")).size();
		for(i = 0; i<framecount; i++) {
			driver.switchTo().frame(i);
			
			/*VERY IMPORTANT INTERVIEW SCENARIO*/
			
			
			//now after switching to the frame, we need to verify whether the desired element is present in the
			//current frame or not. (AND NOT VERIFY THAT OBJECT IS IN VISIBLE MODE OR NOT), presence and 
			//visibility are two different things. For that,
			int count = driver.findElements(by).size();
			
			
			//The above statement will return 0 if the object is not present, otherwise, it will return 1 if the object is
			//present on the corresponding frame. Now, 
			
			if(count > 0) { //i.e if the object is present on the frame 
				break; 	//because if we found our element in the let's say 2nd frame out of 5 frames, then why waste
						//time again looping for all the other frames.
			}else { //i.e if the object is not present on the frame
				System.out.println("Continue Looping");
			}
		}
		
		//Now after clicking on the desired frame, in order to go into another frame (not the child frame ie a frame
		//within another frame), which is different all together, we first have to come out of the frame where we 
		//clicked the desired object to the default state. For that,
		driver.switchTo().defaultContent();
		//The above step is MANDATORY. Otherwise you won't be able to switch the frames on the page.
		
		//And suppose, we want to get inside a child frame unlike above scenario. In that case, the above statement should not be used. Because we 
		//don't want to come out to the default state on the webpage, since we are going inside another frame and not a different frame altogether.
		//But this case is very rare.
		//Multiple frames in a website on the single page is normal.
		
		//Now i want to get the frame, the above frame that I identified. So to do that, we have to return the 
		//frame from the utility to the main program, To do that,
		return i; //will return the above identified frame.

	}
}
