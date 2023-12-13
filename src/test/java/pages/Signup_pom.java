package pages;



import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.time.Duration;
import io.cucumber.java.Before;

import stepdefinitions.Sign_SD;
import utlities.Utils;

public class Signup_pom {
	public static WebDriverWait wait;
	public WebDriver driver= Utils.getDriver();
	public Signup_pom(WebDriver driver) {
		this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='/signup-link']") 
	WebElement signupbutton;
	@FindBy(xpath="//ul[@id='sm-17013804818497039-20']/li/a") 
	WebElement tamilmasssignuplink;
	@FindBy(id="signuppass_code") 
	WebElement passcode;
	@FindBy(xpath="//*[contains(text(), 'Submit')]") 
	WebElement submit;
	@FindBy(xpath="//div[@class='content']/div/div/div/div[2]/h3/center/u")
	WebElement signuppagetitle;
	@FindBy(id="familes")
	WebElement familynamedropdown;
	@FindBy(id="RB_Attend_Status_Yes")
	WebElement clickyes;
	@FindBy(id="RB_Attend_Status_No")
	WebElement clickno;
	@FindBy(id="RB_Attend_Status_Maybe")
	WebElement clickmaybe;
	@FindBy(id="Sel_Adult")
	WebElement selectadult;
	@FindBy(id="Sel_Kids10")
	WebElement kidsunder;
	@FindBy(id="Sel_Kids18")
	WebElement kidsover;
	@FindBy(id="Sel_int_thank")
	WebElement thanksgiving;
	@FindBy(id="Sel_int_repose")
	WebElement repose;
	@FindBy(id="Sel_mass_int")
	WebElement massintentions;
	@FindBy(xpath="//*[contains(text(), 'Submit')]") 
	WebElement submitinsignup;
	@FindBy(xpath="//div[@itemprop='articleBody']/div[2]/h7/span/a") 
	WebElement emailcoor;
	@FindBy(id="errWarn")
	WebElement signedupsuccessmsg;
	@FindBy(xpath="//*[contains(text(), 'View Guests')]") 
	WebElement viewguests;
	@FindBy(xpath="//div[@itemprop='articleBody']//div[@style='overflow-x:auto;'][1]/table/tbody/tr[14]/td[5]") 
	WebElement signedondate;
	@FindBy(xpath="//*[contains(text(), 'Back to Signup Page')]") 
	WebElement backtosignup;
	@FindBy(xpath="//h4[@id='errWarn']") 
	WebElement fillemptyfield;

	
	
