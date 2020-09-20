package seleniumweek2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		Thread.sleep(1000);
		System.out.println("login successful");
		
		System.out.println(driver.getTitle());
		
		driver.findElementByLinkText("CRM/SFA").click();
		

		System.out.println(driver.getTitle());
		
		driver.findElementByLinkText("Accounts").click();
		driver.findElementByLinkText("Create Account").click();
		
		driver.findElementByXPath("//*[@id=\'accountName\']").sendKeys("Debit Limited Account");
        driver.findElementByXPath("//*[@name='description']").sendKeys("Selenium Automation Tester");
	    driver.findElementByXPath("//*[@id=\'groupNameLocal\']").sendKeys("xyz");
	    driver.findElementByXPath("//*[@id=\'officeSiteName\']").sendKeys("create account site");
	    driver.findElementByXPath("//*[@id=\'annualRevenue\']").sendKeys("45k");
	    
	    WebElement industry=driver.findElementByName("industryEnumId");
	    
	    Select dropdownIns=new Select(industry);
	    
	    dropdownIns.selectByIndex(3);
	    
      WebElement ownership=driver.findElementByName("ownershipEnumId");
	    
	    Select dropdownowner=new Select(ownership);
	    
	    dropdownowner.selectByVisibleText("S-Corporation");
	    
	    WebElement source=driver.findElementById("dataSourceId");
	    
	    Select dropdownsrc=new Select(source);
	    
	    dropdownsrc.selectByValue("LEAD_EMPLOYEE");
	    
	    WebElement marketing=driver.findElementById("marketingCampaignId");
	    
	    Select dropdownmark=new Select(marketing);
	    
	    dropdownmark.selectByIndex(6);
	    
     WebElement state=driver.findElementById("generalStateProvinceGeoId");
	    
	    Select dropdownstate=new Select(state);
	    
	    dropdownstate.selectByValue("TX");
	    
	driver.findElementByXPath("//*[@class=\"smallSubmit\"]").click();
	
	Thread.sleep(4000);
	
	System.out.println(driver.getTitle());
		driver.quit();
	}
	

}
