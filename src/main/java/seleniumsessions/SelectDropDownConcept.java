package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownConcept {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// html tag : Select

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial");
		By country = By.id("Form_submitForm_Country");
		By state = By.id("Form_submitForm_State");
		// WebElement country_ele = driver.findElement(country);
		// WebElement state_ele = driver.findElement(state);

		// Select select = new Select(country_ele);
		// select.selectByIndex(5);
		// select.selectByVisibleText("India");

		// Thread.sleep(4000);
		// Select select1 = new Select(state_ele);
		// select1.selectByVisibleText("Delhi");
		//doSelectDropdownByIndex(country, 10);
		//doSelectDropdownByIndex(state, 2);
		
		//doSelectDropdownByVisibleText(country, "India");
		//Thread.sleep(4000);
		//doSelectDropdownByVisibleText(state, "Delhi");
		
		doSelectDropdownByValue(country, "India");
		Thread.sleep(4000);
		doSelectDropdownByValue(state, "Karnataka");

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doSelectDropdownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public static void doSelectDropdownByVisibleText(By locator, String visibleText) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
	}

	public static void doSelectDropdownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

}
