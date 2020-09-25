package seleniumweek2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LunchApplication {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		
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
		
		WebElement	country= driver.findElementById("createLeadForm_generalCountryGeoId");
		Select dropdowncountry=new Select(country);
		
		dropdowncountry.selectByVisibleText("India");
		
		WebElement industry=driver.findElementById("createLeadForm_marketingCampaignId");
		Select dropdownindust=new Select(industry);
		//to get all options present in drop down
		List<WebElement> options=dropdownindust.getOptions();
		//storing size of dropdown in variable
		int size=options.size();
		
	    dropdownindust.selectByIndex(size-2);

	}

}

