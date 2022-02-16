package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/register");
		By emailId = By.id("input-email1");
		By passWord = By.id("input-password");
		// Wait<WebDriver> wait = new
		// FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
		// .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class)
		// .ignoring(StaleElementReferenceException.class);
		// WebElement email_ele =
		// wait.until(ExpectedConditions.presenceOfElementLocated(emailId));
		// email_ele.sendKeys("test@gmail.com");
		waitforElementPresenceWithFluentWait(emailId, 10, 2).sendKeys("test@gmail.com");
		driver.findElement(passWord).sendKeys("test@123");

	}

	public static WebElement waitforElementPresenceWithFluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.withMessage(locator + " : is not found within the given time....");
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public static WebElement waitforElementPresenceWithWait(By locator, int timeOut, int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(StaleElementReferenceException.class)
				.withMessage(locator + " : is not found within the given time....");
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

}
