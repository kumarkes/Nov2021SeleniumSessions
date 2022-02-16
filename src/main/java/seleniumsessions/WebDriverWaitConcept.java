package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");
		By emailId = By.id("input-email");
		By passWord = By.id("input-password");
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// WebElement
		// email_ele=wait.until(ExpectedConditions.presenceOfElementLocated(emailId));
		// email_ele.sendKeys("tom@gmail.com");
		// driver.findElement(passWord).sendKeys("test@123");

		waitForElementPresence(emailId, 10).sendKeys("test@gmail.com");
		getElement(passWord).sendKeys("test@123");
	}

	/**
	 * Find the first WebElement using the given method.This method is affected by
	 * the 'implicit wait' times in force at the time of execution.The
	 * findElement(..) invocation will return a matching row, or try again
	 * repeatedly until the configured timeout is reached.
	 * 
	 * findElement should not be used to look for non-present elements, use
	 * findElements(By)and assert zero length response instead.
	 * 
	 * @param locator
	 * @return
	 */
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does notnecessarily mean that the element is visible
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible.Visibility means that the element is not only displayed but also
	 * has a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

}
