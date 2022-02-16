package seleniumsessions;

public class AmazonTest {

	public static void main(String[] args) {
		BrowserUtil bu = new BrowserUtil();
		bu.launchBrowser("chrome");
		bu.enterURL("https://www.google.com");
		String title = bu.getPageTitle();
		System.out.println("Title of the page is " + title);
		if (title.contains("Google")) {
			System.out.println("Loaded page is correct one");

		} else {
			System.out.println("Loaded page is not correct");

		}
		String pageURL = bu.getPageURL();
		System.out.println("URL of the page is " + pageURL);
		if (pageURL.contains("google")) {

			System.out.println("Loaded page URL is correct one");
		} else {
			System.out.println("Loaded page URL is not correct one");
		}
		bu.quitBrowser();
		

	}

}
