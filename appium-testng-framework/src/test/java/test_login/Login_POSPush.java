package test_login;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

import javax.xml.xpath.XPath;

import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import AppUtils.UtilityTestdata;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
public class Login_POSPush {
	
	AndroidDriver driver;
	
	@Test
	 public void Login() throws InterruptedException, IOException {
		  
		  AppiumDriverLocalService service = new AppiumServiceBuilder()
			        .usingPort(4723)
			        .withAppiumJS(new File("C:\\Users\\Admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
			        .withArgument(() -> "--relaxed-security")
			        .withArgument(() -> "--use-plugins", "images")
			        .withArgument(() -> "--allow-insecure", "uiautomator2:chromedriver_autodownload")
			        .build();

			service.start();
			
		  DesiredCapabilities cap = new DesiredCapabilities();

	        cap.setCapability("platformName", "Android");
	        cap.setCapability("appium:automationName", "UiAutomator2");
	        cap.setCapability("appium:deviceName", "Android Emulator");
	        cap.setCapability("appium:appPackage", "com.clientelingmobileapp");
	        cap.setCapability("appium:appActivity", ".MainActivity");
	        cap.setCapability("appium:chromedriverAutodownload", true);
	        
	        driver = new AndroidDriver( new URL("http://127.0.0.1:4723"),cap);
	        
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	        
	        
	        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Login']")).click();
	        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='LoginEmailInput']")).sendKeys("200034@malabargroup.com");
	        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Next']")).click();
	        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Enter password']"));
	        driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("Te$tsa#1239");
	        driver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@resource-id,'idSIButton')]")).click();
	        
	        for (String context : driver.getContextHandles()) {
	            System.out.println(context);
	        }
	        driver.context("WEBVIEW_com.clientelingmobileapp");
	        driver.findElement(By.xpath("//input[contains(@id,'idSIButton')]")).click();
	        driver.context("NATIVE_APP");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Generate Token']"))).click();
	        
	        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"English\"]")).click();
	        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"New Purchase\"]")).click();
	        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +".scrollIntoView(new UiSelector().text(\"Gold\"))")).click();
	        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Bangles\"]")).click();
	        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Next\"]")).click();
	        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"mobileVerificationInput\"]")).sendKeys("7907877590");
	        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"verifyMobileNumberNext\"]")).click();
	        
	        if(driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"leadCreationFirstName\"]")).getText().equals("Enter First Name"))
	        {
	        System.out.println("New Customer"); 	
	        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"leadCreationFirstName\"]")).sendKeys("James");
	        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"leadCreationLastName\"]")).sendKeys("TR");	       
	        }
	        
	        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"leadCreationContinue\"]")).click();
	        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"findAgentButton\"]")).click();
	        
	        //Need to Check   
	        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Assign to self\"]")).click();
	        
	        if (!driver.findElements(AppiumBy.xpath("//android.widget.Button[@resource-id='crossIcon']/android.view.ViewGroup")).isEmpty()) {

	            driver.findElement( AppiumBy.xpath("//android.widget.Button[@resource-id='crossIcon']/android.view.ViewGroup")).click();
	        }
	        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"onPressDoneButton\"]")).click();
	        
	        //Need to change the code section to work by getting the token number and adding the scroll
	        driver.setSetting("snapshotMaxDepth", 100);
	        driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text='Unni Mukund'])[1]")).click();
	        driver.setSetting("snapshotMaxDepth", 70);
	        
	        if (!driver.findElements(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"navigateCustomerInfo\"]/android.view.ViewGroup")).isEmpty()) {
	        	
	        	String imagePath = "src/test/resources/Images/scanner5.png";

	        	driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.4);

	        	byte[] imageBytes = Files.readAllBytes(Path.of(imagePath));
	        	String base64Image = Base64.getEncoder().encodeToString(imageBytes);

	        	WebElement scanButton =
	        	        driver.findElement(AppiumBy.image(base64Image));

	        	Rectangle rect = scanButton.getRect();

	        	System.out.println(rect);

	        	// Move tap toward the Scan text area
	        	int x = rect.getX() + (rect.getWidth() / 2);	        	
	        	int y = rect.getY() + rect.getHeight()+ (rect.getHeight() / 2);

	        	System.out.println("Tap X = " + x);
	        	System.out.println("Tap Y = " + y);

	        	((JavascriptExecutor) driver).executeScript(
	        	        "mobile: clickGesture",Map.of( "x", x,"y", y));
	        } 
	       
	        
	        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"barcodeNumber\"]")).sendKeys("100026498300");
	        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"validateBarcode\"]/android.view.ViewGroup")).click();
	        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Add to Bag\"]")).click();
	       
      Thread.sleep(5000);
	        wait.until(d -> {
	            try {
	                WebElement cartBtn = d.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"cartBtn\"]"));
	                return "false".equals(cartBtn.getAttribute("enabled"));
	            } catch (Exception e) {
	               System.out.println("Not found");
	               return false;
	            }
	        });
	        
	      
	        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
	         driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"bag\"]")).click();
	        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Generate Estimate\"]")).click();
	        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Create Customer\"]")).click();
	        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Push to POS\"]")).click();
	        
	        service.stop();        
	 }

}
