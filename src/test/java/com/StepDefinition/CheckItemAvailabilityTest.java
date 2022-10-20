package com.StepDefinition;

import org.junit.Assert;

import com.base.TestBase;

import cucumber.api.java.en.*;

public class CheckItemAvailabilityTest extends TestBase{

	String itemavaialable=null;
	@Given("^User clicks on My Personal Information button$")
	public void user_clicks_on_My_Personal_Information_button() throws Throwable {
	   checkavailability.ClickOnMyPersonalInfo();
	}

	@Given("^User Selects Social title Option #Radio button$")
	public void user_Selects_Social_title_Option_Radio_button() throws Throwable {
		checkavailability.SelectGender();
	}

	@Given("^User Updates Date of Birth #Data picker$")
	public void user_Updates_Date_of_Birth_Data_picker() throws Throwable {
		checkavailability.SelectDay();
		Thread.sleep(4000);
		checkavailability.SelectMonth();
		Thread.sleep(4000);
		checkavailability.SelectYear();
		Thread.sleep(4000);
	}

	@Then("^User enters Password$")
	public void user_enters_Password() throws Throwable {
		checkavailability.EneterConfirmPassword();
	}

	@Then("^Clicks on Save button$")
	public void clicks_on_Save_button() throws Throwable {
		checkavailability.SaveInfo();
	}

	@Given("^User Clicks on Search bar$")
	public void user_Clicks_on_Search_bar() throws Throwable {
		checkavailability.ClickOnSearchBar();
	}

	@When("^User enters Item name$")
	public void user_enters_Item_name() throws Throwable {
		checkavailability.EnperItemName();
	}

	@When("^Clicks on Search icon$")
	public void clicks_on_Search_icon() throws Throwable {
		checkavailability.ClickOnSearchIcon();
	}

	@When("^User Filters the product#DropDown$")
	public void user_Filters_the_product_DropDown() throws Throwable {
		checkavailability.SortTheItem();
	}

	@Given("^User Fetches the availability of product$")
	public void user_Fetches_the_availability_of_product() throws Throwable {
		checkavailability.IsItemAvailable();
	}

	@Given("^User Verifies the Item Availability$")
	public void user_Verifies_the_Item_Availability() throws Throwable {
	   Assert.assertTrue(checkavailability.IsItemAvailable());
	}

	
	
}
