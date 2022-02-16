package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverBasics {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String title = driver.getTitle();

		System.out.println("Title of page is : " + title);
		if (title.equals("Google")) {
			System.out.println("Title is correct");
		} else {
			System.out.println("Title is not correct");

		}
		String currentURL = driver.getCurrentUrl();
		System.out.println("Current URL Is " + currentURL);
		/*System.out.println(driver.getPageSource());
		if (driver.getPageSource().contains("Copyright The Closure Library Authors.")) {
			System.out.println("User have enter page source");
		} else {
			System.out.println("User have not entered page source");
		}*/
		driver.quit();
	}

}
