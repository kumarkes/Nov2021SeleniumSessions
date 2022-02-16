package mytests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest {
	// Global Pre Conditions
	// Pre Conditions
	// Test Steps+Assertions(act vs exp result)
	// Post Steps

	@BeforeSuite
	public void createUser() {
		System.out.println("BS--create user");
	}

	@BeforeTest
	public void connectWithDB() {
		System.out.println("BT--connect with DB");
	}

	@BeforeClass
	public void launchBrowser() {
		System.out.println("BC--launch Browser");
	}

	@BeforeMethod
	public void login() {
		System.out.println("BM--login to App");
	}

	@Test
	public void homePageTest() {
		System.out.println("HomePageTest");
	}

	@Test
	public void searchTest() {
		System.out.println("Search Test");
	}

	@Test
	public void priceTest() {
		System.out.println("Price Test");
	}

	@AfterMethod
	public void logout() {
		System.out.println("AM--logout");
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("AC--closeBrowser");
	}

	@AfterTest
	public void disconnectWitHDB() {
		System.out.println("AT--disconnectingWithDB");
	}

	@AfterSuite
	public void deleteUser() {
		System.out.println("AS--deletingUser");
	}
}
