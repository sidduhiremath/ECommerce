package com.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utils.CommonMethods;

public class ApplicationSignInPage extends CommonMethods{

	public ApplicationSignInPage(){
		super();
		}
	
	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement signinoption;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement signinbutton;
	
	@FindBy(xpath="//a[@title='Log me out']")
	WebElement signoutoption;

	public String ValidateApplicationTitle() throws Exception {
		takescreenshot("SignInPage");
		return Web_Get_Title();
	}
	
	public void ClickOnSignInOption() throws Exception {
		Thread.sleep(4000);
		Web_Click(signinoption);
		Thread.sleep(6000);
		takescreenshot("LoginPage");

	}
	
	public void SignIntoApp(String eml,String pass) throws Exception {
	Web_Send_Keys(email,eml);
	Thread.sleep(4000);
	Web_Send_Keys(password, pass);
	Thread.sleep(4000);
	

	}
	
	public void ClickOnSignInButton() throws Exception {
		Thread.sleep(4000);
		takescreenshot("Entered Credentials");
	    JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", signinbutton);
		Thread.sleep(4000);
	}

	public String ValidateHomePage() throws Exception {
		takescreenshot("Home Page");
		return Web_Get_Title();
	
	}
	
	public String ValidateOrderPage() throws Exception {
		takescreenshot("Order Page");
		return Web_Get_Title();
	}
	
	public void ClickonSignOutOption() throws Exception {
		Thread.sleep(4000);
		Web_Click(signoutoption);
		Thread.sleep(4000);
	}

	public String ValidateSinInPage() throws Exception {
		takescreenshot("SignIn Page");
		return Web_Get_Title();
	}
}