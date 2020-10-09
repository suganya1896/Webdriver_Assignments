package seleniumweek4.day1;



import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectItemsByMouse {

	public static void main(String[] args) {
		
		    WebDriverManager.chromedriver().setup();
			
			ChromeDriver driver=new ChromeDriver();
			
			driver.get("https://jqueryui.com/selectable/");
			
			//maximize the window of above url page
			
			driver.manage().window().maximize();
			//to perform Scroll on application using  Selenium
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			
			Actions builder=new Actions(driver);
							
			driver.switchTo().frame(0);
			//using for loop
			List<WebElement> listItems=driver.findElementsByXPath("//ol[@class='ui-selectable']/li");
			
			int Lsize=listItems.size();
			System.out.println("list of elements:"+Lsize);
			for(int i=1;i<=Lsize;i=i+2)
			{
				WebElement Items=driver.findElementByXPath("//ol[@class='ui-selectable']/li["+i+"]");
				
				builder.keyDown(Keys.CONTROL).click(Items).perform();
				
			}
			builder.keyDown(Keys.CONTROL).perform();
			//approach2

			/*WebElement L1=driver.findElementByXPath("//ol[@class='ui-selectable']/li[1]");

			WebElement L3=driver.findElementByXPath("//ol[@class='ui-selectable']/li[3]");
			
			WebElement L5=driver.findElementByXPath("//ol[@class='ui-selectable']/li[5]");
			

			WebElement L7=driver.findElementByXPath("//ol[@class='ui-selectable']/li[7]");
			
			//click on 1st item & press control in keyboard & select item3,item5,item7 &realese the control from keyborad 
			builder.keyDown(Keys.CONTROL).click(L1).click(L3).click(L5).click(L7).keyUp(Keys.CONTROL).perform();
			
			*/
			driver.close();
	}

}
