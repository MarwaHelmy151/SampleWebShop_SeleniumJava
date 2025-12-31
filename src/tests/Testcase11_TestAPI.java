package tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.DashboradPage;
import pageObject.HomePage;
import pageObject.LoginPage;

public class Testcase11_TestAPI extends TestBase {
	String email = "MariaTest3@gmail.com";
	String password = "123456";
	String productcategory = "Electronics";
	String item = "Cell phones";
	String desiredproduct = "Smartphone";

	HomePage homeobject;
	LoginPage loginobject;
	DashboradPage dashboardobject;

	@Test(priority = 1)
	public void UserCanLoginSuccessfully() {
		homeobject = new HomePage(driver);
		homeobject.openLoginPage();

		loginobject = new LoginPage(driver);
		loginobject.usercanLogin(email, password);

		Assert.assertEquals(loginobject.customerinfo.getText(), email);
	}

	@Test(priority = 2)
	public void identifyStatusCode() throws InterruptedException, MalformedURLException, IOException {
		homeobject.hovergenericElement(productcategory);
		homeobject.selectItemfromList(item);
		HttpURLConnection conn = (HttpURLConnection) new URL("https://demowebshop.tricentis.com/cell-phones")
				.openConnection();
		// conn.setRequestMethod("HEAD");
		conn.connect();
		int respCode = conn.getResponseCode();
		String message = conn.getResponseMessage();
		URL url = conn.getURL();
		String requestmethod = conn.getRequestMethod();

		System.out.println("Status " + respCode);
		System.out.println(message);
		System.out.println(url);
		System.out.println(requestmethod);
		//
//		dashboardobject = new DashboradPage(driver);
//		dashboardobject.selectProduct(desiredproduct);
//		HttpURLConnection conn2 = (HttpURLConnection) new URL("https://demowebshop.tricentis.com/smartphone")
//				.openConnection();
//		conn2.connect();
//		int respCode2 = conn2.getResponseCode();
//		String message2 = conn2.getResponseMessage();
//		URL url2 = conn2.getURL();S
//		String requestmethod2 = conn2.getRequestMethod();
//		System.out.println("Status " + respCode2);
//		System.out.println(message2);
//		System.out.println(url2);
//		System.out.println(requestmethod2);
	}
}
