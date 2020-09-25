package seleniumweek2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadXpath {

	public static void main(String[] args) throws InterruptedException {
		
//WebDriverManager.firefoxdriver().setup();
		
        //FirefoxDriver driver=new FirefoxDriver();
		
				WebDriverManager.chromedriver().setup();
				
				ChromeDriver driver=new ChromeDriver(); 
				
				driver.manage().window().maximize();
				driver.get("http://leaftaps.com/opentaps/control/login");
				
				driver.findElementByXPath("//input[@id='username']").sendKeys("demosalesmanager");;
				driver.findElementByXPath("(//input[@class='inputLogin'])[2]").sendKeys("crmsfa");;
				driver.findElementByXPath("//input[@class='decorativeSubmit' and @value='Login']").click();;
				
				Thread.sleep(1000);
				System.out.println("login successful");
				
				System.out.println(driver.getTitle());
				driver.findElementByXPath("//a[contains(text(),'CRM')]").click();
				

				System.out.println(driver.getTitle());
				
				driver.findElementByXPath("(//ul[@class='sectionTabBar']//a)[2]").click();
				driver.findElementByXPath("(//div[@class='frameSectionBody']//a)[2]").click();
				
				driver.findElementById("createLeadForm_companyName").sendKeys("ABC");
				driver.findElementById("createLeadForm_firstName").sendKeys("caroline");
				driver.findElementById("createLeadForm_lastName").sendKeys("kalus");
				
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
				
				
				driver.findElementByXPath("//input[contains(@class,'smallSubmit')]").click();
				
				
				System.out.println(driver.getTitle());
				
				driver.quit();
				
			}
			}

