package seleniumweek4.day1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWebTable {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://erail.in/");
		
		//maxime window
		
		driver.manage().window().maximize();
		//Click the 'sort on date' checkbox
		driver.findElementByXPath("//input[@id='chkSelectDateOnly']").click();
		
	
		WebElement fromstation=driver.findElementByXPath("//input[@id='txtStationFrom']");
		//clear the existing text from station text field
		fromstation.clear();
		
		//type "ms"in the from station text field
		
		fromstation.sendKeys("ms");
		
		//tab in the from station text field to select first element from list
		
		fromstation.sendKeys(Keys.TAB);
		
		//clear the existing text in the to station text field
		
		
		WebElement Tostation=driver.findElementById("txtStationTo");
		Tostation.clear();
		
		//type "mdu" in the to station text field
		
		Tostation.sendKeys("mdu");
		//keys.tab will  select first element from search result of sorted value in To place field
		Tostation.sendKeys(Keys.TAB);
		
		Thread.sleep(2000);
		//locating all row from resluts in table
		List<WebElement> tableRow=driver.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr");
		
		int row=tableRow.size();
		
		//create empty list to add train names to list
		
		List<String> listTrainnames=new ArrayList<String>();
		
		for(int i = 1; i <=row; i++)
		{
			//to traverse through each cell of train names column
			String cellname=driver.findElementByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]").getText();
		System.out.println(cellname);
		listTrainnames.add(cellname);
		
		}
		
		//create a empty set to transfer train names to set
		
		Set<String> setTrainNames =new LinkedHashSet<String>(listTrainnames);
		//store list size
		int listSize=listTrainnames.size();
		
		//store set size
		
		int setSize=setTrainNames.size();
		
		if(listSize==setSize)
		{
			System.out.println("train names are unique");
		}else {
				System.out.println("Train names are duplicate");
		}
		driver.close();
		
		
		
		
		
	}

}
