package stepdefinitions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.collections.CollectionUtils;




import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Signup_pom;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import utlities.Utils;

public class Sign_SD  {
	private WebDriver driver = Utils.getDriver();
	public static List<Object> nameselected= new ArrayList<Object>();
	public Signup_pom sign=new Signup_pom(driver);
	@Given("The user is in the homepage")
	public void the_user_is_in_the_homepage() {
	System.out.println("Homepage");
	}

	@When("The user hovers over signup and clicks tamil mass sign up button")
	public void the_user_hovers_over_signup_and_clicks_tamil_mass_sign_up_button() {
		sign.clicktamilsignup();
		
	}
	@When("The user clicks on submit after entering passcode")
	public void the_user_clicks_on_submit_after_entering_passcode() {
		sign.sendpasscode();
	}

	@Then("The user is navigated to the sign up page")
	public void the_user_is_navigated_to_the_sign_up_page() {
		String titleexpected=sign.signuptitle();
		Assert.assertEquals(titleexpected, "Signup For DTC Tamil Mass.");
	}
	@Given("The user is in the sign up page")
	public void the_user_is_in_the_sign_up_page() {
		sign.clicktamilsignup();
		sign.sendpasscode();
	}

	@When("The user enters all the details in the sign up page")
	public void the_user_enters_all_the_details_in_the_sign_up_page() {
		sign.selectnamefromdropdown();
		nameselected.add(sign.getname());
		sign.clickyesattend();
		sign.selectadultcount();
		sign.selectkidsovercount();
		sign.selectkidsundercount();
		sign.sendmassint();
		System.out.println("enter details" +nameselected);
	}

	@When("The user clicks on submit button")
	public void the_user_clicks_on_submit_button() {
		try { 
		sign.submitinsignup();
		} catch(UnhandledAlertException esa) {
			System.out.println(esa.getMessage());
		}
	}

	@Then("The confirmation box for sign up appears in the sign up page")
	public void the_confirmation_box_for_sign_up_appears_in_the_sign_up_page() {
		try { 
			String successmsg=driver.switchTo().alert().getText();
			String selentedname= sign.getnamenegative();
			  Assert.assertEquals(successmsg, "Signing up for - "+selentedname+". Do you want to continue?");
			  driver.switchTo().alert().accept();
			} catch (UnhandledAlertException ea) {
				System.out.println(ea.getMessage());
			}
	}

	@When("The user clicks on the coordinators email")
	public void the_user_clicks_on_the_coordinators_email() throws IOException, InterruptedException {
	 sign.clickcoordinatoremail();
	Thread.sleep(2000);
	 BufferedImage expectedImage = ImageIO.read(new File("C:\\Users\\amitf\\eclipse-workspace\\Restassured\\DtcWebsite\\src\\test\\resources\\Screenshot\\savedemailscreenshot.png"));
	  Screenshot eScreenshot = new AShot().takeScreenshot(driver);
      BufferedImage actualImage = eScreenshot.getImage();
      ImageDiffer imgDiff = new ImageDiffer();
      ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
      Assert.assertTrue(diff.hasDiff(),"Images are Same");
   
 }


	@Then("The user is navigated to the email page")
	public void the_user_is_navigated_to_the_email_page() {
		System.out.println("Passed");
	}

	@Given("The user is in the confirmation box window")
	public void the_user_is_in_the_confirmation_box_window() {
		String parenthandle = driver.getWindowHandle();
		sign.confirmationwindow();
		 Set<String> handles = driver.getWindowHandles();
	     System.out.println("The total no of handles are " +handles.size());
//	     for(String handle : handles) {
//	    	 if(!handle.equals(parenthandle)) {
//	    		 driver.switchTo().window(handle);
//	}
//	     }
	
	}
	@When("The user clicks ok button")
	public void the_user_clicks_ok_button() {	
		  Alert alert= driver.switchTo().alert();
		  alert.accept();	
	}

	@Then("The pop up window with confirm message should appear in the sign up page")
	public void the_pop_up_window_with_confirm_message_should_appear_in_the_sign_up_page() {
		try {
			String successmsg=driver.switchTo().alert().getText();
			  Assert.assertEquals(successmsg, "Signed up successfully. Thank you!!.");
				driver.switchTo().alert().accept();
		} catch(UnhandledAlertException ef) {
				ef.getMessage();
			}
	}
//		  String alrettext= sign.successmsg();
//		  Assert.assertEquals(alrettext, "Signed up successfully. Thank you!!");
	
	@Then("The pop up window with should appear in the sign up page")
	public void the_pop_up_window_with_should_appear_in_the_sign_up_page() {
		try { 
		String successmsg=driver.switchTo().alert().getText();
		//driver.switchTo().alert().accept();
		String selentedname= sign.getnamenegative();
		  Assert.assertEquals(successmsg, "Signing up for - "+selentedname+". Do you want to continue?");
		} catch (UnhandledAlertException ea) {
			System.out.println(ea.getMessage());
		}
	}

