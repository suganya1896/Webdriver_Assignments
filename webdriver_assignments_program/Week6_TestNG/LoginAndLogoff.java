package testng.week6;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginAndLogoff {
	
	public  ChromeDriver driver;
	
	//declaring global variable excelfilename to use it in different testcase
	
	public String excelFileName;
	
	//getting login credentials from xml file using parameter tag
   @Parameters({"username","password","url"})
	@BeforeMethod
	//passing parameters as argument to login function
	public void login(String name,String PW,String url) throws InterruptedException
	{
	
	WebDriverManager.chromedriver().setup();
	
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElementById("username").sendKeys(name);
	driver.findElementById("password").sendKeys(PW);
	driver.findElementByClassName("decorativeSubmit").click();
	System.out.println("login successful");
	driver.findElementByLinkText("CRM/SFA").click();
	
	
	}
	@AfterMethod
	public void logOff()
	{
		driver.close();
	
	}
	
	@DataProvider(name="Lead")
	public String[][] getData() throws IOException
	{
		ReadDataFromExcel readData=new ReadDataFromExcel();
		String[][] data=readData.readExcel(excelFileName);
		
		return data;
		
	}

}
