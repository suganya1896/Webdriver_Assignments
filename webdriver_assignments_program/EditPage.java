package seleniumweek2;

//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditPage {

	public static void main(String[] args) throws InterruptedException {
				
       /*WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver(); */
		
		
       WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Edit.html");
		Thread.sleep(2000);
		//enter email id
		driver.findElementByXPath("//input[@id='email']").sendKeys("abc@gmail.com");
		//append a text
		driver.findElementByXPath("//*[@id=\"contentblock\"]/section/div[2]/div/div/input").sendKeys("abc"+"");
		//get the default text
	String text=driver.findElementByXPath("//input[@name='username']").getAttribute("value");
	System.out.println("default value of text entered:"+text);
	Thread.sleep(2000);
	//clear the text
	driver.findElementByXPath("//*[@id=\'contentblock\']/section/div[4]/div/div/input").clear();
	Thread.sleep(1000);
	
	System.out.println(driver.findElementByXPath("//*[@id=\'contentblock\']/section/div[5]/div/div/input").isEnabled());
	
	driver.quit();
	}

}
