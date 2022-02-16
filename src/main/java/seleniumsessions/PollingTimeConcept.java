package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PollingTimeConcept {

	static WebDriver driver;
	
	// By Default pooling interval is 500ms(0.5 sec) in selenium

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");
		By emailId = By.id("input-email11");
		By passWord = By.id("input-password");
		//WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.pollingEvery(Duration.ofSeconds(2)); or;
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));
		WebElement email_ele=wait.until(ExpectedConditions.visibilityOfElementLocated(emailId));
		email_ele.sendKeys("test@gmail.com");
	

	}

}
