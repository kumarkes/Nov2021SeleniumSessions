package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoSuchElementException {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo-opencart.com/index.php?route=account/login");
		driver.findElement(By.id("input-email1")).sendKeys("test@gmail.com");
		// org.openqa.selenium.NoSuchElementException: no such element: Unable to locate
		// element:

	}

}
