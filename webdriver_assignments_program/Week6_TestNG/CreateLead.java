package testng.week6;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CreateLead extends LoginAndLogoff{
	
	@BeforeTest
	public void setFilename() {
		excelFileName="Createlead";
	}
	
	@Test(dataProvider = "Lead")
	public void createLead(String firstname,String LastName,String company,String AreaCode,String phone,String email) throws InterruptedException {
				
		driver.findElementByLinkText("Leads").click();
		
		driver.findElementByLinkText("Create Lead").click();
		
		driver.findElementById("createLeadForm_companyName").sendKeys(company);
		driver.findElementById("createLeadForm_firstName").sendKeys(firstname);
		driver.findElementById("createLeadForm_lastName").sendKeys(LastName);
		
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
		//add phonenumber,area code
		driver.findElementById("createLeadForm_primaryPhoneAreaCode").sendKeys(AreaCode);
		driver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys(phone);
		
		//add email
		
		driver.findElementById("createLeadForm_primaryEmail").sendKeys(email); 
		//click on submit button to create new lead
		driver.findElementByName("submitButton").click();
		
		
		System.out.println(driver.getTitle());
		
		
		
	}
	}
