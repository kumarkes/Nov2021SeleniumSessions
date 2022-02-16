package mytests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest {

	@DataProvider
	public Object[][] loginTestData() {
		return new Object[][] { { "admin@gmail.com", "admin123" }, { "cust@gmail.com", "cust123" },
				{ "vendor@gmail.com", "vendor123" } };
	}

	@Test(dataProvider="loginTestData")
	public void loginTest(String userName,String passWord) {
		Assert.assertTrue(doLogin(userName,passWord));
	}

	public boolean doLogin(String userName, String passWord) {
		System.out.println("user name : " + userName);
		System.out.println("password : " + passWord);
		System.out.println("login successfully");
		return true;
	}

}
