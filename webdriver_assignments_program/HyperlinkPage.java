package seleniumweek2;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperlinkPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		
       /*WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver=new FirefoxDriver();*/
		
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Link.html");
		
		//click on the link to navigate to home page
		WebElement home=driver.findElementByLinkText("Go to Home Page");
		home.click();
		driver.navigate().back();
		//print the page title
		System.out.println("Ttile of page:"+driver.getTitle()); 
		Thread.sleep(2000);
		//print url name without clicking on link by using attribute name
		WebElement url=driver.findElementByLinkText("Find where am supposed to go without clicking me?");
		String attribute=url.getAttribute("href");
		System.out.println("Current page link:" +attribute);
		
		Thread.sleep(2000);
		//print page title of error link
		WebElement errorpage=driver.findElementByLinkText("Verify am I broken?");
		errorpage.click();
		
		System.out.println("Title:"+driver.getTitle());
				Thread.sleep(2000);
		driver.navigate().back();
		
		
		WebElement navigateHome=driver.findElementByXPath("(//a[@link='blue'])[3]");
		String home2=navigateHome.getText();
		//String home1=home.getText();
		if(home2.contains("Home"))
        { 
        	home.click();
        	System.out.println(driver.getTitle());
        }
		else
		{
			System.out.println("mismatch link");
	}
		Thread.sleep(1000);
		driver.quit();

	}

}
