package seleniumweek2;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonPage {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		
       /*WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver=new FirefoxDriver();*/
		
		driver.manage().window().maximize();
		driver.get("http://leafground.com/pages/Button.html");
		Thread.sleep(2000);
		
		//get the position of button
	Point position =driver.findElementByXPath("//button[@id='position']").getLocation();
	System.out.println("position of button:"+position);
	//get button background color
	String color =driver.findElementByXPath("//button[@id='color']").getCssValue("background-color");
    System.out.println("color of button:"+color);

    //get height & width
    Dimension size =driver.findElementByXPath("//button[@id='size']").getSize();
    System.out.println("size of button:"+size);
//click on button to navigate to home page

    driver.findElementByXPath("//button[@id='home']").click();
    
    //close the browser
driver.quit();


	}

}
