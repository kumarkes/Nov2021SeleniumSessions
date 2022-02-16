package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElementConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map#/");
		Thread.sleep(5000);

		String svgXPath = "//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='states']/*[name()='g']/*[name()='path']";

		List<WebElement> graphList = driver.findElements(By.xpath(svgXPath));
		Actions act = new Actions(driver);
		for (WebElement e : graphList) {
			act.moveToElement(e).perform();
			Thread.sleep(1000);
			String nameAttr = e.getAttribute("name");
			System.out.println(nameAttr);
			if (nameAttr.equals("Maryland")) {
				act.click(e).perform();
				break;

			}

		}
		
		// Flipkart search Icon
		//*[local-name()='svg']/*[name()='g' and @fill-rule='evenodd']
	}

}
