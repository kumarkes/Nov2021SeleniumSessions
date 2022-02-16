package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementDisplay {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://demo-opencart.com/index.php?route=account/login");
		By email = By.id("input-email");
		if (doIsDisplayed(email)) {
			doSendKeys(email, "test@gmail.com");

		}
		driver.findElement(email).isEnabled();

	}

	public static boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public static WebElement getElement(By Locator) {
		return driver.findElement(Locator);
	}

	public static void doSendKeys(By Locator, String value) {
		getElement(Locator).sendKeys(value);
	}

}
