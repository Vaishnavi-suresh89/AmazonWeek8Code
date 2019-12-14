package org.amazon.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.testleaf.base.ProjectSpecificMethods;

public class ProductSelectionPage extends ProjectSpecificMethods {
	
	public ProductSelectionPage getThePriceMobile() {
		String priceFirstResult = driver.findElementByClassName("a-price-whole").getText();
        System.out.println("The Price of first resulting phone: "+priceFirstResult);
        return this;
	}
	public ProductSpecificDetails clickTheProduct() {
		driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindowsSet = driver.getWindowHandles();
		System.out.println("Total No of windows: "+allWindowsSet.size());
		List<String> windowsList=new ArrayList<String>();
		windowsList.addAll(allWindowsSet);
		driver.switchTo().window(windowsList.get(1));
		return new ProductSpecificDetails();
		
	}

}
