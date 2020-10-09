package seleniumweek4.day1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortUsingMouse {

	public static void main(String[] args) throws InterruptedException {
		
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://jqueryui.com/sortable/");
		
		//maximize the window of above url page
		
		driver.manage().window().maximize();
		
		//scroll down page	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		//switch to frame 
		driver.switchTo().frame(0);
		
		//locating 1st item
		
		WebElement Item1=driver.findElementByXPath("//ul[@id='sortable']/li[1]");
		
		Actions builder=new Actions(driver);
		
		builder.clickAndHold(Item1).perform();
		
		//locating 4th element by getting location
		
		WebElement Item4=driver.findElementByXPath("//ul[@class='ui-sortable']/li[4]");
		
		int x =Item4.getLocation().getX();
		int y =Item4.getLocation().getY();
				
		builder.dragAndDropBy(Item1, x, y).perform();
		
		Thread.sleep(2000);
		
		driver.quit();


	}

}
