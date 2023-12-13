package utlities;

import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utils {
	private static Utils utils;    
	public static ResourceBundle path=ResourceBundle.getBundle("paths"); //creating object and accessing the path properties file
	private static WebDriver driver ;
	public WebDriverWait wait;
	public static Logger log = LogManager.getLogger();
	public static String browser = path.getString("browsername");
	public static String url=path.getString("baseurl");
	
	private Utils(){
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
		System.out.println("opening browser and url");
		log.info("Openeing fireefox browser");
		if (browser.equalsIgnoreCase("Firefox")) {
			System.out.println("In baseclass "+browser);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("Chrome")) {
			log.info("Openeing Chrome browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}
		else if (browser.equalsIgnoreCase("Edge")) {
			log.info("Openeing Edge browser");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} 
		else {
			throw new RuntimeException("BrowserType Not Supported");

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(Utils.url);
				wait =new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
	 public static void setUpDriver() {
	        	utils = new Utils();
	        
	    }
	  public static WebDriver getDriver() {
	        return driver;
	    }
}
