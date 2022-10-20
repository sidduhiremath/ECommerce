package com.utils;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.base.TestBase;

public class CommonMethods extends TestBase {
	Select select;
	Actions action;

	public void Web_Click(WebElement element) throws InterruptedException {
		Thread.sleep(5000);
		element.click();
	}

	public void Web_Drop_Down(WebElement element, String value) throws InterruptedException {
		Thread.sleep(5000);
		select = new Select(element);
		Thread.sleep(5000);
		select.selectByVisibleText(value);
		Thread.sleep(5000);
	}

	public void Web_Send_Keys(WebElement element, String data) throws InterruptedException {
		Thread.sleep(5000);
		element.sendKeys(data);

	}

	public void Web_Mouse_Hover(WebElement element) throws InterruptedException {
		Thread.sleep(5000);
		action = new Actions(driver);
		Thread.sleep(5000);
		action.moveToElement(element);
		Thread.sleep(3000);
	}

	public String Web_Get_Title() throws InterruptedException {
		Thread.sleep(5000);
		return driver.getTitle();
	}

	public void Web_Switch_To_Window() throws InterruptedException {
		Thread.sleep(5000);
		Set<String> ids = driver.getWindowHandles();
		String parent = driver.getWindowHandle();

		for (String child : ids) {
			if (!(parent.equals(child))) {
				driver.switchTo().window(child);
				Thread.sleep(2000);
				driver.close();
			}
		}
		driver.switchTo().window(parent);
	}

	public String Web_Get_Data(WebElement element) throws InterruptedException {
		Thread.sleep(5000);
		return element.getText();
	}

	public void Web_Reload_Screen() throws InterruptedException {
		Thread.sleep(4000);
		driver.navigate().refresh();
	}

	public void Web_Accept_Alert() throws InterruptedException {
		Thread.sleep(4000);
		driver.switchTo().alert().accept();

	}

}
