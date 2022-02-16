package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownAllOptions {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// html tag : Select

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial");
		By country = By.id("Form_submitForm_Country");
		By state = By.id("Form_submitForm_State");

		// Select select = new Select(driver.findElement(country));
		// List<WebElement> optionsList = select.getOptions();

		// System.out.println(optionsList.size());
		// int i = 0;
		// for (WebElement e : optionsList) {
		// System.out.println(i + ":" + e.getText());
		// i++;

		// }

		if (getDropDownOptionsList(country).contains("India")) {
			System.out.println("India is Present in the dropdown");
		}
		
		selectvalueFromDropDown(country, "India");

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static List<String> getDropDownOptionsList(By locator) {
		Select select = new Select(driver.findElement(locator));
		List<WebElement> optionList = select.getOptions();
		List<String> optionsTextList = new ArrayList<String>();
		System.out.println(optionList.size());

		for (WebElement e : optionList) {
			String text = e.getText();
			optionsTextList.add(text);

		}
		return optionsTextList;
	}

	public static void selectvalueFromDropDown(By locator, String value) {
		Select select = new Select(driver.findElement(locator));
		List<WebElement> optionList = select.getOptions();

		for (WebElement e : optionList) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;

			}

		}
	}
}
