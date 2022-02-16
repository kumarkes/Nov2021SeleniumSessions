package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

// If input = type in DOM then only uploading concept will work

public class FileUploadPopUp {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		//html tag : file = type
		
		driver.findElement(By.name("upfile")).sendKeys("C:\\Users\\KESHAV KUMAR\\Desktop\\Imp_File.txt");

	}

}
