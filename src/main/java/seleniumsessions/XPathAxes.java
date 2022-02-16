package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XPathAxes {

	static WebDriver driver;
	// Web Table Handling Scenario

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://www.espncricinfo.com/series/india-in-south-africa-2021-22-1277060/south-africa-vs-india-1st-odi-1277082/full-scorecard");
		// WebElement batsMan=driver.findElement(By.xpath("//a[text()='Temba
		// Bavuma']/parent::td/following-sibling::td/span"));
		// System.out.println(batsMan.getText());
		//System.out.println(getWicketTakerName("Shardul Thakur"));
		
		System.out.println(getPlayerScoreCard("Shardul Thakur"));

	}

	public static String getWicketTakerName(String playerName) {
		WebElement batsMan = driver
				.findElement(By.xpath("//a[text()='" + playerName + "']/parent::td/following-sibling::td/span"));
		return batsMan.getText();
	}

	public static List<String> getPlayerScoreCard(String playerName) {
		List<String> actualScoreList = new ArrayList<>();
		List<WebElement> scoreList = driver
				.findElements(By.xpath("//a[text()='" + playerName + "']/parent::td/following-sibling::td"));
		System.out.println(scoreList.size());
		for (int i = 1; i < scoreList.size(); i++) {
			String text = scoreList.get(i).getText();
			actualScoreList.add(text);

		}
		return actualScoreList;
	}

}
