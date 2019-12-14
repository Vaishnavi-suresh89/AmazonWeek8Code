package org.amazon.pages;

import org.openqa.selenium.By;
import org.testleaf.base.ProjectSpecificMethods;

public class SignInPage extends ProjectSpecificMethods {
	
	public SignInPage confirmLandingPage() {
		String signIn = driver.getTitle();
		System.out.println(signIn);
		if(signIn.equals("Amazon Sign In")) {
			System.out.println("Sign In page confirmed");
			
		}else {System.out.println("Sign In page not confirmed");
		}
		return this;
		
	}
	
	public SignInPage clickContinue() {
		driver.findElement(By.xpath("(//input[@id='continue'])[1]")).click();
		String enterYourEmail = driver.findElement(By.xpath("(//div[@class='a-alert-content'])[2]")).getText();
		System.out.println("Error Msg: "+enterYourEmail);
		return this;
		
	}

}
