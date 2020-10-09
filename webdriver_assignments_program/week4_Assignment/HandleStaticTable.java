package seleniumweek4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleStaticTable {

	public static void main(String[] args) throws InterruptedException {
		
		 WebDriverManager.chromedriver().setup();
			
			ChromeDriver driver=new ChromeDriver();
			
			driver.get("http://leafground.com/pages/table.html");
			
			//maximize the window of above url page
			
			driver.manage().window().maximize();
	
			//print  count of no of rows
			List<WebElement> rows=driver.findElementsByXPath("//table[@id='table_id']//tr");
			
			int rowsCount=rows.size();
			System.out.println("No of rows in a table:"+rowsCount);
			//print count of no of columns
			List<WebElement> column=driver.findElementsByXPath("//table[@id='table_id']//th");
			
			int columnCount=column.size();
			
			System.out.println("No of Columns in a table:"+columnCount);
			
			
			for(int i=3,k = 2; i <rowsCount; i++)
				
			{	
					
				WebElement s=driver.findElementByXPath("(//table[@id='table_id']//tr["+i+"])/td["+k+"]");
				System.out.println("Progress  value of 2nd row: "+s.getText());
				break;
				
			
			}
	//locating table
			WebElement table=driver.findElementByXPath("//table[@id='table_id']");
			//storing all tr tags count
			List<WebElement> rowscount=table.findElements(By.tagName("tr"));
			
			int rowsSize=rowscount.size();
			System.out.println("no of rows:"+rowsSize);
			//storing all td tags count
			List<WebElement> columncount=table.findElements(By.tagName("td"));
			
			int columnsize=columncount.size();
				
			System.out.println("no of data in column:"+columnsize);
			//creating string array list to store all progress values into list
			List<String> allvalues=new ArrayList<String>();
			
			for(int i=2; i<=rowsSize; i++)
			{
									
					WebElement elements=driver.findElementByXPath("(//table[@id='table_id']/tbody/tr["+i+"])/td[2]");
					//removing special character (replaceAll("\d","")
					String s=elements.getText().replaceAll("%", "");								
					//adding values to list
					allvalues.add(s);
				
			}
			//priting list values
			System.out.println("List values as String:"+allvalues);
			//converrting string list to integer list
			List<Integer> listInteger = allvalues.stream().map(Integer::parseInt)
			         .collect(Collectors.toList());	
			//printing integer list
			System.out.println("list values as Integer after converting:"+listInteger);
			//sorting list
			Collections.sort(listInteger);
			//storing & getting min value from list
			Integer minvalue=Collections.min(listInteger);
			//printing minimum value from list
			System.out.println("Minimun value of progress column:"+minvalue);
			//clicking on the check box of least progress value
			
			driver.findElementByXPath("//td[contains(text(),'"+minvalue+"')]/following-sibling::td/input").click();
			
			
			
			//approach 2
			//storing all progress column values 
			List<WebElement> rowsvalues =driver.findElementsByXPath("//table//tr/td[2]");
			//creating empty integer list which will hold the all progress values in interger format 
			List<Integer> list1=new ArrayList<Integer>();
			
			for (WebElement eachvalue : rowsvalues) {
				//getting visible text of each progess column value & removing special character
				String s=eachvalue.getText().replaceAll("%", "");
				//converting string list to integer list & adding into another list  
				list1.add(Integer.parseInt(s));
					
			}
			//sorting list
			Collections.sort(list1);
			System.out.println(list1);
			Integer lowest=list1.get(0);
			
			//click on check box of least progress value in table
			driver.findElementByXPath("//td[contains(text(),'"+lowest+"')]/following-sibling::td/input").click();
			
			
			Thread.sleep(2000);
			
			
			driver.quit();
	
	}

}