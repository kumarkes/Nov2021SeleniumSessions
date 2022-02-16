package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtil {

	private WebDriver driver;

	/**
	 * This method is used to initialize the browser on the basis of Browser name
	 * 
	 * @param Browser
	 * @return this returns webdriver
	 */

	public WebDriver launchBrowser(String Browser) {
		System.out.println("Browser Name Is " + Browser);

		if (Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (Browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\\\Users\\\\KESHAV KUMAR\\\\Downloads\\\\geckodriver-v0.30.0-win64\\\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (Browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\KESHAV KUMAR\\Downloads\\edgedriver_win32\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			System.out.println("Please pass the right browser " + Browser);
		}
		return driver;

	}

	/**
	 * 
	 * @param URL
	 */
	public void enterURL(String URL) {
		System.out.println("URL Is " + URL);
		if (URL.contains("http") || URL.contains("https")) {
			driver.get(URL);
		} else {
			System.out.println("URL format is not correct");
			try {
				throw new Exception("Incorrect URL Missing http or https");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 
	 * @return
	 */
	public String getPageTitle() {
		return driver.getTitle();
	}

	/**
	 * 
	 * @return
	 */
	public String getPageURL() {
		return driver.getCurrentUrl();
	}

	/**
	 * 
	 */
	public void quitBrowser() {
		driver.quit();
	}

	/**
	 * 
	 */
	public void closeBrowser() {
		driver.close();
	}
}
