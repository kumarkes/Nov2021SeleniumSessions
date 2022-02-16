package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {
	static WebDriver driver;

	public static void main(String[] args) {
		// 1. ID : Always Unique
		// 2. Name : can be duplicate

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo-opencart.com/index.php?route=account/login");
		// driver.findElement(By.name("email")).sendKeys("test@gmail.com");
		// driver.findElement(By.name("password")).sendKeys("test");

		// 3. ClassName : can be duplicate

		// driver.findElement(By.className("form-control")).sendKeys("MAC");

		// 4. xpath : is not an attribute. Its address of a webelement
		// Absolute xpath
		// Relative xpath

		// driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("test@gmail.com");
		// driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("test");
		// driver.findElement(By.xpath("//input[@value='Login']")).click();

		// By emailId=By.xpath("//input[@id='input-email']");
		// By passWord=By.xpath("//input[@id='input-password']");
		// By loginButton=By.xpath("//input[@value='Login']");

		// doSendKeys(emailId, "test@gmail.com");
		// doSendKeys(passWord, "test");
		// doClick(loginButton);

		// 5. cssSelector : It is not an attribute, its Cascaded Style Sheet

		// By email=By.cssSelector("#input-email");
		// By pwd=By.cssSelector("#input-password");
		// By loginButton=By.cssSelector("input[value='Login']");

		// doSendKeys(email, "test@gmail.com");
		// doSendKeys(pwd, "test");
		// doClick(loginButton);

		// 6. linkText : only for links(<a>)

		// driver.findElement(By.linkText("Register")).click();

		// 7. partiallinkText : only for links(<a>)
		// driver.findElement(By.partialLinkText("Reg")).click();

		// 8. tagName : html tag

		String header = driver.findElement(By.tagName("h2")).getText();
		System.out.println(header);
		
		By register = By.linkText("Register");
		By headerTag = By.tagName("h2");
		System.out.println(doGetText(register));
		System.out.println(doGetText(headerTag));
	}
	
	public static String doGetText(By locator)
	{
		return driver.findElement(locator).getText();
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
