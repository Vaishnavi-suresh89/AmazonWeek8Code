package org.amazon.pages;

import org.testleaf.base.ProjectSpecificMethods;

public class ProductSpecificDetails extends ProjectSpecificMethods{
	public ProductSpecificDetails getDeliveryDate() {
		String deliveryDate = driver.findElementByXPath("(//span[@class='a-text-bold'])[4]").getText();
		System.out.println("The delivery date of the selected product is: "+deliveryDate);
		return this;
		
	}
	public CartPage clickAddToCart() {
		driver.findElementById("add-to-cart-button").click();
		return new CartPage();
	}
	

}
