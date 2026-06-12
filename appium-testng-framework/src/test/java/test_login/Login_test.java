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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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

public class Login_test {
	
	 AndroidDriver driver;
	 
//	public void loginTest() throws Exception {
//
//
//	     UiAutomator2Options options = new UiAutomator2Options();
//
//	        options.setPlatformName("Android");
//	        options.setDeviceName("Android");
//	        options.setAutomationName("UiAutomator2");
//	        options.setAppPackage("com.clientelingmobileapp");
//	        options.setAppActivity("com.clientelingmobileapp.MainActivity");
//	       // options.setNoReset(true);
//	        options.setAppWaitDuration(Duration.ofSeconds(60));
//	        options.setAppWaitActivity("*");
//
//	        AndroidDriver driver = new AndroidDriver(
//	                new URL("http://127.0.0.1:4723"),
//	                options
//	        );
//
//	        // Click Login button
//	        Thread.sleep(40000);
//	        driver.findElement(
//	            AppiumBy.xpath("//android.widget.TextView[@text='Login']")
//	        ).click();
//
//
//    }
	
	//  @Test
	    public void loginTest() throws InterruptedException, MalformedURLException {
		  
		  AppiumDriverLocalService service = new AppiumServiceBuilder()
			        .usingPort(4723)
			        .withAppiumJS(new File("C:\\Users\\Admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
			        .withArgument(() -> "--relaxed-security")
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
	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
	        
	        By Login = AppiumBy.xpath("//android.widget.TextView[@text='Login']");
	        wait.until(ExpectedConditions.visibilityOfElementLocated(Login)).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='LoginEmailInput']"))).sendKeys("200034@malabargroup.com");
	        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text='Next']"))).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Enter password']")));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.EditText"))).sendKeys("Te$tsa#1239");
	        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[contains(@resource-id,'idSIButton')]"))).click();
	        for (String context : driver.getContextHandles()) {
	            System.out.println(context);
	        }
	        driver.context("WEBVIEW_com.clientelingmobileapp");
	        driver.findElement(By.xpath("//input[contains(@id,'idSIButton')]")).click();
	
	}
	
	  @Test
     public void loginTest_Im() throws InterruptedException, IOException {
		  
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
	      //  driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"SelectAgentHandler\"])[1]")).click();
	        
	        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Assign to self\"]")).click();
	        
	        if (!driver.findElements(AppiumBy.xpath("//android.widget.Button[@resource-id='crossIcon']/android.view.ViewGroup")).isEmpty()) {

	            driver.findElement( AppiumBy.xpath("//android.widget.Button[@resource-id='crossIcon']/android.view.ViewGroup")).click();
	        }
	        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"onPressDoneButton\"]")).click();
	        
	        //Need to change the code section to work by getting the token number and adding the scroll
	        driver.setSetting("snapshotMaxDepth", 100);
	        driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text='Unni Mukund'])[1]")).click();
	        driver.setSetting("snapshotMaxDepth", 70);
	        
	        if (!driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text=\"Add\"]")).isEmpty()) {
	        	
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
	        	        "mobile: clickGesture",
	        	        Map.of( "x", x,"y", y));
	        } 
	       
	        
	        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"barcodeNumber\"]")).sendKeys("570000641962");
	        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"validateBarcode\"]/android.view.ViewGroup")).click();
	        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Add to Bag\"]")).click();	       	        
	       // driver.pressKey(new KeyEvent(AndroidKey.BACK));
            driver.navigate().back();
	        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"bag\"]/android.view.ViewGroup")).click();	
	        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Generate Estimate\"]")).click();
	        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Push to POS\"]")).click();
	        
	        service.stop();        
	       	        
	        
	}
	  @Test
	  public void CheckToken() throws InterruptedException, FindFailed, IOException
	  {
//		  AppiumDriverLocalService service = new AppiumServiceBuilder()
//			        .usingPort(4723)
//			        .withAppiumJS(new File("C:\\Users\\Admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//			        .withArgument(() -> "--relaxed-security")
//			        .withArgument(() -> "--allow-insecure", "uiautomator2:chromedriver_autodownload")
//			        .build();
//
//		service.start();
//		  
//		  AppiumDriverLocalService service = new AppiumServiceBuilder()
//			        .usingPort(4723)
//			        .withAppiumJS(new File("C:\\Users\\Admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//			        .withArgument(() -> "--relaxed-security")
//			        .withArgument(() -> "--use-plugins", "images")
//			        .withArgument(() -> "--allow-insecure", "uiautomator2:chromedriver_autodownload")
//			        .build();
//
//			service.start(); 
		  
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
	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
	        
	        
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
	        driver.setSetting("snapshotMaxDepth", 100);
	        driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@text='Unni Mukund'])[1]")).click();
	        driver.setSetting("snapshotMaxDepth", 70);
