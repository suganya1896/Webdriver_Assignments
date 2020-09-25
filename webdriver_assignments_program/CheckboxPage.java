package seleniumweek2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/checkbox.html");
		Thread.sleep(2000);
		//to select java
	WebElement language=driver.findElementByXPath("//section[@class='innerblock']//input[1]");
	language.click();
	String langvisible=language.getText();
	System.out.println(langvisible);//visible text of selected option is not displaying in console window
	
	//to select sql	
	WebElement language1=driver.findElementByXPath("(//section[@class='innerblock']//input)[3]");
	language1.click();
	System.out.println(language1.getText());
	//to select c++
	WebElement language2=driver.findElementByXPath("(//section[@class='innerblock']//input)[5]");
	language2.click();
	
	System.out.println(language2.getText());
	
	
	//to confirm selenium is selected or not 
	
	WebElement sel=driver.findElementByXPath("(//section[@class='innerblock']//input)[6]");
	
	Boolean confirm=sel.isSelected();
	if(confirm==true)
	{
	System.out.println("selenium checkbox is selected:"+confirm);
	}
	else
	{
		System.out.println("selenium checkbox is selected:"+confirm);
	}
	
	//deselect selcted check box
	
	WebElement deselect=driver.findElementByXPath("(//section[@class='innerblock']//input)[8]");
	Boolean uncheck=deselect.isSelected();
	if(uncheck==true)
	{
	deselect.click();
	System.out.println("element is unchecked:"+deselect.isSelected());
	}
	//selecting all the option of checkbox 
for (int i = 1; i <= 5; i++) {
			
		
		driver.findElementByXPath("(//label[text()='Select all below checkboxes ']/following::input)["+i+"]").click();
		}
		 
	
	Thread.sleep(2000);
	
			
	driver.quit();
	}
	
	}


