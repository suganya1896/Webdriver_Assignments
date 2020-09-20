package seleniumweek2;



import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

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
		
		driver.findElementByLinkText("Leads").click();
		
		driver.findElementByLinkText("Create Lead").click();
		
		driver.findElementById("createLeadForm_companyName").sendKeys("ABC");
		driver.findElementById("createLeadForm_firstName").sendKeys("caroline");
		driver.findElementById("createLeadForm_lastName").sendKeys("kalus");
		
	    WebElement	source= driver.findElementById("createLeadForm_dataSourceId");
		Select dropdownsrc=new Select(source);
		
		dropdownsrc.selectByVisibleText("Employee");
		
		WebElement marketing=driver.findElementById("createLeadForm_marketingCampaignId");
		Select dropdownmark=new Select(marketing);
		
		dropdownmark.selectByValue("9001");
		
		WebElement industry=driver.findElementById("createLeadForm_industryEnumId");
		Select dropdownindust=new Select(industry);
		//to get all options present in drop down
		List<WebElement> options=dropdownindust.getOptions();
		//storing size of dropdown in variable
		int size=options.size();
		
	    dropdownindust.selectByIndex(size-2);
		
	    
	    WebElement ownership=driver.findElementById("createLeadForm_ownershipEnumId");
		Select dropdownowner=new Select(ownership);
		
		dropdownowner.selectByIndex(5);
		
		
		WebElement	country= driver.findElementById("createLeadForm_generalCountryGeoId");
		Select dropdowncountry=new Select(country);
		
		dropdowncountry.selectByVisibleText("India");
		
		
		driver.findElementByName("submitButton").click();
		
		
		System.out.println(driver.getTitle());
		
		driver.quit();
		
	}
	}
