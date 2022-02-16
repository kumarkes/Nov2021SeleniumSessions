package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// WebDrivermanager is not working here. Need to ask about it
public class WDMConcept {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver d = new ChromeDriver();
		d.get("https://www.google.com");
		String str=d.getTitle();
		System.out.println(str);
		d.quit();

	}

}
