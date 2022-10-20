package com.StepDefinition;



import org.junit.Assert;

import com.base.TestBase;

import cucumber.api.java.*;
import cucumber.api.java.en.*;

public class ApplicationSignInTest extends TestBase{
	

	ApplicationSignInTest signintest;
	@Before("@Login")
	public void Launch() {
		initialization();
		
	}

	@Given("^User Navigate to Application$")
	public void user_Navigate_to_Application() throws Throwable {
	   Assert.assertEquals("My Store", signinpage.ValidateApplicationTitle()); 

	}

	@When("^User clicks on Signin Option$")
	public void user_clicks_on_Signin_Option() throws Throwable {
		signinpage.ClickOnSignInOption();
	}

	@When("^User enters Email and Password$")
	public void user_enters_Email_and_Password() throws Throwable {
	   signinpage.SignIntoApp(property.getProperty("Email"), property.getProperty("Password"));
	}
	
	@When("^User clicks on Signin button$")
	public void user_clicks_on_Signin_button() throws Throwable {
		signinpage.ClickOnSignInButton();
	}


	@Then("^User Logged into the application Successfully#validate page title$")
	public void user_Logged_into_the_application_Successfully_validate_page_title() throws Throwable {
		Assert.assertEquals("My account - My Store", signinpage.ValidateHomePage()); 
		Thread.sleep(4000);

	}

	@Given("^User is in Order Page #validate Order page title$")
	public void user_is_in_Order_Page_validate_Order_page_title() throws Throwable {
		Assert.assertEquals("Order - My Store", signinpage.ValidateOrderPage()); 
		Thread.sleep(4000);
	}

	@When("^User clicks on SignOut Option$")
	public void user_clicks_on_SignOut_Option() throws Throwable {
	    signinpage.ClickonSignOutOption();
	}
	
	@Then("^User Logged out from the application Successfully #validate page title$")
	public void user_Logged_out_from_the_application_Successfully_validate_page_title() throws Throwable {
		Assert.assertEquals("Order - My Store", signinpage.ValidateSinInPage()); 
		Thread.sleep(4000);
	}
	
}
