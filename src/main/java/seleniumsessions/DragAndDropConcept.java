package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		WebElement sourceFile = driver.findElement(By.id("draggable"));
		WebElement destinationFile = driver.findElement(By.id("droppable"));

		Actions action = new Actions(driver);
		Thread.sleep(3000);
		//action.clickAndHold(sourceFile).moveToElement(destinationFile).release().build().perform();
		action.dragAndDrop(sourceFile, destinationFile).build().perform(); // Risky Scenario, Sometimes it works sometimes not work. If both are the elements then only it will work

	}

}
