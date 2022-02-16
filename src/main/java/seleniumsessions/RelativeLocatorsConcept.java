package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocatorsConcept {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.aqi.in/dashboard/canada");
		WebElement ele = driver.findElement(By.linkText("Cornwall, Canada"));

		String index = driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
		System.out.println(index);

		String rank = driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
		System.out.println(rank);

		String belowCity = driver.findElement(with(By.tagName("p")).below(ele)).getText();
		System.out.println(belowCity);

		String aboveCity = driver.findElement(with(By.tagName("p")).above(ele)).getText();
		System.out.println(aboveCity);

		// Near command will work if any element is available within 15 pixel of radius
		String near = driver.findElement(with(By.tagName("p")).near(ele)).getText();
		System.out.println(near);

		List<WebElement> aboveList = driver.findElements(with(By.tagName("p")).above(ele));
		for (WebElement e : aboveList) {
			System.out.println(e.getText());

		}

	}

}
