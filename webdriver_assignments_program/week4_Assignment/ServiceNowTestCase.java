package seleniumweek4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNowTestCase {

	public static void main(String[] args) throws InterruptedException {
		
		
        WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		//launch the browser
		driver.get("https://dev68594.service-now.com/");
		//maximize the window
		driver.manage().window().maximize();
				
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//login section is present inside iframe .. so first switch to frame to login 
		driver.switchTo().frame(0);
		
		//Enter username as “admin”
		driver.findElementByXPath("//input[@id='user_name']").sendKeys("admin");
		//Enter password as “India@123”
		driver.findElementByXPath("//input[@id='user_password']").sendKeys("India@123");
		//Click on Login
		
		driver.findElementByXPath("//button[text()='Login']").click();
		
		//Search “incident “ in Filter Navigator
		WebElement search=driver.findElementByXPath("//input[@id='filter']");
		search.sendKeys("incident");
		//after entering input ,click on enter button in keyboard
		search.sendKeys(Keys.ENTER);
		//wait for 2sec to load the page
		Thread.sleep(1000);
		//click on "all" option in left sidse of page
		driver.findElementByXPath("(//div[text()='All'])[2]").click();
		
		driver.switchTo().frame(0);
		
		//Click New button
		driver.findElementByXPath("//button[text()='New']").click();
		Thread.sleep(1000);
			
		
		//locating caller field search icon & click on that icon
		
		driver.findElementByXPath("//button[@id='lookup.incident.caller_id']/span").click();
		
		Set<String> setwinId= driver.getWindowHandles();
		
		List<String> listwinId=new ArrayList<String>();
		for (String eachid : setwinId) {
			
			listwinId.add(eachid);
			
		}
		
		//storing child window opened when we clicked on caller field icon
		
		String child=listwinId.get(1);
		
		//storing parent window win reference id
		
		String parent=listwinId.get(0);
		//switching to new opened window		
		driver.switchTo().window(child);
		
		//enter text in search name field 
		
		WebElement searchText=driver.findElementByXPath("//input[@class='form-control']");
		searchText.sendKeys("a");
		searchText.sendKeys(Keys.ENTER);
		
		//selecting 2nd search item from table
		
		driver.findElementByXPath("(//tbody[@class='list2_body']//a)[2]").click();
		
		//switching control back to parent window
		
		driver.switchTo().window(parent);
		
		driver.switchTo().frame(0);
		//entering description of incident in short description field
		
		driver.findElementByXPath("//input[@id='incident.short_description']").sendKeys("unable to login to citrix vdi - Assignment for creating a new incident");
		
		//select contact type from drop down
		//locating dropdown of contact type field
		
		WebElement contacttype=driver.findElementByXPath("//select[@id='incident.contact_type']");
		
		Select option=new Select(contacttype);
		//seelct email from dropdown
		option.selectByIndex(1);
		
		//storing incident no 
		
		String IncidentNo=driver.findElementByXPath("//input[@id='incident.number']").getAttribute("value");
				
		System.out.println("Incident Number:"+IncidentNo);
		
		//Click on Submit button
		
		driver.findElementByXPath("//button[text()='Submit'][1]").click();
		
		Thread.sleep(2000);
			
		//select search type from drop down as "number"
		
		WebElement searchNo=driver.findElementByXPath("//select[@class='form-control default-focus-outline']");
		Select dd2=new Select(searchNo);
		dd2.selectByVisibleText("Number");
		
		//enter incident no in next text field
		
		driver.findElementByXPath("//input[@class='form-control']").sendKeys(IncidentNo,Keys.ENTER);
		
		String FirstRowvalue=driver.findElementByXPath("//tbody[@class='list2_body']//a").getText();
		
		if(IncidentNo.contains(FirstRowvalue))
			
		{
			System.out.println("Incident is created successfully");
		}
		else
		{
			System.out.println("Incident is not created");
		}
		
		
		driver.quit();
		
		
		
	}

}
