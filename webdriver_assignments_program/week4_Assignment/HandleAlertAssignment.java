package seleniumweek4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlertAssignment {

	public static void main(String[] args) throws InterruptedException {
		
		
		//set up browser
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		//launch the url
		
		driver.get("http://leafground.com/pages/Alert.html");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		//locating the first alert button & click on
		
		driver.findElementByXPath("//button[text()='Alert Box']").click();
		
		//switch to alert window
		
		Alert alert=driver.switchTo().alert();
		
		//print visible text of pop-up	
				String simpleAlert=alert.getText();	
					
				System.out.println(simpleAlert);
				
		//it is simple alert pop-up...click on ok button in alert pop-up
			alert.accept();	
			
		//locating confirm alert button & click on
		
	    driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		driver.switchTo().alert();
				
		//print visible text of pop-up	
				String confirmAlert=alert.getText();	
					
				System.out.println(confirmAlert);
							
		//it is confirm alert pop-up...click on ok button in alert pop-up
					alert.accept();	
			//locating propmpt alert button & click on	
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();	
		
		driver.switchTo().alert();
		
		alert.sendKeys("suganya");
		//its prompt alert & passing input as suganya & click on button
		alert.accept();
		
		String s=driver.findElementByXPath("//p[@id='result1']").getText();
		
		if(s.contains("suganya"))
		{
			System.out.println("text is present");
		}
		else
		{
			System.out.println("text is not present");
		}
					
		//locating line breaks buttton & click on	
		driver.findElementByXPath("//button[text()='Line Breaks?']").click();
		driver.switchTo().alert();
		
		String s1=alert.getText();
		System.out.println(s1);
		
		alert.dismiss();
		
		
		driver.quit();
	}

}
