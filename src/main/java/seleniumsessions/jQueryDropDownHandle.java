package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jQueryDropDownHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justAnInputBox")).click();
		By choices = By.xpath("//span[@class='comboTreeItemTitle']");

		// TC_1 : Single Selection
		// selectChoice(choices, "choice 1");

		// TC_2 : Multi Selection
		selectChoice(choices, "choice 4", "choice 5", "choice 8");

		// TC_3 : All Selection
		// selectChoice(choices, "all");

	}

	public static void selectChoice(By locator, String... value) {
		List<WebElement> choiceList = driver.findElements(locator);
		boolean flag = false;
		if (!value[0].equalsIgnoreCase("all")) {

			for (WebElement e : choiceList) {
				String choiceName = e.getText();
				// System.out.println(choiceName);

				for (int i = 0; i < value.length; i++) {
					if (choiceName.equals(value[i])) {
						e.click();
						flag = true;
						break;
					} else {
						flag = false;
					}

				}
			}

		} else {
			// for all selection:
			try {
				for (WebElement e : choiceList) {
					e.click();
					flag = true;
				}
			} catch (ElementNotInteractableException e) {
				System.out.println("All choices are over");
				// e.printStackTrace();
			}
		}
		if (flag == false) {
			System.out.println("Choice is not correct");

		}
	}
}