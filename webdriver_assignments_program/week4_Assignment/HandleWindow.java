package seleniumweek4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWindow {

	public static void main(String[] args) throws InterruptedException {
		
		//set up browser
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		//launch the url
		
		driver.get("http://leafground.com/pages/Window.html");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//click on "open to home page" button to launch window
		
		WebElement homepage=driver.findElementByXPath("//button[text()='Open Home Page']");
		
		homepage.click();
		
		
		//clicking on Open Multiple Windows button
		WebElement multiplewindow=driver.findElementByXPath("//button[text()='Open Multiple Windows']");
		
		multiplewindow.click();
		
		//click on "do not close me " button
		driver.findElementByXPath("//button[text()='Do not close me ']").click();
		
		Thread.sleep(5000);
		
		//to get all opened window reference id using getWindowHandles()
		
				Set<String> allopenwinRef=driver.getWindowHandles();
						
		//copying values of set to list
				List<String> winRefList=new ArrayList<String>(allopenwinRef);
				
				for (String eachvalue : allopenwinRef) {
					//adding all opened window reference Id 
					winRefList.add(eachvalue);
					
				}
		System.out.println(winRefList);
				//storing no of opened windows in object using size()
				int countofwindows=winRefList.size();
				//printing count of opened windows
				System.out.println("No of opened windows:"+countofwindows);
					
		
		
		//storing reference id of home page (main window)  
		String firstwinref=winRefList.get(0);
		//storing reference id of second window opened when we click on "open home page" button
		String secwinRef=winRefList.get(1);
		//storing reference id of 3rd window opened when we click on "open multiple windows" button
		String thirdwinRef=winRefList.get(2);
		//storing reference id of 4th window opened when we click on "open multiple windows" button
		String fourthwinRef=winRefList.get(3);
		//storing reference id of 5th window opened when we click on "do not close me" button
		String fifthwinRef=winRefList.get(4);
		
		//storing reference id of 6th window opened when we click on "do not close me" button
		String sixthwinRef=winRefList.get(5);
		
		
		//switching control to 2nd window to close it
		
		driver.switchTo().window(secwinRef);
		
		String title1=driver.getTitle();
		System.out.println("Title of second opened window when we click 1st button"+title1);
		driver.close();
		
		//switching control to 3rd window to close it
		
		driver.switchTo().window(thirdwinRef);
		
		String title2=driver.getTitle();
		System.out.println("Title of third opened window when we click 2nd button  "+title2);
		driver.close();
		
        //switching control to 4th window to close it
		
		driver.switchTo().window(fourthwinRef);
		String title3=driver.getTitle();
		System.out.println("Title of third opened window when we click 2nd button  "+title3);

		driver.close();
		
		//switching control to 5th window to close it
		
		driver.switchTo().window(fifthwinRef);
		
		String title4=driver.getTitle();
		System.out.println("Title of third opened window when we click 3rd button  "+title4);

		driver.close();
		
		//switching control to 6th window to close it
		
			driver.switchTo().window(sixthwinRef);
			
			String title5=driver.getTitle();
			System.out.println("Title of third opened window when we click 3rd button  "+title5);

			driver.close();
			
		//switching control back to main window(home page)
		driver.switchTo().window(firstwinref);
		
		Thread.sleep(2000);
		//click on last button in main page
		
		driver.findElementByXPath("//button[text()='Wait for 5 seconds']").click();
		//wait for 5 secs to open new windws
		Thread.sleep(5000);
		
		
		driver.quit();

	}

}
