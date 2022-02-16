package seleniumsessions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitNonWebElements {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.amazon.com");

		String title = doGetPageTitle("Amazon", 5);
		System.out.println(title);
	}

	/**
	 * An expectation for checking that the title contains a case-sensitive
	 * substring
	 * 
	 * @param titleVal
	 * @param TimeOut
	 */
	public static boolean waitForPageTitle(String titleVal, int TimeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeOut));
		return wait.until(ExpectedConditions.titleContains(titleVal));
	}
	
	/**
	 * An expectation for checking that the title contains a case-sensitive substring
	 * @param actTitle
	 * @param TimeOut
	 * @return
	 */
	public static boolean waitForPageActTitle(String actTitle, int TimeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeOut));
		return wait.until(ExpectedConditions.titleIs(actTitle));
	}

	/**
	 * Get the title of the current page.
	 * 
	 * @param titleVal
	 * @param TimeOut
	 * @return
	 */
	public static String doGetPageTitle(String titleVal, int TimeOut) {
		if (waitForPageTitle(titleVal, TimeOut)) {
			return driver.getTitle();

		}
		return null;
	}

}
