package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalImages {
static WebDriver driver;
	public static void main(String[] args) {
		
		//WAP :
		// 1. Total Images
		// 2. Print the text of each link(Ignore Blank or Empty)
		// 3. Print the href value of each link
		
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com");
		List<WebElement> imageList=driver.findElements(By.tagName("img"));
		System.out.println("Total Images are : " + imageList.size());
		
		for (WebElement e : imageList) {
			String altVal=e.getAttribute("alt");
			String srcVal=e.getAttribute("src");
			System.out.println(altVal + ": " + srcVal);
		}
		

	}

}
