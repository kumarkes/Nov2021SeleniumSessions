package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.amazon.com");

		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// String title = js.executeScript("return document.title").toString();
		// System.out.println(title);

		JavaScriptUtil jsu = new JavaScriptUtil(driver);
		// String title=jsu.getTitleByJS();
		// System.out.println(title);

		String pageText = jsu.getPageInnerText();
		System.out.println(pageText);
		if (pageText.contains("Health & Household ")) {
			System.out.println("pass");

		}
		// jsu.generateAlert("This is custom Alert");
		// jsu.refreshBrowserByJS();
		// WebElement element = driver.findElement(By.xpath("h1[text()='Delight made
		// easy']"));
		// WebElement element = driver.findElement(By.cssSelector("div#content form"));
		// jsu.drawBorder(element);
		// WebElement ele = driver.findElement(By.id("input-email"));
		// WebElement elep = driver.findElement(By.id("input-password"));
		// jsu.flash(ele);
		// ele.sendKeys("test@gmail.com");
		// jsu.flash(elep);
		// elep.sendKeys("test@123");

		// jsu.scrollPageDown();
		// Thread.sleep(5000);
		// jsu.scrollPageUp();
		// Thread.sleep(5000);
		// jsu.scrollPageDown("700");

		// WebElement ele=driver.findElement(By.xpath("//span[text()='Popular products
		// in PC internationally']"));
		// jsu.scrollIntoView(ele);
		// jsu.flash(ele);
		// jsu.drawBorder(ele);
		
		WebElement custLink=driver.findElement(By.linkText("Customer Service"));
		jsu.clickElementByJS(custLink);

	}

}
