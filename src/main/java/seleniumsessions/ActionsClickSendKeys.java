package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClickSendKeys {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/register");
		By fn = By.id("input-firstname");
		By ln = By.id("input-lastname");
		By login = By.xpath("//input[@value='Continue']");
		//Actions act = new Actions(driver);
		//act.sendKeys(driver.findElement(fn), "Keshav").perform();
		//act.sendKeys(driver.findElement(ln), "Kumar").perform();
		//act.click(driver.findElement(login)).perform();
		doActionsSendKeys(fn, "Keshav");
		doActionsSendKeys(ln, "Kumar");
		doActionsClick(login);

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}

	public static void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}

}
