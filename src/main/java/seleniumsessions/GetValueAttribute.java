package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetValueAttribute {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// 1. id: Unique
		// 2. name: can be duplicate

		driver.get("https://demo-opencart.com/index.php?route=account/login");

		By emailId = By.id("input-email");
		doSendKeys(emailId, "test@gmail.com");
		// String atr=driver.findElement(emailId).getAttribute("value");
		// System.out.println(atr);
		// String text = doGetText(emailId);
		// System.out.println(text);
		System.out.println(doGetAttribute(emailId, "value"));

	}

	public static String doGetAttribute(By locator, String atrName) {
		return getElement(locator).getAttribute(atrName);
	}

	public static void doClick(By locator) {
		getElement(locator).click();
	}

	public static void doSendKeys(By Locator, String value) {
		getElement(Locator).sendKeys(value);
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
