package seleniumweek2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImagePage {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		//launch the URL
		driver.navigate().to(" http://leafground.com/pages/Image.html");
		 driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //click on the imaage to navigate to home  page
		WebElement image=driver.findElementByXPath("(//section[@class='innerblock']//img)[1]");
		
		image.click();
		
		driver.navigate().back();
		//get the visible text
		WebElement brokeimg=driver.findElementByXPath("(//section[@class='innerblock']//label)[2]");
		String broken=brokeimg.getText();
		
		System.out.println("Image of text:" +broken);
		
		//click on img link using keyboard/mouse
		WebElement mouseclick=driver.findElementByXPath("(//section[@class='innerblock']//img)[3]");

        Actions builder = new Actions(driver);
        builder.click(mouseclick);       
		Thread.sleep(2000);
		driver.quit();
	}

}
