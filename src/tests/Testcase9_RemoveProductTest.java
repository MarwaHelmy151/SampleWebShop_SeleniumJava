package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.DashboradPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ShoppingcartPage;

public class Testcase9_RemoveProductTest extends TestBase {
	String email = "MariaTest3@gmail.com";
	String password = "123456";
	String productcategory = "Digital downloads";
	String desiredproduct = "3rd Album";

	String productcategory2 = "Apparel & Shoes";
	String desiredproduct2 = "Blue and green Sneaker";
	HomePage homeobject;
	LoginPage loginobject;
	DashboradPage dashboardobject;
	ShoppingcartPage shoppingcartobject;

	@Test(priority = 1, groups = { "Regression" })
	public void UserCanLoginSuccessfully() {
		homeobject = new HomePage(driver);
		homeobject.openLoginPage();

		loginobject = new LoginPage(driver);
		loginobject.usercanLogin(email, password);

		Assert.assertEquals(loginobject.customerinfo.getText(), email);
	}

	@Test(priority = 2, groups = { "Regression" })
	public void AddFirstProductTocart() throws InterruptedException {
		// add first item
		homeobject.selectfromtopMenu(productcategory);
		dashboardobject = new DashboradPage(driver);
		dashboardobject.selectProduct(desiredproduct);
		dashboardobject.addtocard();
		Assert.assertEquals(dashboardobject.message.getText(), "The product has been added to your shopping cart");
		homeobject.shoppingcartPage();
		shoppingcartobject = new ShoppingcartPage(driver);
		System.out.println(shoppingcartobject.productscart.getText());
		Assert.assertTrue(shoppingcartobject.productscart.getText().contains(desiredproduct));
	}

	@Test(priority = 3, groups = { "Regression" })
	public void addSecondProductTocart() throws InterruptedException {
		// add second item
		homeobject.selectfromtopMenu(productcategory2);
		dashboardobject.selectProduct(desiredproduct2);
		dashboardobject.addtocard();
		System.out.println(shoppingcartobject.productscart.getText());
		Assert.assertEquals(dashboardobject.message.getText(), "The product has been added to your shopping cart");
	}

	@Test(priority = 4, groups = { "Regression" })
	public void removefromShoppingCart() throws InterruptedException {
		homeobject.shoppingcartPage();
		shoppingcartobject.removefromShoppingCart(desiredproduct2);
		Assert.assertTrue(shoppingcartobject.productscart.getText().contains(desiredproduct));
		Assert.assertFalse(shoppingcartobject.productscart.getText().contains(desiredproduct2));
		Thread.sleep(3000);
	}
}
