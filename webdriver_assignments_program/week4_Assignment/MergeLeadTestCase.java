package seleniumweek4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLeadTestCase {

	public static void main(String[] args) throws InterruptedException {
		
		
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		
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
		
		//click on merge lead sub tab
		driver.findElementByLinkText("Merge Leads").click();
		 //Click on Icon near From Lead
		driver.findElementByXPath("//table[@name='ComboBox_partyIdFrom']/following-sibling::a").click();
		
		Set<String> set=driver.getWindowHandles();
		
		List<String> list=new ArrayList<String>(set);
		
		
		for (String eachvalue : set) {
			list.add(eachvalue);
		}
			
		String mainwinref=list.get(0);	
		String openedWinRef=list.get(1);
		
		System.out.println("child window of from lead:"+openedWinRef);
		//switch to new opened window upon clicking from lead
		driver.switchTo().window(openedWinRef);
		// enter lead id 
		WebElement fromleadId=driver.findElementByXPath("//div[@class='x-form-element']/input");
		fromleadId.sendKeys("10200");
		
		//Click Find Leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		Thread.sleep(3000);
		
		String fromleadText=driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").getText();
		System.out.println(fromleadText);
		
		//Click First Resulting lead
		driver.findElementByXPath("//div[@class='x-grid3-body']//a").click();
		
		//Switch back to primary window
		
		driver.switchTo().window(mainwinref);
		
		
		//Click on Icon near To Lead
		
		driver.findElementByXPath("//table[@id='widget_ComboBox_partyIdTo']/following-sibling::a").click();
		
		Thread.sleep(2000);
     
		Set<String> win2ref=driver.getWindowHandles();
		
		List<String> list2=new ArrayList<String>(win2ref);
		
		for (String eachval2 : win2ref) {
			list2.add(eachval2);
			
		}
		//parent window
		String w1=list2.get(0);
		//child window
		String w2=list2.get(1);
		//switching to child window
		driver.switchTo().window(w2);
		Thread.sleep(1000);
		//enter lead id			
		driver.findElementByXPath("//label[text()='Lead ID:']/following::input").sendKeys("10201");
		//click on find leads button
				
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		Thread.sleep(2000);
		//click on first resulting lead id from table
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		//switching control to parent window
		driver.switchTo().window(w1);
		//click on merge button
		driver.findElementByXPath("//a[text()='Merge']").click();;
		//switch to alert window popup
		Alert popup=driver.switchTo().alert();
		//click on ok in alert pop-up
		popup.accept();
		
		//click on find leads
		driver.findElementByLinkText("Find Leads").click();
		//enter from lead id
		driver.findElementByXPath("//input[@name='id']").sendKeys(fromleadText);
		//click on find leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		//conforming no records to display text
		System.out.println(driver.findElementByXPath("//*[@id='ext-gen437']").getText());
		/*//locating text of footer table
		String s=driver.findElementByXPath("//div[@class='x-paging-info']").getText();
		
		if(s.equalsIgnoreCase("No records"))
			
		{
			System.out.println("lead is not present");
		}
		else
		{
			System.out.println("lead is present");
		}
		*/
		driver.quit();
	}

}
