package mytests;

import org.testng.annotations.Test;

public class ECommTest {
	
	//In case of Priority Based and Non Priority Based, preference will be given to Non-Priority Based in running

	@Test(priority=1)
	public void loginTest() {
		System.out.println("login test");
	}

	@Test(priority=2)
	public void searchTest() {
		System.out.println("search test");
	}

	@Test(priority=4)
	public void homeTest() {
		System.out.println("home test");
	}

	@Test(priority=3)
	public void cartTest() {
		System.out.println("cart test");
	}
	
	@Test
	public void m1Test() {
		System.out.println("m1 test");
	}
	
	@Test
	public void m2Test() {
		System.out.println("m2 test");
	}

}
