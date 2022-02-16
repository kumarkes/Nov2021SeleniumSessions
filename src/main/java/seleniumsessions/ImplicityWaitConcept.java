package seleniumsessions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;

public class ImplicityWaitConcept {

	public static void main(String[] args) {
		// wait:-
		// static:- If timeout is 10 secs and element is found in 2 sec then also it
		// will wait for 10 secs
		// Dynamic:- If timeout is 10 sec and element is found in 2 sec and it will not
		// wait for 10 secs
		// 2.a:Implicitly Wait
		// 2.b:Explicit Wait
		// 2.b.1 : WebDriverWait
		// 2.b.1 : FluentWait(Class)

		// WebDriverWait(C) --> extends --> FluentWait(C) --> Wait(I) --> until();
		// Unit(){}
		// Other methods

		// Implicit Wait
		// Dynamic Wait
		// Its only applicable for web elements : FindElement, FindElements
		// Not applicable for non web elements : Title, URL, Alert
		// Global Wait : Once it is applied, it will applicable for all the Web Elements

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		// 10 sec for 1st element
		WebElement email_Id = driver.findElement(By.id("input-email"));
		email_Id.sendKeys("test@gmail.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Overridden the Global Wait
		// 5 sec for 2nd element also
		WebElement passWord = driver.findElement(By.id("test"));
		passWord.sendKeys("test123");

		// e3--> 5 sec
		// e4--> 5 sec

		// Home Page--> 20 secs

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));// Override the Global Wait
		// HE1
		// HE2
		// HE3
		// Click on logout-- landing on login page:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Override the Global Wait
        // Click on Registration Page : 0 sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		//RE1
		//RE2
	}

}
