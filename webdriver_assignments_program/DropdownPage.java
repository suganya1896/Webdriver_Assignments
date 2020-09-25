package seleniumweek2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Dropdown.html");
		Thread.sleep(2000);
		//select appium using index
		WebElement TPIndex =driver.findElementById("dropdown1");
		
		Select ddindex= new Select(TPIndex);
		ddindex.selectByIndex(2);
		//System.out.println(TPIndex.isSelected());
		
		Thread.sleep(2000);
		//select load runner using visibletext
		
     WebElement TPText =driver.findElementByName("dropdown2");
		
		Select ddtext= new Select(TPText);
		ddtext.selectByVisibleText("Loadrunner");
		//System.out.println(TPText.isSelected());
		
		Thread.sleep(2000);
		//select selenium using value 
		
		WebElement TPValue=driver.findElementById("dropdown3");
		Select ddvalue=new Select(TPValue);
		
		ddvalue.selectByValue("1");
		
		//System.out.println(TPValue.isSelected());
		
		//get the no of options in dropdown
		WebElement TPSize=driver.findElementByClassName("dropdown");
		Select ddsize=new Select(TPSize);
		
		List<WebElement> options=ddsize.getOptions();
		
		int size=options.size();
	    System.out.println(size);
	
	    //select uft/qtp using sendkeys
	driver.findElementByXPath("(//section[@class='innerblock']//select)[5]").sendKeys("UFT/QTP");
	//select all options at a time
	WebElement  multiselect=driver.findElementByXPath("(//section[@class='innerblock']//select)[6]");
	Select ddmultiple=new Select(multiselect);
	
	List<WebElement> options1=ddmultiple.getOptions();
	
	int size1=options1.size();

	for(int i=0;i<size1;i++)
	{
		ddmultiple.selectByIndex(i);
	}
	
	
	driver.quit();
	}

}
