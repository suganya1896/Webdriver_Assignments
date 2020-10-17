package testng.week6;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DuplicateLead extends LoginAndLogoff{
	
	@BeforeTest
	public void setFileName()
	{
		excelFileName="DuplicateLead";
		
	}
					
	@Test(dataProvider = "Lead")
	public  void duplicateLead(String email) throws InterruptedException {
		
		//click on leads tab
		driver.findElementByLinkText("Leads").click();
		//click on find leads subtab
		driver.findElementByXPath("(//ul[@class='shortcuts']//a)[3]").click();
		
		System.out.println("find lead page title:"+driver.getTitle());

		//click on email tab under find leads page
		
		driver.findElementByXPath("//span[text()='Email']").click();
		
		//pass email id
		
		driver.findElementByXPath("(//label[text()='Email Address:']/following::input)").sendKeys(email);
		
		//click on find leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		Thread.sleep(1000);
		
		
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
		
		
	}

}
