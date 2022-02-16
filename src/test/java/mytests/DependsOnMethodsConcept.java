package mytests;

import org.testng.annotations.Test;

public class DependsOnMethodsConcept {

	@Test
	public void loginTest() {
		System.out.println("login to app");
		int i=9/0;
	}

	@Test(dependsOnMethods = "loginTest")
	public void homeTest() {
		System.out.println("home test");
	}
	
	@Test(dependsOnMethods = "loginTest")
	public void searchTest()
	{
		System.out.println("search test");
	}
	
	//Test should be independent,not be dependent on any other method. Its a good practise
	// Try to avoid priority
	//always define the assertion -- act vs exp validation point/checkpoint
	//CRUD
	
	//@Test t1
	//create the user
	
	//@Test t2 (depends=t1)
	//Update User :
	//2. take the user id from the new user (user id = 3)
	//3. pick the same user id to update the user
	//4. delete the user (id=3)

}