//	        
	        if (!driver.findElements(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"navigateCustomerInfo\"]/android.view.ViewGroup")).isEmpty()) {
	        	Screen s = new Screen();

//	        	
//	        	String imagePath = "src/test/resources/Images/scanner3.png";
//	        	byte[] imageBytes = java.nio.file.Files.readAllBytes(Path.of(imagePath));
//	        	String base64Image = Base64.getEncoder().encodeToString(imageBytes);
//	        	WebElement scanButton = driver.findElement(AppiumBy.image(base64Image)	);
//	        	scanButton.click();
	        	
//	        	String imagePath = "src/test/resources/Images/scanner3.png";
//
//	        	byte[] imageBytes = java.nio.file.Files.readAllBytes(Path.of(imagePath));
//	        	String base64Image = Base64.getEncoder().encodeToString(imageBytes);
//
//	        	WebElement scanButton = driver.findElement(AppiumBy.image(base64Image));
//
//	        	// Get center coordinates
//	        	int centerX = scanButton.getRect().getX() + (scanButton.getRect().getWidth() / 2);
//	        	int centerY = scanButton.getRect().getY() + (scanButton.getRect().getHeight() / 2);
//
//	        	// Tap using coordinates
//	        	PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//
//	        	Sequence tap = new Sequence(finger, 1);
//	        	tap.addAction(finger.createPointerMove(Duration.ZERO,
//	        	        PointerInput.Origin.viewport(),
//	        	        centerX,
//	        	        centerY));
//
//	        	tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//	        	tap.addAction(new Pause(finger, Duration.ofMillis(100)));
//	        	tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//
//	        	driver.perform(Collections.singletonList(tap));
//	        	
//	        	
//	        	Rectangle rect1 = scanButton.getRect();
//
//	        	System.out.println("X: " + rect1.getX());
//	        	System.out.println("Y: " + rect1.getY());
//	        	System.out.println("Width: " + rect1.getWidth());
//	        	System.out.println("Height: " + rect1.getHeight());
//
//	        	int centerX1 = rect1.getX() + rect1.getWidth()/2;
//	        	int centerY1 = rect1.getY() + rect1.getHeight()/2;
//
//	        	System.out.println("CenterX: " + centerX1);
//	        	System.out.println("CenterY: " + centerY1);
//	        	
//	        	
//	        	Rectangle rect = scanButton.getRect();
//
//	        	// Try lower-right area instead of center
//	        	int x = rect.getX() + (rect.getWidth() * 3 / 4);
//	        	int y = rect.getY() + (rect.getHeight() * 3 / 4);
//
//	        	System.out.println("Tap X: " + x);
//	        	System.out.println("Tap Y: " + y);
//
//	        	PointerInput finger1 = new PointerInput(
//	        	        PointerInput.Kind.TOUCH,
//	        	        "finger");
//
//	        	Sequence tap1 = new Sequence(finger1,1);
//
//	        	tap1.addAction(
//	        	    finger.createPointerMove(
//	        	        Duration.ZERO,
//	        	        PointerInput.Origin.viewport(),
//	        	        x,
//	        	        y
//	        	    ));
//
//	        	tap1.addAction(finger.createPointerDown(0));
//	        	tap1.addAction(new Pause(finger, Duration.ofMillis(200)));
//	        	tap1.addAction(finger.createPointerUp(0));
//
//	        	driver.perform(List.of(tap1));
	        	
//	        	String imagePath = "src/test/resources/Images/scanner5.png";
//
//	        	// Add these here
//	        	driver.setSetting(Setting.FIX_IMAGE_TEMPLATE_SIZE, true);
//	        	driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.4);
//
//	        	byte[] imageBytes = Files.readAllBytes(Path.of(imagePath));
//	        	String base64Image = Base64.getEncoder().encodeToString(imageBytes);
//
//	        	WebElement scanButton = driver.findElement( AppiumBy.image(base64Image));
//
//	        	Rectangle rect = scanButton.getRect();
//
//	        	int x = rect.getX() + (rect.getWidth()/2);
//	        	int y = rect.getY() + (rect.getHeight()/2);
//
//	        	System.out.println("Tap X: " + x);
//	        	System.out.println("Tap Y: " + y);
//
//	        	((JavascriptExecutor)driver).executeScript(
//	        	    "mobile: clickGesture",
//	        	    Map.of(
//	        	        "x", x,
//	        	        "y", y
//	        	    )
//	        	);
//

	        	// Important steps don't delete it shows which area we are clicking
//	        	String imagePath = "src/test/resources/Images/scanner6.png";
//
//	        	driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.4);
//
//	        	byte[] imageBytes = Files.readAllBytes(Path.of(imagePath));
//	        	String base64Image = Base64.getEncoder().encodeToString(imageBytes);
//
//	        	WebElement scanButton =
//	        	        driver.findElement(AppiumBy.image(base64Image));
//	        	
//	        	
//	        	
//	        	Rectangle rect = scanButton.getRect();
//
//	        	System.out.println("X: " + rect.getX());
//	        	System.out.println("Y: " + rect.getY());
//	        	System.out.println("Width: " + rect.getWidth());
//	        	System.out.println("Height: " + rect.getHeight());
//
//	        	// Take screenshot
//	        	File screenshot = driver.getScreenshotAs(OutputType.FILE);
//
//	        	// Read image
//	        	BufferedImage img = ImageIO.read(screenshot);
//
//	        	// Draw rectangle where Appium matched
//	        	Graphics2D g = img.createGraphics();
//
//	        	g.drawRect(
//	        	        rect.getX(),
//	        	        rect.getY(),
//	        	        rect.getWidth(),
//	        	        rect.getHeight()
//	        	);
//
//	        	g.dispose();
//
//	        	// Save marked screenshot
//	        	ImageIO.write(img,"png", new File("matchedScreenMarked.png"));
//	        	
//	        	Thread.sleep(2000);
	        	
	        	
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
	        	//int y = rect.getY() + rect.getHeight() + 25;
	        	int y = rect.getY() + rect.getHeight()
	            + (rect.getHeight() / 2);

	        	System.out.println("Tap X = " + x);
	        	System.out.println("Tap Y = " + y);

	        	((JavascriptExecutor) driver).executeScript(
	        	        "mobile: clickGesture",
	        	        Map.of(
	        	                "x", x,
	        	                "y", y
	        	        )
	        	);
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
	  
	  

@BeforeMethod
public void setup() throws MalformedURLException {

    DesiredCapabilities cap = new DesiredCapabilities();

    cap.setCapability("platformName", "Android");
    cap.setCapability("appium:automationName", "UiAutomator2");
    cap.setCapability("appium:deviceName", "Android Emulator");
    cap.setCapability("appium:appPackage", "com.clientelingmobileapp");
    cap.setCapability("appium:appActivity", ".MainActivity");
    cap.setCapability("appium:chromedriverAutodownload", true);

    // Stability settings
    cap.setCapability("appium:newCommandTimeout", 300);
    cap.setCapability("appium:uiautomator2ServerLaunchTimeout", 60000);
    cap.setCapability("appium:uiautomator2ServerInstallTimeout", 60000);

    driver = new AndroidDriver( new URL("http://127.0.0.1:4723"),cap);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
}
	  
	  @Test(invocationCount=30)
	  public void MultipleRun() throws IOException, InterruptedException
	  {
	      
	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));     
	        
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
	        
	      Thread.sleep(5000);
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
	  }
	  
	  @AfterMethod
	  public void tearDown() {

	      if (driver != null) {
	          driver.quit();
	      }
	  }
}




