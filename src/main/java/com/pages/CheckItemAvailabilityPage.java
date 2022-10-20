package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utils.CommonMethods;

public class CheckItemAvailabilityPage extends CommonMethods{

	
	public CheckItemAvailabilityPage(){
		super();
		}
	
	@FindBy(xpath="//span[text()='My personal information']")
	WebElement mypersonalinfo;
	
	@FindBy(xpath="//input[@name='id_gender']")
	WebElement gender;
	
	@FindBy(name = "days")
	WebElement day;
	
	@FindBy(name="months")
	WebElement month;
	
	@FindBy(name="years")
	WebElement year;
	
	@FindBy(id = "old_passwd")
	WebElement confirmpassword;
	
	@FindBy(xpath="//span[text()='Save']")
	WebElement saveinfo;
	
	@FindBy(name = "search_query")
	WebElement searchbar;
	
	@FindBy(name = "submit_search")
	WebElement searchicon;
	
	@FindBy(id = "selectProductSort")
	WebElement sortitem;
	
	@FindBy(xpath = "(//span[@class='available-now'])[1]")
	WebElement isitemavaialable;
	
	
	
	public void ClickOnMyPersonalInfo() throws InterruptedException {
		Thread.sleep(4000);
		Web_Click(mypersonalinfo);
	}
	
	public void SelectGender() throws Exception {
		Thread.sleep(4000);
		Web_Click(gender);
		takescreenshot("Gender");
	}
	
	public void SelectDay() throws InterruptedException {
		Thread.sleep(4000);
		Web_Drop_Down(day, "22  ");
	}
	
	public void SelectMonth() throws InterruptedException {
		Thread.sleep(4000);
		Web_Drop_Down(month, "March ");
	}
	
	public void SelectYear() throws Exception {
		Thread.sleep(4000);
		Web_Drop_Down(year, "1997  ");
		takescreenshot("Date of Birth");
	}
	
	public void EneterConfirmPassword() throws Exception {
		Web_Click(confirmpassword);
		Thread.sleep(4000);
		Web_Send_Keys(confirmpassword, property.getProperty("Password"));
		takescreenshot("Confirm Password");
	}
	
	public void SaveInfo() throws Exception {
		Thread.sleep(4000);
		Web_Click(saveinfo);
		takescreenshot("Save Info");
	}
	
	public void ClickOnSearchBar() throws InterruptedException {
		Thread.sleep(4000);
		Web_Click(searchbar);
	}

	public void EnperItemName() throws Exception  {
		Thread.sleep(4000);
		String productname=ReadFromExcel(1);
		Thread.sleep(3000);
		Web_Send_Keys(searchbar, productname);
		takescreenshot("Enetr Item in Searchbar");
	}
	
	public void ClickOnSearchIcon() throws InterruptedException {
		Thread.sleep(6000);
		Web_Click(searchicon);
	}
	
	public void SortTheItem() throws Exception {
		Thread.sleep(8000);
		Web_Drop_Down(sortitem, "Product Name: A to Z");
		takescreenshot("Sort the Item");
	}
	
	public boolean IsItemAvailable() throws InterruptedException {
		String itemavailable=isitemavaialable.getText();
		Thread.sleep(4000);
		if(itemavailable.contains("In stock")) {
		return true;
		}
		else {
		return false;
		}
	}
}
