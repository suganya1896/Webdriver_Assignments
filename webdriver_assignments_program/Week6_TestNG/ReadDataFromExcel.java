package testng.week6;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public String[][] readExcel(String fileName) throws IOException {
		
	//moving to excel file folder by mentioning the path
	XSSFWorkbook wb= new XSSFWorkbook("E:\\Testleaf_updated Doc\\MavenProject\\src\\main\\resources\\"+fileName+".xlsx");
	//getting into sheet where data present
	XSSFSheet ws=wb.getSheet("Sheet1");
	//get the no of rows including header 
	int rowsCount=ws.getPhysicalNumberOfRows();
	//to get no of rows count excluding header use below method
	//int rows=ws.getLastRowNum();
	//to get no of cells count..first moving to 1st row by using getRow(0) & counting no of column by using below method
	int cellsCount=ws.getRow(0).getLastCellNum();
	
	//declare an empty 2d array to store all rows & cells values
	String[][] data=new String[rowsCount][cellsCount];
	//looping to store all cells value in array
	for(int i=0;i<rowsCount;i++)
	{
		for(int j=0;j<cellsCount;j++)
		{
			//storing first cell value in exceldata vaariable
			String Exceldata=ws.getRow(i).getCell(j).getStringCellValue();
			//assigning exceldata value to array
			data[i][j]=Exceldata;
		}
	}
		
	//close the workbook(excel)
	wb.close();
	// this readexcel method has return type string[][] ,so must have return statement to return data to main program
	return data;
	
	
	}

}
