package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LanguageLinks {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.freshworks.com/");
		//By lang=By.xpath("//div[@id='SIvCob']/a");
		//clickOnLink(lang, "ગુજરાતી");
		
		By footerLinks=By.xpath("//ul[@class='footer-nav']//a");
		clickOnLink(footerLinks, "Careers");
		

	}
	
	public static void clickOnLink(By locator,String linkText)
	{
		List<WebElement> listLang = driver.findElements(locator);
		System.out.println(listLang.size());
		for (WebElement e : listLang) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(linkText)) {
				e.click();
				break;

			}

		}
		
	}

}
