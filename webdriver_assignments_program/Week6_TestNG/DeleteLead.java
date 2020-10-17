package testng.week6;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DeleteLead extends LoginAndLogoff{
	
	@BeforeTest
	public void setFilename() {
		excelFileName="Deletelead";
	}
	
	@Test(dataProvider = "Lead",dependsOnMethods = "testng.week6.CreateLead.createLead")
	
	public  void deleteLead(String area,String Phone) throws InterruptedException {
	
				//click on leads tab
				driver.findElementByLinkText("Leads").click();
				//click on find leads subtab
				driver.findElementByXPath("(//ul[@class='shortcuts']//a)[3]").click();
				
				System.out.println("find lead page title:"+driver.getTitle());
				
				//click on phone tab under find leads page
				
				driver.findElementByXPath("//span[text()='Phone']").click();
				
				//pass area code
				
				driver.findElementByXPath("//input[@id='ext-gen266']").sendKeys(area);
				//pass phone number
				driver.findElementByXPath("//input[@id='ext-gen270']").sendKeys(Phone);
				
				
				//click on find leads button
				driver.findElementByXPath("//button[text()='Find Leads']").click();
				
				Thread.sleep(1000);
				//click on find lead from search result
				
				WebElement lead=driver.findElementByXPath("(//div[@class='x-grid3-scroller']//a)");
				System.out.println("Id of first lead :"+lead.getText());
				String firstlead=lead.getText();
				
				lead.click();
				//click on delete button
				driver.findElementByXPath("//a[text()='Delete']").click();
				
				
				//click on find leads subtab
				driver.findElementByXPath("(//ul[@class='shortcuts']//a)[3]").click();
				// pass deleted lead id
				driver.findElementByXPath("(//label[text()='Lead ID:']/following::input)").sendKeys(firstlead);
				
				//click on find leads button
				driver.findElementByXPath("//button[text()='Find Leads']").click();
				
				Thread.sleep(2000);
				
				System.out.println(driver.findElementByXPath("//*[@id='ext-gen437']").getText());
				
				
	
	}

}
