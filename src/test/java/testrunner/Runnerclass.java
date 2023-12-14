package testrunner;



import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import org.junit.runner.RunWith;

import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ={"src/test/resources/Features/Signup.feature"}, 
glue = {"stepdefinitions"}, 
monochrome = true, 
plugin = {"pretty",
		"html:target/cucmberreport.html",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		})

public class Runnerclass extends AbstractTestNGCucumberTests{
//	@DataProvider(parallel = false)
//    @Override
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }



}

