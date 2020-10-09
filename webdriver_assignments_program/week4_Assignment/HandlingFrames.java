package seleniumweek4.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingFrames {

	public static void main(String[] args) throws InterruptedException {
		
				//set up browser
		
				WebDriverManager.chromedriver().setup();
				
				ChromeDriver driver=new ChromeDriver();
				
				//launch the url
				
				driver.get("http://leafground.com/pages/frame.html");
				
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				//switch to frame 1
				driver.switchTo().frame(0);
				
				WebElement first=driver.findElementByXPath("//button[text()='Click Me']");
				first.click();
				String frame1=first.getText();
				System.out.println("after clicking frame1 button:"+frame1);
				//come out from frame1
				
				driver.switchTo().defaultContent();
				
				//switch to frame 2
				driver.switchTo().frame(1);
				
				WebElement frame=driver.findElementByXPath("//iframe[@id='frame2']");
				//switch to nested frame
				driver.switchTo().frame(frame);
				
				WebElement frame2=driver.findElementByXPath("//button[text()='Click Me']");
				frame2.click();
				String f2=frame2.getText();
				
				System.out.println("after clicking button inside nested frame:"+f2);
				
				Thread.sleep(3000);
				//come out from nested frame
				driver.switchTo().defaultContent();
				
				//to print no frames in a page
				
				
				
				List<WebElement> framescount=driver.findElementsByTagName("iframe");
				//storing size of frame tag (no of iframe tags) in a page .this will store only visible frames (outer frames)& will not count nested frames(child frames)
				int size=framescount.size();
				int count=0;
				
				for(int i=0;i<size;i++)
				{
					//here i am getting into first parent frame in dom
					driver.switchTo().frame(i);
					//checking whether any frame present inside parent frame & adding count of nested frame
					count+=driver.findElementsByTagName("iframe").size();
					//here coming out from all frames
					driver.switchTo().defaultContent();
				}
					
				int total=count+size;
				System.out.println("total no of frames including nested frames in page:"+total);
                System.out.println("No of outer frames:"+size);
				
				driver.switchTo().defaultContent();
				
				driver.quit();
				
				
				
	}

}
