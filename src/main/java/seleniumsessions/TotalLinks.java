package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {
	static WebDriver driver;

	public static void main(String[] args) {
		// WAP:
		// 1. Total Links
		// 2. Print the text of each links(Ignore Blanks/empty text)
		// 3. Print the href value of each links

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		// 1. id: unique --I
		// 2. name: can be duplicate -- II
		driver.get("https://www.amazon.com");
		// List<WebElement> linksList = driver.findElements(By.tagName("a"));
		// System.out.println("Total links are : " + linksList.size());

		// int c=0;
		// for (WebElement e : linksList) {
		// String text=e.getText();
		// if (!text.isEmpty()) {
		// System.out.println("Text of Links are " + c + ":" + text);
		// }

		// String hrefVal=e.getAttribute("href");
		// System.out.println(hrefVal);
		// c++;
		// }

		// for (int i = 0; i < linksList.size(); i++) {

		// String textLinks = linksList.get(i).getText();
		// if (!textLinks.isEmpty()) {
		// System.out.println(i + ": " + textLinks);

		// }
		// }
		By links = By.tagName("a");
		By images = By.tagName("img");
		System.out.println(getElementsCount(links));
		System.out.println(getElementsCount(images));
		if (getElementsTextList(links).contains("Registry")) {

			System.out.println("Registry is present");
		}
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static int getElementsCount(By locator) {
		return driver.findElements(locator).size();
	}

	public static void getElementsText(By locator) {
		List<WebElement> listElem = getElements(locator);
		for (WebElement e : listElem) {
			String textName = e.getText();
			System.out.println(textName);

		}

	}

	public static List<String> getElementsTextList(By locator) {
		List<WebElement> listElem = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for (WebElement e : listElem) {
			String text = e.getText();
			if (!text.isEmpty()) {
				eleTextList.add(text);
			}

		}
		return eleTextList;
	}

	public List<String> getElementsAttributeList(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleAttrList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String attrVal = e.getAttribute(attrName);
			eleAttrList.add(attrVal);
		}
		return eleAttrList;
	}


	}
