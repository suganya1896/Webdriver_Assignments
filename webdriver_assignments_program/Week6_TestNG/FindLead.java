package testng.week6;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindLead extends LoginAndLogoff {
	
	@BeforeTest
	public void setfilename() {
		
		excelFileName="EditLead";
	}

	@Test(dependsOnMethods = {"testng.week6.CreateLead.createLead"},dataProvider = "Lead")
	
	
	public  void editlead(String name,String modifiedname) throws InterruptedException {
		
       
		//click on leads tab
		driver.findElementByLinkText("Leads").click();
		//click on find leads subtab
		driver.findElementByXPath("(//ul[@class='shortcuts']//a)[3]").click();
		
		System.out.println("find lead page title:"+driver.getTitle());
		// pass input to first name field
		driver.findElementByXPath("(//div[@class='allSubSectionBlocks']//input)[2]").sendKeys(name);
		//click on find leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
			
		Thread.sleep(2000);
		//click on the 1st search result from find lead
		
		driver.findElementByXPath("(//div[@class='x-grid3-scroller']//a)").click();
		
		//click on edit button
		driver.findElementByLinkText("Edit").click();
		//change the company name
		WebElement clearcompanyname=driver.findElementById("updateLeadForm_companyName");
		clearcompanyname.clear();
		clearcompanyname.sendKeys(modifiedname);
		//click on update button
		driver.findElementByXPath("(//div[@class='fieldgroup']//input)[15]").click();
		
		System.out.println("view page:"+driver.getTitle());
		//confirm the page changed as per our value
		WebElement company=driver.findElementByXPath("//span[@id='viewLead_companyName_sp']");
		
		String companyname=company.getText();
		
		if(companyname.contains("test1test2"))
			
		{
			System.out.println("company name matched:"+companyname);
		}
		else
		{
			System.out.println("company name mismatch:"+companyname);
		}
		
		
		
		
	}

	
}