	public void clicktamilsignup() {
		System.out.println("get driver");
		String parenthandle = driver.getWindowHandle();
		System.out.println("parenthandle" +parenthandle);
		 String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                 "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
             "arguments[0].dispatchEvent(evObj);";
 JavascriptExecutor js = (JavascriptExecutor)driver;
 //Pass element on which mouse hover to be performed
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
 js.executeScript(javaScript,signupbutton);
		System.out.println("Mouse hovered sign up");
		 Set<String> handles = driver.getWindowHandles();
	     System.out.println("The total no of handles are" +handles.size());
	     for(String handle : handles) {
	    	 if(!handle.equals(parenthandle)) {
	    		 driver.switchTo().window(handle);
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='sm-17013804818497039-20']/li/a")));
		tamilmasssignuplink.click();
	    	 }
	     }
	     driver.switchTo().window(parenthandle);
//	    	String switchbacktoparentwindow= driver.getWindowHandle();
//	    	System.out.println("Switchback" +switchbacktoparentwindow);
	}
	
	public void sendpasscode() {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("signuppass_code")));
		passcode.sendKeys("842294");
		System.out.println("sending keys");
		submit.click();
	}
	public void sendincorrectpasscode() {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("signuppass_code")));
		passcode.sendKeys("@#$%^");
		System.out.println("sending incorrect keys");
		submit.click();
	}
	
	public String signuptitle() {
		String tit= signuppagetitle.getText();
		return tit;
	}
	public String fillfieldwarning() {
		String msgs= fillemptyfield.getText();
		return msgs;
	}
	public String getalertmessage() {
		String incorrectalert= driver.switchTo().alert().getText();
		return incorrectalert;
	}
	public void selectnamefromdropdown() {
		Select s=new Select(familynamedropdown);
		s.selectByIndex(42);
	}
	public void selectnamefromdropdownfornegative() {
		Select s=new Select(familynamedropdown);
		s.selectByIndex(32);
	}
	public String getnamenegative() {
		Select s=new Select(familynamedropdown);
		s.selectByIndex(32);
		WebElement o = s.getFirstSelectedOption();
	   String selectedoption = o.getText();
	    return selectedoption;
	}
	public String getname() {
		Select s=new Select(familynamedropdown);
		s.selectByIndex(42);
		WebElement o = s.getFirstSelectedOption();
	   String selectedoption = o.getText();
	    return selectedoption;
	}
	public void clickyesattend() {
		clickyes.click();
	}
	public void clicknoattend() {
		clickno.click();
	}
	public void clickmaybeattend() {
		clickmaybe.click();
	}
	
	public void selectadultcount() {
		Select sel=new Select(selectadult);
		sel.selectByIndex(2);
		WebElement options = sel.getFirstSelectedOption();
		String items = options.getText();
		System.out.println(items);
		Sign_SD.nameselected.add(items); //list index 2 adultscount
		System.out.println("adult count added" +Sign_SD.nameselected);
	}
	public void selectadultcountneg() {
		Select sel=new Select(selectadult);
		sel.selectByIndex(2);
	}
	public void selectkidsundercount() {
		Select sel=new Select(kidsunder);
		sel.selectByIndex(2);
		WebElement option = sel.getFirstSelectedOption();
		String item = option.getText();
		System.out.println(item);
		Sign_SD.nameselected.add(item); //list index 1 kidscount
		System.out.println("kids count added" +Sign_SD.nameselected);
	}
	public void selectkidsundercountneg() {
		Select sel=new Select(kidsunder);
		sel.selectByIndex(3);
	}
	public void selectkidsovercount() {
		Select sel=new Select(kidsover);
		sel.selectByIndex(2);
		WebElement optionss = sel.getFirstSelectedOption();
		String itemss = optionss.getText();
		System.out.println(itemss);
		Sign_SD.nameselected.add(itemss); //list index 3 kidsovercount
		System.out.println("kids over count added" +Sign_SD.nameselected);
	
}
	public void selectkidsovercountneg() {
		Select sel=new Select(kidsover);
		sel.selectByIndex(3);
	
}
	
	public void sendthanks() {
		thanksgiving.sendKeys("Thanking family");
	}
	public void sendspecialthanks() {
		thanksgiving.sendKeys("@#%^*&*(");
	}
	public void sendrepose() {
		repose.sendKeys("Repose family");
	}
	public void sendspecialrepose() {
		repose.sendKeys("@#%^*&*(");
	}
	public void sendmassint() {
		massintentions.sendKeys("Mass family");
	}
	public void sendspecialmassint() {
		massintentions.sendKeys("@#%^*&*");
	}
	public void submitinsignup() {
		submitinsignup.click();
	}
	public void clickcoordinatoremail() {
		emailcoor.click();
	}
	
	public void confirmationwindow() {
		Signup_pom spom=new Signup_pom(driver);
		spom.clicktamilsignup();
		spom.sendpasscode();
		spom.selectnamefromdropdown();
		spom.clickyesattend();
		spom.selectadultcountneg();
		spom.sendmassint();
		spom.submitinsignup();
	}
	
	public String successmsg() {
		String msg= signedupsuccessmsg.getText();
		return msg;
		
	}
	
	public String signedupsuccessbottom() {
		String msg = signedupsuccessmsg.getText();
		return msg;
		
	}
	public void clickviewguests() {
		viewguests.click();
	}
	public void clickbacktosignup() {
		backtosignup.click();
	}
	
	public String checksigneddate() {
		String dateofthenameselected=null;
	    Object nameselected = Sign_SD.nameselected.get(0);
	   System.out.println("the name" +nameselected);
		int totalrows= driver.findElements(By.xpath("//div[@itemprop='articleBody']//div[@style='overflow-x:auto;'][1]/table/tbody/tr")).size();  
		System.out.println("totalrows" +totalrows);
		for(int n=2; n<=totalrows; n++) {
			if(driver.findElement(By.xpath("//div[@itemprop='articleBody']//div[@style='overflow-x:auto;'][1]/table/tbody/tr["+n+"]/td[1]")).getText().equals(nameselected)) {
				 dateofthenameselected= driver.findElement(By.xpath("//div[@itemprop='articleBody']//div[@style='overflow-x:auto;'][1]/table/tbody/tr["+n+"]/td[5]")).getText();
				 System.out.println("date is" +(dateofthenameselected));
			}
		}
		System.out.println("date returned is" +dateofthenameselected);
		return dateofthenameselected;
	}
	
	public List<Object> checksdetailsinview() {
		List<Object> viewlist= new ArrayList<Object>();
	
	    Object nameofsignup = Sign_SD.nameselected.get(0);
	   System.out.println("the name" +nameofsignup);
		int totalrows= driver.findElements(By.xpath("//div[@itemprop='articleBody']//div[@style='overflow-x:auto;'][1]/table/tbody/tr")).size();  
		System.out.println("totalrows" +totalrows);
		for(int n=2; n<=totalrows; n++) {
			if(driver.findElement(By.xpath("//div[@itemprop='articleBody']//div[@style='overflow-x:auto;'][1]/table/tbody/tr["+n+"]/td[1]")).getText().equals(nameofsignup)) {
				viewlist.add(driver.findElement(By.xpath("//div[@itemprop='articleBody']//div[@style='overflow-x:auto;'][1]/table/tbody/tr["+n+"]/td[1]")).getText());
				System.out.println("name added" +viewlist);
				String kidscount= driver.findElement(By.xpath("//div[@itemprop='articleBody']//div[@style='overflow-x:auto;'][1]/table/tbody/tr["+n+"]/td[3]")).getText();
				int kidscoun = Integer.parseInt(kidscount);
				viewlist.add(kidscoun);
				System.out.println("kidscount added" +viewlist);
		String adultcount = driver.findElement(By.xpath("//div[@itemprop='articleBody']//div[@style='overflow-x:auto;'][1]/table/tbody/tr["+n+"]/td[2]")).getText();
		int adultcoun = Integer.parseInt(adultcount);
		viewlist.add(adultcoun);
		System.out.println("adultcount added" +viewlist);
		String kidsovercount= driver.findElement(By.xpath("//div[@itemprop='articleBody']//div[@style='overflow-x:auto;'][1]/table/tbody/tr["+n+"]/td[4]")).getText();
		int kidsovercoun = Integer.parseInt(kidsovercount);
		viewlist.add(kidsovercoun);
		System.out.println("kidsovercount added" +viewlist);
	}
}
		 System.out.println("this is list displayed in view guests" +viewlist);
		return viewlist;
	}
}
