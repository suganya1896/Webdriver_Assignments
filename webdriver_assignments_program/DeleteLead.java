package seleniumweek2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		
		        WebDriverManager.chromedriver().setup();
				
				ChromeDriver driver=new ChromeDriver();
				
				/*WebDriverManager.iedriver().setup();
				
				InternetExplorerDriver driver=new InternetExplorerDriver(); */
				//launch the url page
				driver.get("http://leaftaps.com/opentaps/control/main");
				//maximize the browser window
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
				
				//click on phone tab under find leads page
				
				driver.findElementByXPath("//span[text()='Phone']").click();
				
				//pass area code
				
				driver.findElementByXPath("//input[@id='ext-gen266']").sendKeys("91");
				//pass phone number
				driver.findElementByXPath("//input[@id='ext-gen270']").sendKeys("1234567890");
				
				
				//click on find leads button
				driver.findElementByXPath("//button[text()='Find Leads']").click();
				
				Thread.sleep(3000);
				//click on find lead from search result
				
				WebElement lead=driver.findElementByXPath("(//div[@class='x-grid3-scroller']//a)");
				System.out.println("Id of first lead :"+lead.getText());
				String firstlead=lead.getText();
				lead.click();
				//click on delete button
				driver.findElementByXPath("//a[text()='Delete']").click();
				
				/*driver.findElementByXPath("//div[@class='x-plain-bwrap']").sendKeys(firstId);
				
				driver.findElementByXPath("//button[text()='Search']").click();*/
				
				//click on find leads subtab
				driver.findElementByXPath("(//ul[@class='shortcuts']//a)[3]").click();
				//how can pass deleted lead id
				driver.findElementByXPath("(//label[text()='Lead ID:']/following::input)").sendKeys(firstlead);
				
				//click on find leads button
				driver.findElementByXPath("//button[text()='Find Leads']").click();
				
				Thread.sleep(2000);
				
				System.out.println(driver.findElementByXPath("//*[@id='ext-gen437']").getText());
				
				driver.close();
				
	
	}

}
