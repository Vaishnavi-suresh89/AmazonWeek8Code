package org.testleaf.utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public String[][] readExcel(String excelFileName) throws IOException {
		// TODO Auto-generated method stub
XSSFWorkbook book=new XSSFWorkbook("./Data/"+excelFileName+".xlsx");//object created and path given where the excel book saved at runtime we are going to change the excel so passing as arg
XSSFSheet sheet = book.getSheetAt(0);//get into the particular sheet to change in runtime
int rowCount = sheet.getLastRowNum();//get the row count(by default the Apache POI considers the rowcount as -1 (header)
System.out.println("Row Count: "+rowCount);
short colCount = sheet.getRow(0).getLastCellNum();//get the column count by row(0)(header) and the last cell number
System.out.println("Column Count: "+colCount);

String[][] data=new String[rowCount][colCount];//corelate with the step used in data provider(to fix the size of the array)

for (int i = 1; i <= rowCount; i++) {//loop for the 1st row and then j loop for the entire column value to get printed repeat the same
	XSSFRow row = sheet.getRow(i);//navigate row by row
	for (int j = 0; j < colCount; j++) {
		XSSFCell cell = row.getCell(j);//navigate column by column
		String value = cell.getStringCellValue();//to display the string value in the cell
		data[i-1][j]=value;//as array is defaulted to 0 we the array(i) value as i-1, but as per the excel logic eliminates the headed
		//contn..i value is 1 in the above for loop but here in data[declared as i-1]
		//System.out.println("Excel Test Data: "+value);
	} 
}
return data;
	}

}



