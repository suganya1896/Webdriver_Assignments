package seleniumweek2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		/*WebDriverManager.iedriver().setup();
		
		InternetExplorerDriver driver=new InternetExplorerDriver(); */
		
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

		//click on email tab under find leads page
		
		driver.findElementByXPath("//span[text()='Email']").click();
		
		//pass email id
		
		driver.findElementByXPath("(//label[text()='Email Address:']/following::input)").sendKeys("abc@gmail.com");
		
		//click on find leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		Thread.sleep(2000);
		
		
		//click on first lead
		WebElement firstLead=driver.findElementByXPath("//table[@class='x-grid3-row-table']//a");
		
		System.out.println("Id of first Lead:"+firstLead.getText());
				
		Thread.sleep(1000);
		firstLead.click();
		
		//capture name of lead selected
		
		WebElement leadname=driver.findElementByXPath("//span[@id='viewLead_firstName_sp']");
		String Lname=leadname.getText();
		//click on duplicate button
		
	   driver.findElementByXPath("//div[@class='frameSectionExtra']/a").click();
	
		String title=driver.getTitle();
		if(title.contains("Duplicate"))
		{
			System.out.println("title matched:"+title);
		}
		else
		{
			System.out.println("Title mismatch:"+title);
		}
		
		//capture firstname of lead in duplicate page
		
		WebElement duplicateLName=driver.findElementByXPath("//input[@id='createLeadForm_firstName']");
		
		String DLname=duplicateLName.getAttribute("value");
		Thread.sleep(1000);
		//click on create lead button
		
		driver.findElementByXPath("//input[@value='Create Lead']").click();
		
		//confirm duplicate name as caputred name 
		
		if(DLname.contains(Lname))
		{
			System.out.println("Captured Duplicate name is matched");
		}
		else
		{
			System.out.println("Captured Duplicate name is not matched");
		}
		driver.quit();
		
	}

}
