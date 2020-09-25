package seleniumweek2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindLead {

	public static void main(String[] args) throws InterruptedException {
		
        WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		/*WebDriverManager.iedriver().setup();
		
		InternetExplorerDriver driver=new InternetExplorerDriver(); */
	
		//launch the browser
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//login 
		driver.findElementByXPath("//input[@id='username']").sendKeys("demosalesmanager");
		driver.findElementByXPath("//input[@id='password']").sendKeys("crmsfa");
		driver.findElementByXPath("//input[@class='decorativeSubmit']").click();
		
        System.out.println(driver.getTitle());
		//click on crm/sfa link
		driver.findElementByLinkText("CRM/SFA").click();
		

		System.out.println(driver.getTitle());
		//click on leads tab
		driver.findElementByLinkText("Leads").click();
		//click on find leads subtab
		driver.findElementByXPath("(//ul[@class='shortcuts']//a)[3]").click();
		
		System.out.println("find lead page title:"+driver.getTitle());
		// pass input to first name field
		driver.findElementByXPath("(//div[@class='allSubSectionBlocks']//input)[2]").sendKeys("caroline2");
		//click on find leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
			
		Thread.sleep(4000);
		//click on the 1st search result from find lead
		
		driver.findElementByXPath("(//div[@class='x-grid3-scroller']//a)").click();
		//verify the title of page
		String title=driver.getTitle();
		
		if(title.contains("view"))
		{
			System.out.println("Title matched:"+title);
		}
		else
		{
			System.out.println("title mismatch:"+title);
			
		}
		//click on edit button
		driver.findElementByLinkText("Edit").click();
		//change the company name
		WebElement clearcompanyname=driver.findElementById("updateLeadForm_companyName");
		clearcompanyname.clear();
		clearcompanyname.sendKeys("test1");
		//click on update button
		driver.findElementByXPath("(//div[@class='fieldgroup']//input)[15]").click();
		
		System.out.println("view page:"+driver.getTitle());
		//confirm the page changed as per our value
		WebElement company=driver.findElementByXPath("//span[@id='viewLead_companyName_sp']");
		
		String companyname=company.getText();
		
		if(companyname.contains("test1"))
			
		{
			System.out.println("name matched:"+companyname);
		}
		else
		{
			System.out.println("name mismatch:"+companyname);
		}
		
		
		driver.quit();
		
		
	}

	
}
