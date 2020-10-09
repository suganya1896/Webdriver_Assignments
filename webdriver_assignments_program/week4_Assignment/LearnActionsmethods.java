package seleniumweek4.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnActionsmethods {

	public static void main(String[] args) throws InterruptedException {
		
        WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.snapdeal.com/");
		
		//maximize the window of above url page
		
		driver.manage().window().maximize();
		//locating men's fashions element
		WebElement menFasion=driver.findElementByXPath("//li[@class='navlink lnHeight']//span");
		
		Actions builder=new Actions(driver);
		//mouse hover on men's fashion 
		builder.moveToElement(menFasion).perform();
		Thread.sleep(2000);
		
		//locating shirts element
	
		WebElement shirt=driver.findElementByXPath("(//div[@id='category6Data']/div[2]//a)[3]");
			
		//mouse hover & click on shirts element
		builder.moveToElement(shirt).click().perform();
				
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
		//locating first product
	
		WebElement firstProduct=driver.findElementByXPath("//div[@id='products']/section//picture");
		
		//mouse hover the first seach result 
		builder.moveToElement(firstProduct).perform();
		
		Thread.sleep(2000);
		
		WebElement quickView=driver.findElementByXPath("//div[@class='clearfix row-disc']");
		//click on quick view of first product
		
		builder.moveToElement(quickView).click().perform();
		
		Thread.sleep(4000);
		//System.out.println(driver.findElementByXPath("//div[@class='quickViewHead']").getText());
		
		
		driver.quit();
	}

}
