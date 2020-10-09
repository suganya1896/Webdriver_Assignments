package seleniumweek4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindowsHandling {

	public static void main(String[] args) throws InterruptedException {
		
		
		 WebDriverManager.chromedriver().setup();
			
			ChromeDriver driver=new ChromeDriver();
			
			driver.get("https://www.irctc.co.in/nget/train-search");
			
			//maximize the window of above url page
			
			driver.manage().window().maximize();
			
			//click on ok in alert pop up
			
			driver.findElementByXPath("//button[text()='Ok']").click();
			
			//click on flights link
			
			driver.findElementByXPath("//a[text()=' FLIGHTS ']").click();
					// "(//div[@class='h_main_div']/div[2]//li)[32]/a").click();
			
			// get all opened window reference id & store it in set
			Set<String> allWinRefSet=driver.getWindowHandles();
			// copy values of set to list
			List<String> allWinRefList=new ArrayList<String>(allWinRefSet);
			
			for (String eachWinRef : allWinRefSet) {
			//add values from set to list	
				allWinRefList.add(eachWinRef);
			}
			//stroing first window(main page) reference id 
			String firstWinRef=allWinRefList.get(0);
			//stroing second window reference id 
			String secondWinRef=allWinRefList.get(1);
			//switch control from main window to second window
			driver.switchTo().window(secondWinRef);
			//print the title of second window
			String secondWinTitle=driver.getTitle();
			System.out.println("Title of the second window: "+secondWinTitle);
			//close the second window
			driver.close();
			//switch control to main window(first one) from second
			driver.switchTo().window(firstWinRef);
			//printing the title of main page
			String title=driver.getTitle();
			System.out.println("Title of main page:"+title);
			
			Thread.sleep(2000);
			
			driver.close();
			
			
			
	}

}
