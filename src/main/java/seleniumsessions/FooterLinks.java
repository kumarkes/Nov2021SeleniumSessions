package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterLinks {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		List<WebElement> footerLinks = driver.findElements(By.xpath("//div[contains(@class,'navFooterCopyright')]//a"));
		int c = 0;
		for (WebElement e : footerLinks) {
			String footerText = e.getText();
			System.out.println(c + ": " + footerText);
			c++;
		}
	}

}
