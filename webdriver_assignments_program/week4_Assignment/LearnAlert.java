package seleniumweek4.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlert {

	public static void main(String[] args) throws InterruptedException {
		
		
        WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		
		//maximize the window of above url page
		
		driver.manage().window().maximize();
		
		//switch to first frame to access "try it " button element
		
		driver.switchTo().frame(0);
		
		//locating try it button & click on
		
		driver.findElementByXPath("//button[text()='Try it']").click();
		
		Thread.sleep(2000);
		//switch to alret pop up
		Alert prompt=driver.switchTo().alert();
		//enter the input in prompt alert popup
		prompt.sendKeys("suganya");
		
		Thread.sleep(3000);
		//click on ok
		prompt.accept();
		
		Thread.sleep(4000);
		//location visible text present inside frame
		WebElement text=driver.findElementById("demo");
		
		//converting to string
		String visibletext=text.getText();
		
		System.out.println(visibletext);
		
		if(visibletext.contains("suganya"))
		{
			System.out.println("Text entered in alert/prompt pop-up is present");
		}
		else
		{
			System.out.println("Text entered in alert/prompt pop-up is not present");
		}
		
		driver.quit();
	}

}
