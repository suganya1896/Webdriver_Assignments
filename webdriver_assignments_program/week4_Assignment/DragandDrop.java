package seleniumweek4.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDrop {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		
		//maximize the window of above url page
		
		driver.manage().window().maximize();

		
		Actions builder=new Actions(driver);
		
		//switch to frame 
		
		WebElement myframe = driver.findElementByXPath("//iframe[@class='demo-frame']");
		driver.switchTo().frame(myframe);

        //locating source drag element
		WebElement source=driver.findElementByXPath("//p[text()='Drag me to my target']/parent::div");
		//locating target drop element
		WebElement target=driver.findElementByXPath("//div[@id='droppable']");
		//perform drop & drop
		
		builder.dragAndDrop(source, target).perform();
		
		
		
		
	
	}

}
