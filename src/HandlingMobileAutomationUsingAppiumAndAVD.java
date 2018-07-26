import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

//To make sure that the java can understand appium methods, the appium java class library must be imported to the project.
//Hence imported "java-client-6.1.0.jar" along with all the selenium jars.
public class HandlingMobileAutomationUsingAppiumAndAVD {
	public static void main(String[] args) throws MalformedURLException {
		
		//1. You need to talk to your appium server, then appium server invokes your virtual devices (or real devices) which are connected
		//For that you need to pass your client code to the server code
		//So first start the appium server
		//Now you need to send the information to the server and Appium server interprets the information 
		//My desired capabilities are:
		//i. I want to open an emulator LoveEmulatore
		//ii. I want to test one app (let's say XYZ app) to test. So initially that app might not be in your emulator. So first i want to let 
		//install this app on the emulator so that i can test it.
		//Next, how would you connect yourself to the appium server so
		//iii. One connection step to connect your self to the server
		//So after performing all the above steps, first it will connnect you to the server, opens the emulator and install the app on the 
		//emulator
		//The above template is common for each test case
		
		File f = new File("src"); //Go to src folder in the project first, because we will be storing the .apk file in the eclipse project folder itself
		File fs = new File(f, "<apk file name here>");
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "LoveEmulatore");
		dc.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath()); //to be continued in the next lecture. Here we have to give the apk file path in the inverted commas
		//But to do this, ethically we should be storing the entire file name in the File object as done in the line above DesriredCapabilities
		//statement. After using fs object in the above statement, we can avoid hardcoding .apk file path in the programming, thus making the code
		//generic.
		
		//The last step that is left is connection to the server.
		//To send a connection to server you need to create and invoke the AndroidDriver class
		//in "AndroidDriver" class, you have to send the following two parameters:
		//i. Connection to the server link
		//ii. The capabilities to the server stored in "dc" object
		AndroidDriver<AndroidElement> ad = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
		//In every machine, the URL "127.0.0.1" is always belongs to the "localhost"
		
		//But guess what, we can't run this script to install the apk into the emulator
		
		//Before running the above script make sure that the appium server is started and the emulator is opened.
		
		//1. We got SDK
		//2. We got emulator using AVD manager
		//3. We got nodejs and npm manager
		//4. We got appium server using npm manager
		//5. We got eclipse
		//6. We got appium client jar file from website
		//7. We written the code
		//8. We successfully executed the first automation test script using emulator (mobile automation)
		
		/*ANDROID UI AUTOMATOR*/
		//First we need to know the object path of the element (in mobile device, like web) that we want to work upon on the code.
		//So android guys came up with a tool called as UI Automator tool and from that you can acutually get the object paths of all the 
		//objects on the app
		//SO where exactly the tool lies?
		//i. Go to SDK path
		//ii. Go to tools/bin/UIAutomatorViewer.exe
		//iii. Click on it
		
	}
}
