package stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Signup_pom;
import utlities.Utils;

public class Hooks  {
	public WebDriverWait wait;
	public WebDriver driver;
	
	@Before
	public static void initializeWebdriver()throws Exception {
		System.out.println("In hooks");
		Utils.setUpDriver();
//		log.info("Openeing fireefox browser");
//		if (browser.equalsIgnoreCase("Firefox")) {
//			System.out.println("In baseclass "+browser);
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}
//		else if (browser.equalsIgnoreCase("Chrome")) {
//			log.info("Openeing Chrome browser");
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//
//		}
//		else if (browser.equalsIgnoreCase("Edge")) {
//			log.info("Openeing Edge browser");
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		} 
//		else {
//			throw new RuntimeException("BrowserType Not Supported");
//
//		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.manage().window().maximize();
//		driver.get(Utils.url);
//				wait =new WebDriverWait(driver,Duration.ofSeconds(20));
	
}
	
//public WebDriver getDriver() {
//	return driver;
//	
//}

//@After(order=1)
//public void takescreenshotonfailure(Scenario s) throws IOException {
//
//	if(s.isFailed()) {
//		TakesScreenshot ts = (TakesScreenshot) Utils.getDriver();
//		 File SrcFile=ts.getScreenshotAs(OutputType.FILE);
//             File DestFile=new File("C:\\Users\\amitf\\eclipse-workspace\\Restassured\\DtcWebsite\\src\\test\\resources\\Screenshot\\failedshots.png");
//             FileUtils.copyFile(SrcFile, DestFile);
////		byte[] src= ts.getScreenshotAs(OutputType.BYTES);
////		s.attach(src, "image/png", "screenshot");
//}
//}
@After
public void closedriver() {
	System.out.println("driver close");
	Utils.getDriver().close();
}
}
