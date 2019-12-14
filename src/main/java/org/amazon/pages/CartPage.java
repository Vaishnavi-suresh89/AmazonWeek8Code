package org.amazon.pages;

import org.openqa.selenium.By;
import org.testleaf.base.ProjectSpecificMethods;

public class CartPage extends ProjectSpecificMethods {
	public CartPage confirmAddCartMsg(){
		String addedToCart = driver.findElement(By.tagName("h1")).getText();
		System.out.println("Confirm that product is added: "+addedToCart);
		return this;
		
		
	}
	public SignInPage clickProceed() {
		
		
		driver.findElementById("hlb-ptc-btn-native").click();
		return new SignInPage();
	}

}
