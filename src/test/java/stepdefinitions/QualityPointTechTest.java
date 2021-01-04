package stepdefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import stepdefinitions.MasterStepDefs;

import org.openqa.selenium.support.PageFactory;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.en.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.EmployeeDetails_Page;
import pages.LoginPage;
import utilities.ExcelRead;

import base.WebDriverFactory;
import base.Screenshot;
import cucumber.api.java.en.*;


public class QualityPointTechTest extends MasterStepDefs{
	WebDriver driver;
	Screenshot sc;
	ExcelRead excelRead=new ExcelRead();
	
	LoginPage login;
	EmployeeDetails_Page emp;
	
	
	/**
	 * method to get extentreports
	 */
//	public static ExtentReports report = new ExtentReports("./Reports/ExtentReport.html");
//	ExtentTest test = report.startTest("QualityPointTech");
	
	//Screenshot ob=new Screenshot(driver);	
	
	//Logger logger;
	
@Given("^Open chrome and start application$")
public void open_chrome_and_start_application() throws Throwable {
	System.out.println("1"); 
	excelRead.read();
	driver=WebDriverFactory.Launch_Browser("url");
	sc=new Screenshot(driver);
	 ExtentCucumberAdapter.addTestStepLog("Application launched successfully");
     try {
         ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(getScreenhot(driver));
     } catch (IOException e) {
         e.printStackTrace();
     }
	
}

@When("Entering Username,Password and Click on Login button")
public void entering_Username_Password_and_Click_on_Login_button() throws Throwable {
	System.out.println("3"); 
	login=new LoginPage(driver);
	login.enterUserName();
	login.enterPassword();
	
    sc.getScreenshot(driver);
    login.clickOnLoginButton();

    ExtentCucumberAdapter.addTestStepLog("Entering Username,Password and Click on Login button");
    try {
        ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(getScreenhot(driver));
    } catch (IOException e) {
        e.printStackTrace();
    }
}


@Then("^user should be able to login$")
public void user_should_be_able_to_login() throws Throwable {
//	login.clickOnLoginButton();
	login=new LoginPage(driver);
	
	Assert.assertEquals("http://qualitypointtech.net/timesheetdemo/report.php", driver.getCurrentUrl());
	
	
	System.out.println(driver.getCurrentUrl());
	System.out.println("login sucessfull"); 
	sc.getScreenshot(driver);
	ExtentCucumberAdapter.addTestStepLog("User is able to login-verified Successfull login message");
    try {
        ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(getScreenhot(driver));
    } catch (IOException e) {
        e.printStackTrace();
    }
	//logger.info("login sucessful");
}
@When("^user clicks on Employee Details Button$")
public void user_clicks_on_Employee_Details_Button() throws Throwable {
	emp = new EmployeeDetails_Page(driver);
	emp.clickOnEmployeeDetails();
//	emp=PageFactory.initElements(driver, EmployeeDetailsPageWithPageFactory.class);
	//emp.clickonEmployeeDetails();
//	logger.info("clicked on employee details button");
	Assert.assertEquals("http://qualitypointtech.net/timesheetdemo/edit_employee.php", driver.getCurrentUrl());
		System.out.println(driver.getCurrentUrl());
	System.out.println("edit emp details page is displayed"); 
	sc.getScreenshot(driver);
	ExtentCucumberAdapter.addTestStepLog("Clicking on employee details and verifying the page");
    try {
        ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(getScreenhot(driver));
    } catch (IOException e) {
        e.printStackTrace();
    }
}
@And("^user clicks on edit option$")
public void user_clicks_on_edit_option() throws Throwable {
	emp = new EmployeeDetails_Page(driver);
	emp.clickonEdit();
	
	System.out.println(" edit emp details page is displayed"); 
	sc.getScreenshot(driver);
	 ExtentCucumberAdapter.addTestStepLog("user clicks on edit option");
     try {
         ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(getScreenhot(driver));
     } catch (IOException e) {
         e.printStackTrace();
     }
//	logger.info("username entered");
}

@And("^user update mail id$")
public void user_update_mail_id() throws Throwable {
	emp = new EmployeeDetails_Page(driver);
	emp.editEmailId(" ");
	emp.editEmailId("abc@gmail.com");
	sc.getScreenshot(driver);
	 ExtentCucumberAdapter.addTestStepLog("user update email Id");
     try {
         ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(getScreenhot(driver));
     } catch (IOException e) {
         e.printStackTrace();
     }
	
}

@And("^user clicks on update employee details$")
public void user_clicks_on_update_employee_details() throws Throwable {
	emp = new EmployeeDetails_Page(driver);
	emp.clickonUpdateEmp();
	System.out.println(" Employee Details updated Successfully"); 
	sc.getScreenshot(driver);
	 ExtentCucumberAdapter.addTestStepLog("user clicks on update employee details ");
     try {
         ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(getScreenhot(driver));
     } catch (IOException e) {
         e.printStackTrace();
     }
}

@And("^user clicks on logout$")
public void user_clicks_on_logout() throws Throwable {
	emp = new EmployeeDetails_Page(driver);
	emp.clickonLogout();
	System.out.println(" logout successfully");
	sc.getScreenshot(driver);
	 ExtentCucumberAdapter.addTestStepLog("user clicks on logout option");
     try {
         ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(getScreenhot(driver));
     } catch (IOException e) {
         e.printStackTrace();
     }
}



@Then("^application should be closed$")
public void application_should_be_closed() throws Throwable {
	TimeUnit.SECONDS.sleep(5);
	driver.quit();
//	report.endTest(test);
//	report.flush();
}


}
