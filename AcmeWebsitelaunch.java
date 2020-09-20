package seleniumweek2;

//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.GeckoDriverInfo;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AcmeWebsitelaunch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
        WebDriverManager.firefoxdriver().setup();
		
        FirefoxDriver driver=new FirefoxDriver();
		//ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://acme-test.uipath.com/login");
		Thread.sleep(2000);
		driver.findElementByXPath("//*[@id=\'email\']").sendKeys("kumar.testleaf@gmail.com");;
	    driver.findElementByXPath("//*[@id=\'password\']").sendKeys("leaf@12");;	
	    driver.findElementByXPath("/html/body/div/div[2]/div/div/div/form/button").click();
	    Thread.sleep(2000);
	    System.out.println(driver.getTitle());
	    driver.quit();
	
	
	}

}