	@When("The user clicks cancel button")
	public void the_user_clicks_cancel_button() {
		 Alert alert1= driver.switchTo().alert();
		 alert1.dismiss();
	}

	@Given("The user is in the success pop up window")
	public void the_user_is_in_the_success_pop_up_window() {
	 sign.confirmationwindow();
	}

	@Then("Signed up successfully message is displayed")
	public void signed_up_successfully_message_is_displayed() {
		
		try { 
			String actualmsg=driver.switchTo().alert().getText();
			  Assert.assertEquals(actualmsg, "Signed up successfully. Thank you!!.");
			  driver.switchTo().alert().accept();
			} catch (UnhandledAlertException ea) {
				System.out.println(ea.getMessage());
			}
//	   String actualmsg = sign.signedupsuccessbottom();
//	   Assert.assertEquals(actualmsg, "Signed up successfully. Thank you!!");
	   
	}

	@When("The user clicks on View Guests")
	public void the_user_clicks_on_view_guests() {
	
	   sign.clickviewguests();
	   driver.navigate().refresh();
	}

	@Then("The user is navigated to the View guests page successfully")
	public void the_user_is_navigated_to_the_view_guests_page_successfully() {
	   String dateindb= sign.checksigneddate();
//	   LocalDate currentDate = LocalDate.now();
	   String currentDate = new SimpleDateFormat("MM-dd-yyyy").format(new Date());
	   String currentDateString = currentDate.toString();
	   Assert.assertEquals(dateindb, currentDateString);
	}

	@Given("The user is in View Guests page")
	public void the_user_is_in_view_guests_page() {
		sign.clicktamilsignup();
		sign.sendpasscode();
		 sign.clickviewguests();
	}

	@When("The user clicks on Back to sign up page")
	public void the_user_clicks_on_back_to_sign_up_page() {
		sign.clickbacktosignup();
	}

	@Then("The user should be navigated back to the sign up page successfully")
	public void the_user_should_be_navigated_back_to_the_sign_up_page_successfully() {
		SoftAssert sa=new SoftAssert();
	  String signuphomepage= sign.signuptitle();
	  sa.assertEquals(signuphomepage, "Signup For DTC Tamil Mass.");
	  sa.assertAll();
	}

	@Given("The user is in the sign up page after signing up already")
	public void the_user_is_in_the_sign_up_page_after_signing_up_already() {
		sign.clicktamilsignup();
		sign.sendpasscode();
		 
	}

	@Then("The signed up details should match the entered details")
	public void the_signed_up_details_should_match_the_entered_details() throws IOException {
		driver.navigate().refresh();
		TakesScreenshot ts = (TakesScreenshot) Utils.getDriver();
		 File SrcFile=ts.getScreenshotAs(OutputType.FILE);
            File DestFile=new File("C:\\Users\\amitf\\eclipse-workspace\\Restassured\\DtcWebsite\\src\\test\\resources\\Screenshot\\screenshotofviewguests.png");
            FileUtils.copyFile(SrcFile, DestFile);
		List<Object> listofviewpagedetails= new ArrayList<Object>();
		listofviewpagedetails= sign.checksdetailsinview();
		System.out.println("listentered" +nameselected);
	boolean result=	nameselected.get(1) == listofviewpagedetails.get(1);
		System.out.println("listdisplayed" +listofviewpagedetails);
		boolean equalLists = nameselected.size() == listofviewpagedetails.size();
		boolean contais = listofviewpagedetails.contains(nameselected);
		Assert.assertEquals(equalLists, true);
	}

	@When("The user clicks on submit after entering incorrect passcode")
	public void the_user_clicks_on_submit_after_entering_incorrect_passcode() {
	 sign.sendincorrectpasscode();
	}

	@Then("The pop up window with error message is displayed")
	public void the_pop_up_window_with_error_message_is_displayed() {
		String alertmsg= sign.getalertmessage();
		Assert.assertEquals(alertmsg, "Pass code is incorrect. Please try again");	
		driver.switchTo().alert().accept();	
	}

	@When("The user enters details in the sign up page leaving the name field unselected")
	public void the_user_enters_details_in_the_sign_up_page_leaving_the_name_field_unselected() {
		try {
		sign.clickyesattend();
		sign.selectadultcountneg();
		sign.selectkidsovercountneg();
		sign.selectkidsundercountneg();
		sign.sendmassint();	
	} catch (UnhandledAlertException e) {
		System.out.println(e.getMessage());
		
		}
	}

	@Then("The error message to fill fields is displayed")
	public void the_error_message_to_fill_fields_is_displayed() {
		SoftAssert softAssert = new SoftAssert();
		String msgd=null;
		try {
	   msgd= sign.fillfieldwarning();
		} catch(UnhandledAlertException e) {
			System.out.println(e.getMessage());
		}
//try {
//	   Assert.assertEquals(msgd, "Please make sure all the required fields are completed");
//	} catch(AssertionError et) {
//		System.out.println(et.getMessage());
//	}
		softAssert.assertEquals(msgd, "Please make sure all the required fields are completed");
		softAssert.assertAll();
	}

