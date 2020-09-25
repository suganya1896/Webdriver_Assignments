package seleniumweek2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/radio.html");
		Thread.sleep(2000);
		//select any radio button 
		WebElement radioYES=driver.findElementByXPath("//label[@for='yes']/input");
	   radioYES.click();
	   //confirm raddio button option is selected or not
    if(radioYES.isSelected()==true)
      {
	     System.out.println("selected");
      }
    else
     {
	    System.out.println("not selected");
     }
    
    
       WebElement checkeddefault=driver.findElementByXPath("//label[@for='Checked']/input");
       // find the default selected radio button
       String radio=checkeddefault.getText();
       System.out.println("Default text of selected radio button:"+radio);
       boolean a= checkeddefault.isSelected();
 
       System.out.println("selected /not :"+a);
 
  //select your age group
      WebElement age=driver.findElementByXPath("//*[@id=\'contentblock\']/section/div[3]/div/div/input[2]");

       String s=age.getText();
      if(age.isSelected()==false)
     {
	 System.out.println(s);
  	 
     }
     else
    {
	 WebElement ageradio=driver.findElementByXPath("//*[@id=\'contentblock\']/section/div[3]/div/div/input[1]");
	  
	 ageradio.click();
    }
 Thread.sleep(2000);
    driver.quit();
 
	}
}


