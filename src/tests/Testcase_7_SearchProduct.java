package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.PageBase;
import pageObject.SearchProductPage;

public class Testcase_7_SearchProduct extends TestBase {
	String email = "MariaTest3@gmail.com";
	String password = "123456";
	String desiredProduct = "$25 Virtual Gift Card";
	String recipientName = "Gift card";
	String recipientemail = "Giftcard@gmail.com";
	// String sendername = "Maria Test";
	// String sendermail = "MariaTest3@gmail.com";

	SearchProductPage searchproductobject;
	PageBase pageobject;
	HomePage homeobject;
	LoginPage loginobject;

	@Test(priority = 1)
	public void UserCanLoginSuccessfully() {
		homeobject = new HomePage(driver);
		homeobject.openLoginPage();

		loginobject = new LoginPage(driver);
		loginobject.usercanLogin(email, password);

		Assert.assertEquals(loginobject.customerinfo.getText(), email);
	}

	@Test(priority = 2)
	public void UsercanSearchforProduct() throws InterruptedException {
		searchproductobject = new SearchProductPage(driver);
		searchproductobject.enterProduct("Card");
		searchproductobject.searchforProduct(desiredProduct);

		System.out.println(searchproductobject.ProductName.getText());
		Assert.assertTrue(searchproductobject.ProductName.getText().equals(desiredProduct));
	}

	@Test(priority = 3)
	public void UsercanaddtoCart() throws InterruptedException {
		searchproductobject.addTocart();
		searchproductobject.addReview(recipientName, recipientemail);
		Thread.sleep(3000);

		System.out.println(searchproductobject.successMessages.getText());
		Assert.assertTrue(searchproductobject.successMessages.getText()
				.equals("The product has been added to your shopping cart"));

	}
}
