package week8.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuyProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		ChromeDriver driver= new ChromeDriver();		
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions builder=new Actions(driver);
        driver.findElementById("twotabsearchtextbox").sendKeys("Samsung Galaxy M30");
        driver.findElementByClassName("nav-input").click();
        String priceFirstResult = driver.findElementByClassName("a-price-whole").getText();
        System.out.println("The Price of first resulting phone: "+priceFirstResult);
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
        String parentWindow = driver.getWindowHandle();
		Set<String> allWindowsSet = driver.getWindowHandles();
		System.out.println("Total No of windows: "+allWindowsSet.size());
		List<String> windowsList=new ArrayList<String>();
		windowsList.addAll(allWindowsSet);
		driver.switchTo().window(windowsList.get(1));
		/*System.out.println("The Title of the child window is: "+driver.getTitle());
		System.out.println("The URL of the child window is: "+driver.getCurrentUrl());*/
		//driver.close();
		//to move the control to parent window
		/*driver.switchTo().window(parentWindow);
		System.out.println("The Title of the parent window is: "+driver.getTitle());
		System.out.println("The URL of the parent window is: "+driver.getCurrentUrl());*/
		String deliveryDate = driver.findElementByXPath("(//span[@class='a-text-bold'])[4]").getText();
		System.out.println("The delivery date of the selected product is: "+deliveryDate);
		driver.findElementById("add-to-cart-button").click();
		String addedToCart = driver.findElement(By.tagName("h1")).getText();
		System.out.println("Confirm that product is added: "+addedToCart);
		driver.findElementById("hlb-ptc-btn-native").click();
		String signIn = driver.getTitle();
		System.out.println(signIn);
		if(signIn.equals("Amazon Sign In")) {
			System.out.println("Sign In page confirmed");
			
		}else {System.out.println("Sign In page not confirmed");
		}
		driver.findElement(By.xpath("(//input[@id='continue'])[1]")).click();
		String enterYourEmail = driver.findElement(By.xpath("(//div[@class='a-alert-content'])[2]")).getText();
		System.out.println("Error Msg: "+enterYourEmail);
		driver.close();
		
        
        

	}

}
