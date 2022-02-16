package seleniumsessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopUpHandling {

	public static void main(String[] args) throws InterruptedException  {
		// alert : JS Alert pop-up

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();
		
		//alert will pop-up
		
		Thread.sleep(5000);
		
		Alert alert=driver.switchTo().alert();
		String alertText=alert.getText();
		System.out.println("Alert text is : " + alertText);
		alert.accept();//click on ok
		//alert.dismiss();//click on cancel
		alert.sendKeys("Testing");

	}

}
