package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.pages.MoveItemToCartPage;
import com.pages.CheckItemAvailabilityPage;
import com.pages.ProceedToCheckoutPage;
import com.pages.ApplicationSignInPage;



public class TestBase {
	public static WebDriver driver;
	public static Properties property;
	public static FileInputStream fis;
	public static File file;
	public static FileOutputStream fout;
	public static Long PAGE_LOAD_TIMEOUT=20L;
	public static Long IMPLICIT_WAIT=10l;
	
	public static ApplicationSignInPage signinpage;
	public static CheckItemAvailabilityPage checkavailability;
	public static MoveItemToCartPage addtocart;
	public static ProceedToCheckoutPage checkout;


	
	public static final long serialVersionUID = 1L;
	
	public TestBase() {
		try {
			property = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\config\\config.properties");
			property.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public  void initialization(){
		String browserName = property.getProperty("Browsername");
		try {
			
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\resource\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gickodriver.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\resource\\gickodriver.exe");	
			driver = new ChromeDriver(); 
		}
		else {
			System.out.println("Invalid Browser");
		}
			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(property.getProperty("Url"));
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			signinpage=PageFactory.initElements(driver,ApplicationSignInPage.class);
			checkavailability=PageFactory.initElements(driver,CheckItemAvailabilityPage.class);
			addtocart=PageFactory.initElements(driver,MoveItemToCartPage.class);
			checkout=PageFactory.initElements(driver,ProceedToCheckoutPage.class);
		}

	}
	
	public String ReadFromExcel(int n) throws Exception {
	file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\testdata\\Controller.xlsx");
	FileInputStream fis = new FileInputStream(file);
	XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
	String cellStringValue = null;
	int rowCount = sheet.getPhysicalNumberOfRows();
	 
	if(!(n>=rowCount)) {
			XSSFRow row = sheet.getRow(n);

				XSSFCell cell = row.getCell(n);
				cellStringValue = cellValue(cell);
	}
	else {
		System.out.println("No data found");
	}
	return cellStringValue;
}


public static String cellValue(XSSFCell cell) {
	switch (cell.getCellType()) {
	case NUMERIC:
		return String.valueOf(cell.getNumericCellValue());
	case BOOLEAN:
		return String.valueOf(cell.getBooleanCellValue());
	case STRING:
		return cell.getStringCellValue();
	default:
		return cell.getStringCellValue();
	}
}
	

	public  void takescreenshot(String vString) throws IOException
	{
	    TakesScreenshot ts = ((TakesScreenshot)driver);
	    File source= ts.getScreenshotAs(OutputType.FILE);    
	    File DestFile = new File ("C:\\Users\\00005110\\OneDrive - Arisglobal software pvt Ltd\\Desktop\\Maven Project\\SeleniumFrameWork\\ScreenShots\\" + vString+ ".png");
	    FileUtils.copyFile(source,DestFile);

	}
	
	

}
