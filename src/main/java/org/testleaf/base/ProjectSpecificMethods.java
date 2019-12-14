package org.testleaf.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testleaf.utils.ReadExcel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class ProjectSpecificMethods {
	public static ChromeDriver driver;
	public String excelFileName;
	
	@BeforeMethod
	public void login() {
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver= new ChromeDriver();
			driver.get("http://www.amazon.in");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeApp() {
		driver.close();
	}
	
	@DataProvider(name="fetchData")//internally call readExcel-Apache POI(reads excel and returns back as 2 D array)
	public String[][] getData() throws IOException {
		ReadExcel readData=new ReadExcel();
		return readData.readExcel(excelFileName);
	}

}
