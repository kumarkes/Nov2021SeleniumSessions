package seleniumsessions;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException   {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// Move to Element
		// Parent to child menu
		// Only perform is used when there is only 1 action to perform
		// Build and Perform both used when there are multiple action to perform

		driver.get("http://mrbool.com/search/?txtsearch-how-to-create-menu-with-submenu-using-css-html");

		WebElement contentParent = driver.findElement(By.xpath("//a[contains(text(), 'Content')]"));
		Actions action = new Actions(driver);
		//action.moveToElement(contentParent).build(); // Not Correct
		//action.moveToElement(contentParent).perform(); // Correct
		action.moveToElement(contentParent).build().perform(); // Correct
		Thread.sleep(3000);
		driver.findElement(By.linkText("COURSES")).click();
	}

}
