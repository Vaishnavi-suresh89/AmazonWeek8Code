package org.amazon.testcases;

import org.amazon.pages.HomePage;
import org.testleaf.base.ProjectSpecificMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC001_BuyProduct extends ProjectSpecificMethods {
	@BeforeTest
	public void setData() {
		excelFileName="BuyProduct_Excel";
	}
	@Test(dataProvider="fetchData")
	public void BuyProduct(String pname) {
		
		new HomePage()
		.enterProductName(pname)
		.clickSearch()
		.getThePriceMobile()
		.clickTheProduct()
		.getDeliveryDate()
		.clickAddToCart()
		.confirmAddCartMsg()
		.clickProceed()
		.confirmLandingPage()
		.clickContinue();
		
	
	}



}
