package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsMethod {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://demo-opencart.com/index.php?route=account/login");

		// Create a Web Element
		// WebElement can create by By Locator
		// Create Web Element + action(Click,sendkeys,isDisplayed....)

		// 1st : ID

		// 1st Approach
		// driver.findElement(By.id("input-email")).sendKeys("keshav@gmail.com");
		// driver.findElement(By.id("input-password")).sendKeys("test");

		// 2nd Approach
		// WebElement emailId = driver.findElement(By.id("input-email"));
		// WebElement passWord = driver.findElement(By.id("input-password"));
		// emailId.sendKeys("keshav@gmail.com");
		// passWord.sendKeys("test");

		// 3rd Approach (By Locator)

		// By email =By.id("input-email");
		// By password =By.id("input-password");
		// WebElement emailId=driver.findElement(email);
		// WebElement passWord=driver.findElement(password);
		// emailId.sendKeys("keshav@gmail.com");
		// passWord.sendKeys("test");

		// 4th Approach(By Locator with generic method

		// By email = By.id("input-email");
		// By password = By.id("input-password");
		// getElement(email).sendKeys("keshav@gmail.com");
		// getElement(password).sendKeys("test");

		// 5th Approach(By Locator with getElement and actions generic methods

		// By email = By.id("input-email");
		// By password = By.id("input-password");
		// doSendKeys(email, "keshav@gmail.com");
		// doSendKeys(password, "test");

		// 6th Approach(By Locator with getElement and actions generic method in util
		// class

		// By email = By.id("input-email");
		// By password = By.id("input-password");

		// ElementUtil eleUtil = new ElementUtil(driver);
		// eleUtil.doSendKeys(email, "keshav@gmail.com");
		// eleUtil.doSendKeys(password, "test");

		// 7th Approach(String locator with By,getElement and action generic method in
		// util class

		String eId = "input-email";
		String pwd = "input-password";
		// doSendKeys("id", eId, "keshav@gmail.com");
		// doSendKeys("id", pwd, "test");

		// 8th Approach

		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys("id", eId, "keshav@gmail.com");
		eleUtil.doSendKeys("id", pwd, "test");

	}

	public static WebElement getElement(By Locator) {
		return driver.findElement(Locator);
	}

	public static void doSendKeys(By Locator, String value) {
		getElement(Locator).sendKeys(value);
	}

	public static void doSendKeys(String locatorType, String locatorValue, String value) {
		getElement(getBy(locatorType, locatorValue)).sendKeys(value);
	}

	public static By getBy(String locatorType, String locatorValue) {
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);

			break;
		case "name":
			locator = By.name(locatorValue);

			break;
		case "classname":
			locator = By.className(locatorValue);

			break;
		case "xpath":
			locator = By.xpath(locatorValue);

			break;
		case "css":
			locator = By.cssSelector(locatorValue);

			break;
		case "linktext":
			locator = By.linkText(locatorValue);

			break;
		case "partiallinktext":
			locator = By.partialLinkText(locatorValue);

			break;
		case "tagname":
			locator = By.tagName(locatorValue);

			break;

		default:
			break;
		}
		return locator;
	}
}
