package org.amazon.pages;

import org.testleaf.base.ProjectSpecificMethods;


public class HomePage extends ProjectSpecificMethods {

	public HomePage enterProductName(String data) {
		driver.findElementById("twotabsearchtextbox").sendKeys(data);
		return this;
	}
	
	public ProductSelectionPage clickSearch() {
		driver.findElementByClassName("nav-input").click();
		return new ProductSelectionPage();
	}
}
	
	
