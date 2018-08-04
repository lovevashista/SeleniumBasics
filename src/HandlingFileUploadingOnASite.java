import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class HandlingFileUploadingOnASite {
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver = new SafariDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://pdftoimage.com/");
		
		//driver.findElement(By.xpath("//div[@id='pick-files']/span[2]"));
		driver.findElement(By.xpath("//span[text()='Upload Files']")).click();;
		Thread.sleep(2000L);
		
		
		
		Robot r = new Robot();
		
		//Specific for hardcoded path
//		r.keyPress(KeyEvent.VK_META);
//		r.keyPress(KeyEvent.VK_TAB);
//		r.keyRelease(KeyEvent.VK_META);
//		r.keyRelease(KeyEvent.VK_TAB);
//		r.delay(2000);
//		r.keyPress(KeyEvent.VK_DOWN);
//		r.keyRelease(KeyEvent.VK_DOWN);
//		r.keyPress(KeyEvent.VK_DOWN);
//		r.keyRelease(KeyEvent.VK_DOWN);
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.keyRelease(KeyEvent.VK_ENTER);
		
		File src = new File("/Users/Love/Desktop/LoveVashista_Resume_2018Format_NoAppium.pdf"); //Get  path obt
		StringSelection ss = new StringSelection(src.getAbsolutePath()); //Get path for copying into clipboard
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null); //Copy Path to clipboard.
		
		//Generic
		r.keyPress(KeyEvent.VK_META);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_META);
		r.keyRelease(KeyEvent.VK_TAB);
		r.delay(2000);
		
		r.keyPress(KeyEvent.VK_META);
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_G);
		r.keyRelease(KeyEvent.VK_META);
		r.keyRelease(KeyEvent.VK_SHIFT);
		r.keyRelease(KeyEvent.VK_G);
		
		r.keyPress(KeyEvent.VK_META);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_META);
		r.keyRelease(KeyEvent.VK_V);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.delay(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}
