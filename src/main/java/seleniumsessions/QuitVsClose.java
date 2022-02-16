package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

	// Quit method will close the browser not the server
	// Quit method will null the session
	// Close method will invalid the session
	// In both case we need to reinitialize the server

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
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
		// 1.
		// driver.quit();// No Such SessionException : Session Id Is Null

		// 2.
		driver.close();// No Such SessionException : Session Id Is Invalid

		// System.out.println(driver.getTitle());// Exception in thread "main"
		// org.openqa.selenium.NoSuchSessionException:
		// Session ID is null
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String title1 = driver.getTitle();
		System.out.println("Title of page is : " + title1);// Exception in thread "main"
															// org.openqa.selenium.NoSuchSessionException: invalid
															// session id
	}

}