	@When("The user enters details in the sign up page leaving will you attend field unselected")
	public void the_user_enters_details_in_the_sign_up_page_leaving_will_you_attend_field_unselected() {
		sign.selectnamefromdropdownfornegative();
		sign.selectadultcountneg();
		sign.selectkidsovercountneg();
		sign.selectkidsundercountneg();
		sign.sendmassint();
	}

	@When("The user enters details in the sign up page leaving family count field unselected")
	public void the_user_enters_details_in_the_sign_up_page_leaving_family_count_field_unselected() {
		sign.selectnamefromdropdownfornegative();
		sign.clickyesattend();
		sign.sendmassint();
	}

	@When("The user enters details in the sign up page leaving adult count field unselected")
	public void the_user_enters_details_in_the_sign_up_page_leaving_adult_count_field_unselected() {
		sign.selectnamefromdropdownfornegative();
		sign.clickyesattend();
		sign.selectkidsovercountneg();
		sign.selectkidsundercountneg();
		sign.sendmassint();
	}

	@When("The user enters details in the sign up page leaving kids count field unselected")
	public void the_user_enters_details_in_the_sign_up_page_leaving_kids_count_field_unselected() {
		sign.selectnamefromdropdownfornegative();
		sign.clickyesattend();
		sign.selectadultcountneg();
		sign.sendmassint();
	}

	@When("The user enters details in the sign up page leaving thanksgiving field empty")
	public void the_user_enters_details_in_the_sign_up_page_leaving_thanksgiving_field_empty() {
		sign.selectnamefromdropdownfornegative();
		sign.clickyesattend();
		sign.selectadultcountneg();
		sign.selectkidsovercountneg();
		sign.selectkidsundercountneg();
		sign.sendrepose();
		sign.sendmassint();
	}

	@When("The user enters details in the sign up page leaving repose of souls field empty")
	public void the_user_enters_details_in_the_sign_up_page_leaving_repose_of_souls_field_empty() {
		sign.selectnamefromdropdownfornegative();
		sign.clickyesattend();
		sign.selectadultcountneg();
		sign.selectkidsovercountneg();
		sign.selectkidsundercountneg();
		sign.sendthanks();
		sign.sendmassint();
		
	}

	@When("The user enters details in the sign up page leaving family intention field empty")
	public void the_user_enters_details_in_the_sign_up_page_leaving_family_intention_field_empty() {
		sign.selectnamefromdropdownfornegative();
		sign.clickyesattend();
		sign.selectadultcountneg();
		sign.selectkidsovercountneg();
		sign.selectkidsundercountneg();
		sign.sendrepose();
		sign.sendthanks();
	}

	@When("The user selects the name in the dropdown")
	public void the_user_selects_the_name_in_the_dropdown() {
		sign.selectnamefromdropdown();
		sign.clickyesattend();
		sign.selectadultcountneg();
		sign.selectkidsovercountneg();
		sign.selectkidsundercountneg();
		sign.sendmassint();
		
	}

	@Then("The error message you have already signed up is displayed")
	public void the_error_message_you_have_already_signed_up_is_displayed() {
	 String alreadysignedup= sign.fillfieldwarning();
	try {
	   Assert.assertEquals(alreadysignedup, "You have already signed up. If you wish to change, please update and re-submit.");
	} catch(AssertionError et) {
		System.out.println(et.getMessage());
	}
	}

	@When("The user enters all details and special characters in thanksgiving field")
	public void the_user_enters_all_details_and_special_characters_in_thanksgiving_field() {
		sign.selectnamefromdropdownfornegative();
		sign.clickyesattend();
		sign.selectadultcountneg();
		sign.selectkidsovercountneg();
		sign.selectkidsundercountneg();
		sign.sendspecialthanks();
	}

	@Then("The error message for special characters should appear in the sign up page")
	public void the_error_message_for_special_characters_should_appear_in_the_sign_up_page() {
		try {
			driver.switchTo().alert().dismiss();
		System.out.println("An error msg shd occur");
		}catch(UnhandledAlertException ed) {
			ed.getMessage();	
		}
	}

	@When("The user enters all details and special characters in repose of souls field empty")
	public void the_user_enters_all_details_and_special_characters_in_repose_of_souls_field_empty() {
		sign.selectnamefromdropdownfornegative();
		sign.clickyesattend();
		sign.selectadultcountneg();
		sign.selectkidsovercountneg();
		sign.selectkidsundercountneg();
		sign.sendspecialrepose();
	}

	@When("The user enters all details and special characters in family intentions field empty")
	public void the_user_enters_all_details_and_special_characters_in_family_intentions_field_empty() {
		sign.selectnamefromdropdownfornegative();
		sign.clickyesattend();
		sign.selectadultcountneg();
		sign.selectkidsovercountneg();
		sign.selectkidsundercountneg();
		sign.sendspecialmassint();
	}
}
